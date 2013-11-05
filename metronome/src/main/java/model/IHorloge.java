package model;

import command.Command;


/**
 * Interface de l'horloge
 * */

public interface IHorloge {
	
	public void activerPeriodiquement(Command cmd, float periodEnMSecondes);
	void activerApresDelais(Command cmd,  float delaisEnMSecond);
	void desactiver(Command cmd);

}
