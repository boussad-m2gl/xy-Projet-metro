package mainPackage;




import java.util.Timer;
import java.util.TimerTask;

import presentationPackage.IHM;
import presentationPackage.IIHM;
import modelPackage.Horloge;
import controleurPackage.Controleur;

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
		 controleur.StartConfiguration(120);
	     controleur.start();		 
	     //IIHM  ihm = new IHM();
	 }
	 
}
