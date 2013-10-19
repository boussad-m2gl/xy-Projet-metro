package commandPackage;

import controleurPackage.GestionnaireEvtMM;

public class MarquerTemps implements Command {

	
	 private GestionnaireEvtMM gstmm;
	 
	 public MarquerTemps(GestionnaireEvtMM c){
	    gstmm= c;
	 }


	public void executer() {
		gstmm.marquerTemps();	
	} 
	 
}

