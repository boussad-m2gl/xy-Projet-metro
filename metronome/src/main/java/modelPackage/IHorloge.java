package modelPackage;

import commandPackage.Command;

public interface IHorloge {

	/**
	 *  Appel periodiquement  de l'operation executer() de cmd 
	 *  toutes les periodesEnSecondes secondes, avec une precision en milisecondes   
	 * */
	public void activerPeriodiquement(Command cmd, float periodEnMSecondes);
	
	/**
	 *  Appel de l'operation executer() de cmd, apres un delais  delaisEnSecond en milsecond  
	 * */
	void activerApresDelais(Command cmd,  float delaisEnMSecond);
	
	void desactiver(Command cmd);
	
	public void startChrono();
	public void stopChrono();
	
	
}
