package no.hvl.dat102;

import no.hvl.data102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT{

	private Film[] filmer;
	private int nesteLedig;
	
	public Filmarkiv(int antall) {
		filmer = new Film[antall];
		nesteLedig = 0;
	}
	
	@Override
	public Film finnFilm(int nr) {
		for(Film f : filmer) 
			if(f.getFilmnr() == nr)
				return f;
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if(nesteLedig == filmer.length)
			utvid();
		
		filmer[nesteLedig] = nyFilm;
		nesteLedig++;
	}

	private void utvid() {
		int lengde = filmer.length;
		Film[] temp = filmer;
		filmer = new Film[lengde * 2];
		for(int i = 0; i < lengde; i++)
			filmer[i] = temp[i];
	}
	
	@Override
	public boolean slettFilm(int filmnr) {
		Film film = finnFilm(filmnr);
		
		boolean slettet = false;
		for(int i = 0; i < nesteLedig - 1 && film != null; i++) {
			if(filmer[i].equals(film))	
				slettet = true;
			if(slettet) 
				filmer[i].equals(filmer[i+1]);
		}

		return finnFilm(filmnr) == null;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] resultat = new Film[nesteLedig];
		int antallResultat = 0;
		
		for(Film f : filmer) {
			if(f.getTittel().contains(delstreng)) {
				resultat[antallResultat] = f;
				antallResultat++;
			}
		}
		
		return trimTabell(resultat, antallResultat);
	}
	
	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] resultat = new Film[nesteLedig];
		int antallResultat = 0;
		
		for(Film f : filmer) {
			if(f.getProdusent().contains(delstreng)) {
				resultat[antallResultat] = f;
				antallResultat++;
			}
		}
		
		return trimTabell(resultat, antallResultat);
	}
	
	private static Film[] trimTabell(Film[] tabell, int lengde) {
		Film[] trimmet = new Film[lengde];
		for(int i = 0; i < lengde; i++)
			trimmet[i] = tabell[i];
		return trimmet;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antall = 0;
		for(int i = 0; i < nesteLedig; i++) {
			if (filmer[i].getSjanger() == sjanger)
				antall++;
		}
		return antall;
	}

	@Override
	public int antall() {
		return nesteLedig;
	}

}
