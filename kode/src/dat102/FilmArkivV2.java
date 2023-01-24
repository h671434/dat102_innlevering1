package dat102;

import dat102.adt.FilmArkivADT;
import dat102.LinearNode;
public class FilmArkivV2 implements FilmArkivADT {
    private int antall;
    private LinearNode<Film> start;

    public FilmArkivV2(){
        this.antall = 0;
        this.start = null;
    }

    @Override
    public void addMovie(Film newMovie) {
        LinearNode<Film> newNode = new LinearNode<Film>(newMovie);
        newNode.setNeste(start);
        this.start = newNode;
        antall++;
    }

    @Override
    public boolean removeMovie(int movie) {
        LinearNode<Film> aktivNode = start;
        if(aktivNode.getElement().getMovieNum() == movie){
            start = start.getNeste();
            antall--;
            return true;
        }
        boolean funnet = false;
        while(!funnet){
            funnet = aktivNode.getNeste().getElement().getMovieNum() == movie;
            aktivNode = aktivNode.getNeste();
        }

        return funnet;
    }

    @Override
    public int amount() {
        return antall;
    }

    @Override
    public Film finnFilm(int nr) {


        return null;
    }

    @Override
    public Film[] searchTitle(String keyWord) {
        return new Film[0];
    }

    @Override
    public int numInGenre(Sjanger genre) {
        return 0;
    }

    @Override
    public Film[] getMovieList() {
        return new Film[0];
    }
}
