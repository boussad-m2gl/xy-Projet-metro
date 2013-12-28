package command;

import controleur.GestionnaireEvtMM;


/**
 * La comande pour marquer la mesure 
 * 
 * */
public class MarquerMesure  implements Command  {
	
  private GestionnaireEvtMM gsmm;
	  
   public MarquerMesure(){}
  
	public MarquerMesure(GestionnaireEvtMM c) {
		gsmm = c;
	}

	public void executer() {
		gsmm.marquerMesure();
	}
	
}
