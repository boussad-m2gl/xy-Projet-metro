package command;

import controleur.GestionnaireEvtMM;
import controleur.GestionnaireIHM;

public class Start  implements Command {

	GestionnaireIHM   gesmm;
	
	public Start(GestionnaireIHM  ges){
		gesmm = ges; 
	}
	 public void executer(){
		gesmm.start();
		
	 }
}
