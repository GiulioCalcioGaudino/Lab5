package it.polito.tdp.ruzzle.model;

import java.util.ArrayList;
import java.util.List;

public class Parola implements Comparable{
	private List<Character> characters = new ArrayList<Character>();
	private List<Posizione> posizioni = new ArrayList<Posizione>();

	public Parola() {
	}

	public Parola(Parola p) {
		characters = new ArrayList<Character>(p.getCharacters());
		posizioni = new ArrayList<Posizione>(p.getPositions());
	}

	public List<Character> getCharacters() {
		return characters;
	}

	public List<Posizione> getPositions() {
		return posizioni;
	}

	public String getString() {
		StringBuilder sb = new StringBuilder();
		for (Character c : characters) {
			sb.append(c);
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return "[characters=" + characters + ", positions=" + posizioni + "]\n";
	}


	public int compareTo (Object o) {
		Parola altra = (Parola) o;
		return this.posizioni.size()-altra.posizioni.size();
	}

}
