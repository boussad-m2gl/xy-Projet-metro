package commandPackage;

import modelPackage.MM;

public class Click  implements Command {

	  private MM moteur;
	  
	  public Click (MM mot){
	    moteur= mot;	  
	  } 
	
		public void executer() {
		    moteur.click();
			
		}
  
}
