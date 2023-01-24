package no.hvl.dat102;

import no.hvl.data102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT	{

	private int antall;
	private LinearNode<Film> start;
	
	@Override
	public Film finnFilm(int nr) {
		LinearNode<Film> current = start;
		while(current != null) {
			if(current.getElement().getFilmnr() == nr) {
				return current.getElement();
			} else {
				current = current.getNeste();
			}
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> nyNode = new LinearNode<Film>(nyFilm);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		LinearNode<Film> current = start;
		boolean slettet = false;
		
		if(current.getElement().getFilmnr() == filmnr) {
			start = current.getNeste();
			slettet = true;
		}

		for(int i = 0; i < antall && !slettet; i++) {
			LinearNode<Film> next = current.getNeste();
			if(next.getElement().getFilmnr() == filmnr) {
				current.setNeste(next.getNeste());
				slettet = true;
			}
			current = next;
		}
		
		return slettet;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		LinearNode<Film> current = start;
		Film[] results = new Film[antall];
		int resultnr = 0;
		for(int i = 0; i < antall; i++) {
			if(current.getElement().getTittel().contains(delstreng)) {
				results[resultnr] = current.getElement();
				resultnr++;
			}
			
		}
		return trimTabell(results, resultnr);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		LinearNode<Film> current = start;
		Film[] results = new Film[antall];
		int resultnr = 0;
		for(int i = 0; i < antall; i++) {
			if(current.getElement().getProdusent().contains(delstreng)) {
				results[resultnr] = current.getElement();
				resultnr++;
			}
			current = start.getNeste();
		}
		return trimTabell(results, resultnr);
	}
	
	private static Film[] trimTabell(Film[] tabell, int lengde) {
		Film[] trimmet = new Film[lengde];
		for(int i = 0; i < lengde; i++)
			trimmet[i] = tabell[i];
		return trimmet;
	}

	@Override
	public int antall(Sjanger sjanger) {
		LinearNode<Film> current = start;
		int resultnr = 0;
		for(int i = 0; i < antall; i++) {
			if(current.getElement().getSjanger() == sjanger) {
				resultnr++;
			}
			current = current.getNeste();
		}
		return resultnr;
	}

	@Override
	public int antall() {
		return antall;
	}
	
	
	//TODO oppgave 3i og 3ii
}
