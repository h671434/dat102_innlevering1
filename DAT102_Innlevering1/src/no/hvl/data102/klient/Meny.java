package no.hvl.data102.klient;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.data102.adt.FilmarkivADT;

public class Meny {
	private TekstGrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;
	
	public Meny(FilmarkivADT filmarkiv) {
		tekstgr = new TekstGrensesnitt();
		this.filmarkiv = filmarkiv;
	}
	
	public void start() {
		Film a = new Film(1, "Rob Minkoff", "Lion King", 1994, Sjanger.DRAMA, "Disney");
		Film b = new Film(2, "Jarg Barg", "Alien Spaceships", 1772, Sjanger.HISTORY, "USA");
		Film c = new Film(3, "Bing Bong", "Down", 2031, Sjanger.HISTORY, "Universal");
		
		filmarkiv.leggTilFilm(a);
		filmarkiv.leggTilFilm(b);
		filmarkiv.leggTilFilm(c);
	}
}
