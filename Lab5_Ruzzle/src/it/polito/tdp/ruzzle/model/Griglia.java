package it.polito.tdp.ruzzle.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Griglia{
	
	private int N ;
	
	public Map<Posizione,Character> caselle ;
	private List<Posizione> posizioni ;

	/** 
	 * Crea una scacchiera vuota di lato N
	 * @param n
	 */
	public Griglia () {
		N = 4;
		caselle = new LinkedHashMap<Posizione,Character>() ;
		
		// definisci le posizioni valide
		posizioni = new ArrayList<Posizione>() ;
		for( int riga = 1 ; riga <= N; riga++ ) {
			for( int col = 1; col <= N; col++ ) {
				posizioni.add(new Posizione(riga, col)) ;
			}
		}
		
	}
	
	public Character get(Posizione p) {
		return caselle.get(p) ;
	}
	
	public void set(Posizione p, Character i) {
		if( caselle.get(p)==null )
			caselle.put(p, i) ;
		else
			throw new RuntimeException("Casella già occupata") ;
	}
	
	public void delete(Posizione p) {
		if( caselle.get(p)!=null ) 
			caselle.put(p, null) ;
		else
			throw new RuntimeException("Casella già vuota") ;
	}
	
	public boolean valid(Posizione p) {
		return posizioni.contains(p) ;
	}
	
	public int size() {
		return posizioni.size() ;
	}
	
	public List<Posizione> getPosizioni() {
		return posizioni ;
	}
	
	

	
}

