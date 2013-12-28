package V2Launcher;

import controleur.Controleur;
import adaptateur.AdaptateurImpl;

/**
 * AppliMetronomeV2 : classe qui permet de lancer la version v2 du metronome
 * @author Boussad GHEDAMSI
 * @author 2: ChenCheng Pu
 * @author 3: Houda Argani
 * */
public class AppliMetronomeV2 {

	public static void main(String[] args) {
		System.out.println(" Lancement du metronome V2..... ");
		Controleur controleur = new Controleur(new AdaptateurImpl());// inject the Adapter class							
		// controleur.start();  // no need cause we can launch it from the hardware button
	}
}
