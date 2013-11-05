package command;

import controleur.GestionnaireIHM;


/**
 * La commande Stop: order au controlleur d'arreter le moteur 
 * 
 * */
public class Stop  implements Command{
 
	private GestionnaireIHM gesmm;

	public Stop(GestionnaireIHM ges) {
		gesmm = ges;
	}

	public void executer() {
		gesmm.stop();
	}
   
}
