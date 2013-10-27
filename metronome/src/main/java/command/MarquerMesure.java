package command;

import controleur.GestionnaireEvtMM;

public class MarquerMesure  implements Command  {
	
  private GestionnaireEvtMM gsmm;
	  
	  public MarquerMesure(GestionnaireEvtMM c){
	    gsmm= c;
	 }
	 
	public void executer() {
		
		 gsmm.marquerMesure();		
	}
	 

}
