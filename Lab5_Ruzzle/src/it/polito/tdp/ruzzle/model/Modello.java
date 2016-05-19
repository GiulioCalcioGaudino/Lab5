package it.polito.tdp.ruzzle.model;
import java.util.*;

public class Modello {

	
	public Griglia generaGriglia (){
		Griglia gtemp = new Griglia();
		Random r = new Random();
	    String alphabet = "QERTUIOPLHGFDSAZCVBNM";
		for (int i=1; i<=4; i++){
			for(int j=1; j<=4; j++){
				
			        char c = alphabet.charAt(r.nextInt(alphabet.length()));
//				char c = (char)(r.nextInt(26) + 'a');
				
				Posizione ptemp = new Posizione (i,j);
				
				gtemp.set(ptemp, c);
			}
			
		}
		return gtemp;
	}
	
	
	
	
}
