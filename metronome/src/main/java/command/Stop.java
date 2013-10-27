package command;

import controleur.GestionnaireIHM;

public class Stop  implements Command{
 
  GestionnaireIHM   gesmm;
	
   public Stop(GestionnaireIHM  ges){
		gesmm = ges; 
	}
   public void executer(){
		gesmm.stop(); 
		
  }
   
}
