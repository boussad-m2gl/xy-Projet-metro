package model;

import observer.Observer;
import presentation.Config;
import command.Command;
import command.MarquerMesure;
import command.MarquerTemps;
import controleur.GestionnaireEvtMM;

/**
 * MMImpl : Le moteur qui contient le code metier de l'application
 * 
 * */
public class MMImpl implements MM, Observer {

	private GestionnaireEvtMM controlleur;
	private MarquerTemps markT;
	private MarquerMesure markM;
	private int mesurecounter = 1;
	private int tempParMesure = 1;
	private boolean enMarche = false;
	// Tempo
	private long maxTempo = Config.MaxTempo;
	private long minTempo = Config.MinTempo;
	private long currentTempo = maxTempo;

	public MMImpl(){}
	
	public MMImpl(GestionnaireEvtMM controlleur) {
		this.controlleur = controlleur;
	}

	/**
	 * Permet de marquer temp ou de marquer mesure
	 * 
	 * */
	public void click() {

		markT.executer();
		if (mesurecounter == tempParMesure) {
			markM.executer();
			mesurecounter = 1;
		} else
			mesurecounter++;
	}

	/***/
	public int getNbTempsParMesure() {

		return tempParMesure;
	}

	public void setNbTempsParMesure(Integer n) {
		tempParMesure = n;
	}

	public void setEnMarche(boolean marche) {
		enMarche = marche;
	}

	public boolean getEnMarche() {
		return enMarche;
	}

	public void setGestionnaireEvtMM(GestionnaireEvtMM MM) {
		controlleur = MM;
	}

	/**
	 * Enregistre la commande marquer temp
	 */
	public void setMarquerTemps(Command cmdTemps) {

		markT = (MarquerTemps) cmdTemps;
	}

	/**
	 * Enregistre la commande marquer mesure
	 * 
	 * */
	public void setMarquerMesure(Command cmdMesure) {

		markM = (MarquerMesure) cmdMesure;
	}

	/**
	 * Mise a jour de l'etat interne (tempParMesure) vis a vis de Controleur
	 * */
	public void update() {
		tempParMesure = controlleur.getTempParmesure();
		mesurecounter = 1;
	}

	public long getTempo() {
		return currentTempo;
	}

	public void setTempo(float modeletValue) {

		currentTempo = (long) ((maxTempo - minTempo) * modeletValue + minTempo);
		controlleur.updateTempo(currentTempo);
	}

}
