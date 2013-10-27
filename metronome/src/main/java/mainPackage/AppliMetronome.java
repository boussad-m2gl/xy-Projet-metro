package mainPackage;




import java.util.Timer;
import java.util.TimerTask;

import presentation.IHM;
import presentation.IIHM;
import model.Horloge;
import controleur.Controleur;

/**
 * Main Class pour lancer le metronome
 * @author B
 * @version 1.0
 * 
 * */
public class AppliMetronome {
 	
	 public static void main(String args[]) throws InterruptedException{
		 
		 System.out.println(" Lancement du metronome ..... ");
		 
		 Controleur controleur = new Controleur();
		 controleur.startConfiguration(120);
		// controleur.start();	    
	 }
}
