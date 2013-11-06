package V2Launcher;

import controleur.Controleur;
import adaptateur.AdaptateurImpl;

/**
 *     AppliMetronomeV2 : classe qui permet de lancer la version v2 du metronome
 *     
 * */
public class AppliMetronomeV2 {

	
	public static void main(String[] args) {
		 System.out.println(" Lancement du metronome ..... ");
		 Controleur controleur = new Controleur(new AdaptateurImpl());// inject the Adapter class 
		// controleur.start();	    
	}
	
}
