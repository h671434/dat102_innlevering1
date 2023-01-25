package dat102.klient;

import dat102.Film;
import dat102.Sjanger;
import dat102.adt.FilmArkivADT;

public class Meny {
    private TextUI textUserInterface;
    private FilmArkivADT filmarkiv;

    public Meny(FilmArkivADT film){
        this.textUserInterface = new TextUI();
        this.filmarkiv = film;
    }
    public void start(){
        Film filmA = textUserInterface.lesFilm();
        filmarkiv.addMovie(filmA);
        filmarkiv.addMovie(new Film());
        filmarkiv.addMovie(new Film(2,"producerA", "titleB", 2010, Sjanger.DRAMA, "hollywood stock"));
        filmarkiv.addMovie(new Film(2,"producerB", "titleC", 2019, Sjanger.ACTION, "bolywood co"));
        filmarkiv.addMovie(new Film(2,"producer1", "titleD", 2011, Sjanger.DRAMA, "Oslo ltd"));
        filmarkiv.addMovie(new Film(2,"producer2", "titleE", 2012, Sjanger.HISTORY, "Stockholm comp"));
        filmarkiv.addMovie(new Film(2,"producer3", "titleF", 2013, Sjanger.SCIFI, "blaBla"));
        filmarkiv.addMovie(new Film(2,"producer4", "titleG", 2014, Sjanger.DRAMA, "Test"));

        for(Film film: filmarkiv.getMovieList()) {
            textUserInterface.showMovie(film);
        }

    }

}
