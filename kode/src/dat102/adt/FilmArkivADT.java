package dat102.adt;

import dat102.Film;
import dat102.Sjanger;
public interface FilmArkivADT {

    /**
     *
     * @return array with all the film objects
     */
    Film[] getMovieList();
    /**
     * Gets a movie given the number
     * @param nr number of the movie
     * @return movie object with the nr, if no match then null.
     */
   Film finnFilm(int nr);

    /**
     * Adds a movie
     * @param newMovie The movie you want to add
     */
   void addMovie(Film newMovie);

    /**
     * removes movie given the movie num
     * @param movie the number of the movie
     * @return true if removed, if not removed false
     */
   boolean removeMovie(int movie);


    /**
     * Searches for movies given a word
     * @param keyWord the word that has to be in the title
     * @return array of movies with the given title
     */
   Film[] searchTitle(String keyWord);


    /**
     * number of movies in given genre
     * @param genre enum Sjanger (genre)
     * @return number of movies in genre
     */
   int numInGenre(Sjanger genre);

    /**
     *
     * @return Number of movies in archive
     */
   int amount();

}