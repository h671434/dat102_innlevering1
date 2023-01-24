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
        filmarkiv.addMovie(new Film(2,"producerA", "titleB", 2010, Sjanger.DRAMA, "hollywood"));

        textUserInterface.showMovie(filmA);

    }

}
