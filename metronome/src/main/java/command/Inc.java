package command;

import controleur.GestionnaireIHM;

public class Inc implements Command {

    private GestionnaireIHM   gesmm;
	
	public Inc(GestionnaireIHM  ges){
		gesmm = ges; 
	}
	 public void executer(){
		 gesmm.inc();
	 }
	 
}
