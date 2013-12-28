package command;

import controleur.GestionnaireEvtMM;


/**
 * La comande pour marquer la temps
 * 
 * */

public class MarquerTemps implements Command {
	
	private GestionnaireEvtMM gstmm;

	public MarquerTemps(){}
	
	public MarquerTemps(GestionnaireEvtMM c) {
		gstmm = c;
	}

	public void executer() {
		gstmm.marquerTemps();
	}

}

