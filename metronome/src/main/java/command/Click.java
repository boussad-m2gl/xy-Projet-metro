package command;

import model.MM;

/**
 * Click une command utilisé par l'horloge pour commander le moteur
 *  dans le but de marquer le temp 
 * */
public class Click  implements Command {

	private MM moteur;

	public Click(MM mot) {
		moteur = mot;
	}

	public void executer() {
		moteur.click();
	}
  
}
