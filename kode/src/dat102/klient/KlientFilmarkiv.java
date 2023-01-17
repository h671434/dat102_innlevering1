package dat102.klient;
import dat102.*;
import dat102.adt.FilmArkiv;
import dat102.adt.FilmArkivADT;

public class KlientFilmarkiv {
    public static void main(String[] args){
        FilmArkivADT filma = new FilmArkiv(100);
        Meny meny = new Meny(filma);
        meny.start();
    }
}
