package command;

import controleur.GestionnaireIHM;

public class Dec   implements Command{

	
    private GestionnaireIHM   gesmm;
	
	 public  Dec(GestionnaireIHM  ges){
		gesmm = ges; 
	}
	 public void executer(){
		 gesmm.dec();
	 }
}
