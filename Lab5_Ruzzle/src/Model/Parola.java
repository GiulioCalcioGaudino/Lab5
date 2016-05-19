package Model;

import java.util.ArrayList;
import java.util.List;

public class Parola {
	private List<Character> characters = new ArrayList<Character>();
	private List<Posizione> posizioni = new ArrayList<Posizione>();

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

}
