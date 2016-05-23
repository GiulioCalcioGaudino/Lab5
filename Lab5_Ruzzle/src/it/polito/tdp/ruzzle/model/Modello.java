package it.polito.tdp.ruzzle.model;

import java.util.*;

import it.polito.tdp.ruzzle.dao.ParolaDAO;

public class Modello {
	ParolaDAO paroladao = new ParolaDAO();
	List<Parola> parole = new ArrayList<Parola>();

	public Griglia generaGriglia() {
		Griglia gtemp = new Griglia();
		Random r = new Random();
		String alphabet = "QERTUIOPLHGFDSAZCVBNM";
		for (int i = 0; i < 16; i++) {

			char c = alphabet.charAt(r.nextInt(alphabet.length()));
			// char c = (char)(r.nextInt(26) + 'a');
			Posizione ptemp = gtemp.getPosizioni().get(i);

			gtemp.set(ptemp, c);

		}
		return gtemp;
	}

	public List<Parola> generaParole(Griglia gr) {
		parole.clear();

		ric(gr, 1, new Parola());

		return parole;
	}

	public void ric(Griglia g, int passo, Parola p) {
		boolean flag = false;
		if (passo > 2) {
			if (!paroladao.cercaSequenza(p.getString()))
				return;
			if (paroladao.cerca(p.getString())) {
				Parola patemp = new Parola(p);
				parole.add(patemp);
			}
		}
		if (passo == 16) {
			if (paroladao.cerca(p.getString())) {
				Parola patemp = new Parola(p);
				parole.add(patemp);
				return;
			}
		}
		for (int i = 0; i < 16; i++) {
			Posizione ptemp = g.getPosizioni().get(i);
			if (p.getPositions().size() != 0) {
				if (!p.getPositions().contains(ptemp)
						&& isValida(ptemp, p.getPositions().get(p.getPositions().size() - 1))) {
					p.getCharacters().add(g.get(ptemp));
					p.getPositions().add(ptemp);
					flag = true;
				}
			} else {
				p.getCharacters().add(g.get(ptemp));
				p.getPositions().add(ptemp);
				flag = true;
			}
			if (flag) {
				ric(g, passo + 1, new Parola(p));
				// backtrack
				p.getCharacters().remove(g.get(ptemp));
				p.getPositions().remove(ptemp);
				flag = false;
			}

		}

	}

	public boolean isValida(Posizione a, Posizione b) {
		if ((Math.abs(a.getCol() - b.getCol()) == 1 && Math.abs(a.getRiga() - b.getRiga()) == 0)
				|| (Math.abs(a.getRiga() - b.getRiga()) == 1 && Math.abs(a.getCol() - b.getCol()) == 0)
				|| (Math.abs(a.getCol() - b.getCol()) == 1 && Math.abs(a.getRiga() - b.getRiga()) == 1)) {
			return true;
		}
		return false;
	}
	
	public List<Parola> ordinaParole (){
		Collections.sort(parole);
		return parole;
	}

}
