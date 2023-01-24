package dat102;

import dat102.Film;
import dat102.Sjanger;
import dat102.adt.FilmArkivADT;

public class FilmArkiv implements FilmArkivADT {

    private Film[] movieList;
    private int nextFree;

    public FilmArkiv(){

    }
    public FilmArkiv(int nMovies){
        this.movieList = new Film[nMovies];
        this.nextFree = 0;
    }

    @Override
    public Film[] getMovieList(){
        return movieList;
    }

    private void extend(){
        Film[] newMovieList = new Film[movieList.length * 2];
        System.arraycopy(newMovieList, 0, movieList, 0, movieList.length);
        this.movieList = newMovieList;
    }



    @Override
    public Film finnFilm(int nr) {
        boolean funnet = false;
        Film match = null;
        for(int i = 0; i < nextFree && !funnet; i ++){
            funnet = movieList[i].getMovieNum() == nr;
            match = funnet? movieList[i] : null;
        }

        return match;
    }

    @Override
    public void addMovie(Film newMovie) {
        if(movieList[movieList.length-1] != null) extend();
        movieList[nextFree] = newMovie;
        this.nextFree++;
    }

    @Override
    public boolean removeMovie(int movienr) {
        boolean match = false;
        Film movie = finnFilm(movienr);
        for(int i = 0 ; i < nextFree && !match ; i++){
            match = movieList[i].equals(movie);
            if(match) {
                movieList[i] = movieList[nextFree-1];
                nextFree--;
            }
        }
        return match;
    }

    @Override
    public Film[] searchTitle(String keyWord) {
        Film[] matchList = new Film[nextFree];
        int matches = 0;
        for(int i = 0 ; i < nextFree ; i++){
            if(movieList[i].getTitle().contains(keyWord)){
                matchList[matches] = movieList[i];
                matches++;
            }
        }

        Film[] newMatchList = new Film[matches];
        System.arraycopy(newMatchList, 0, matchList, 0, matches);
        return newMatchList;
    }

    @Override
    public int numInGenre(Sjanger genre) {
        int numInGenre = 0;
        for(Film f : movieList){
            if(f.getGenre()== genre) numInGenre++;
        }

        return numInGenre;
    }

    @Override
    public int amount() {
        return nextFree;
    }
}
