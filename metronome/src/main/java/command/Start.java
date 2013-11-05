package command;

import controleur.GestionnaireIHM;

/**
 * La commande Start: order au controlleur de demmarer le moteur 
 * 
 * */
public class Start  implements Command {

	GestionnaireIHM gesmm;

	public Start(GestionnaireIHM ges) {
		gesmm = ges;
	}

	public void executer() {
		gesmm.start();

	}
}
