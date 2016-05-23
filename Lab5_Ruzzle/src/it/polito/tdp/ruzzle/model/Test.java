package it.polito.tdp.ruzzle.model;

import it.polito.tdp.ruzzle.dao.ParolaDAO;

public abstract class Test {

	public static void main(String[] args) {
		ParolaDAO padao = new ParolaDAO();
		Modello m = new Modello();
		Griglia gri = m.generaGriglia();
		System.out.println(gri.caselle.values());
		System.out.println(padao.cercaSequenza("cdf"));
		m.generaParole(gri);
		for (int i = 0; i < m.parole.size(); i++) {
			System.out.println(m.parole.get(i).getString());
		}
	}
}