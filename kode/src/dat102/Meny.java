package dat102;

import dat102.adt.FilmArkivADT;

public class Meny {
    private String textUI;
    private FilmArkivADT filmarkiv;

    public Meny(FilmArkivADT film){
        textUI = new TextUI();
        this.filmarkiv = film;
    }
    public void start(){
        //TODO
    }

}
