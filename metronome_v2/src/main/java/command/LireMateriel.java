package command;

import adaptateur.Adaptateur;


/**
 * 
 * Command to read the hardware 
 * 
 * */
public class LireMateriel  implements Command {

	Adaptateur adaptateurIhm;
	
	public LireMateriel(Adaptateur Ihm) {
		  this.adaptateurIhm = Ihm;
	}
	public void executer() {
		this.adaptateurIhm.lireMateiel();
	}	
}
