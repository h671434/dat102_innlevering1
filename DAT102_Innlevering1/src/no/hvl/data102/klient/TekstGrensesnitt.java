package no.hvl.data102.klient;

import java.util.Scanner;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.data102.adt.FilmarkivADT;

public class TekstGrensesnitt {
	// lese opplysningene om en FILM fra tastatur
	public Film lesFilm(){
		Scanner sc = new Scanner(System.in);
		Film film = new Film();
		
		boolean complete = false;
		while(!complete) {
			try {
				System.out.println("Filmnr / Produsent / Tittel / Årstall / Sjanger / Selskap");
				
				String[] input = sc.nextLine().split(" ");
				int nr = Integer.valueOf(input[0]);
				String produsent = input[1];
				String tittel = input[2];
				int aar = Integer.valueOf(input[3]);
				Sjanger sjanger = Sjanger.finnSjanger(input[4]);
				String selskap = input[5];
				
				film = new Film(nr, produsent, tittel, aar, sjanger, selskap);
				
				complete = true;
			} catch(Exception e) {
				System.out.println("Input format feil");
			}
		}
	
		sc.close();
		
		return film;
	}
	
	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) {
		System.out.println(""
				+ film.getFilmnr()  + " " 
				+ film.getProdusent() + " "
				+ film.getTittel() + " "
				+ film.getLanseringsaar() + " "
				+ film.getSjanger().toString() + " "
				+ film.getFilmselskap());
	}
	
	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, 
			String delstreng) {
		Film[] soekResultat = filma.soekTittel(delstreng);
		for(Film film : soekResultat) {
			visFilm(film);
		}
	}
	
	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
		Film[] soekResultat = filma.soekProdusent(delstreng);
		for(Film film : soekResultat) {
			visFilm(film);
		}
	}
	
	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(FilmarkivADT filma) {
		System.out.println("Totalt antall: " + filma.antall());
		System.out.println("Action antall: " + filma.antall(Sjanger.ACTION));
		System.out.println("Drama antall: " + filma.antall(Sjanger.DRAMA));
		System.out.println("History antall: " + filma.antall(Sjanger.HISTORY));
		System.out.println("SciFi antall: " + filma.antall(Sjanger.SCIFI));
	}
	
	// … Ev. andre metoder
}
