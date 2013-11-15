package mainPackage;


import presentation.IHM;
import controleur.Controleur;

/**
 * AppliMetronome : Class Qui permet de lancer la version v1 du metronome
 *
 * @author Boussad GHEDAMSI
 * @author 2: ChenCheng Pu
 * @author 3: Houda Argani
 * 
 * */
public class AppliMetronome {
 	
	
	 public static void main(String args[]) throws InterruptedException {
		 
		 System.out.println(" Lancement du metronome ..... ");
		 Controleur controleur = new Controleur(new IHM());
		 // controleur.start();	   // don't need that cause it will be launched by click on start button 
	 }

}
