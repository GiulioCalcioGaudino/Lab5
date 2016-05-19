package Model;
import java.util.*;

public class Modello {

	
	public Griglia generaGriglia (){
		Griglia gtemp = new Griglia();
		for (int i=1; i<=4; i++){
			for(int j=1; j<=4; j++){
				
				Random r = new Random();
				char c = (char)(r.nextInt(26) + 'a');
				
				Posizione ptemp = new Posizione (i,j);
				
				gtemp.set(ptemp, c);
				
			}
			
		}
		return gtemp;
	}
	
	
	
	
}
