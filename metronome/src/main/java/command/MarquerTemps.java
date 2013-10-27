package command;

import controleur.GestionnaireEvtMM;

public class MarquerTemps implements Command {

	
	 private GestionnaireEvtMM gstmm;
	 
	 public MarquerTemps(GestionnaireEvtMM c){
	    gstmm= c;
	 }


	public void executer() {
		gstmm.marquerTemps();	
	} 
	 
}

