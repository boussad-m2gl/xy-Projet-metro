package model;

import command.Command;

import controleur.GestionnaireEvtMM;

/**
 * Interface de MMImpl qui est le Moteur
 * 
 * @version 0.1

 */

public interface MM {

	public long getTempo();

	public void setTempo(float tempo);

	public int getNbTempsParMesure();

	public void setNbTempsParMesure(Integer n);

	public void setEnMarche(boolean x);

	public boolean getEnMarche();

	public void setGestionnaireEvtMM(GestionnaireEvtMM MM);

	public void setMarquerTemps(Command cmdTemps);

	public void setMarquerMesure(Command cmdMesure);

	public void click();

}
