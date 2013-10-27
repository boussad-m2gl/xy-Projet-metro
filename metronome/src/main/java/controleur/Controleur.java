package controleur;

import java.util.ArrayList;
import java.util.Collection;

import observer.Observer;
import observer.Subject;

import model.Horloge;
import model.IHorloge;
import model.MM;
import model.MMImpl;
import presentation.IHM;
import presentation.IIHM;

import command.Click;
import command.Command;
import command.MarquerMesure;
import command.MarquerTemps;

public class Controleur implements GestionnaireEvtMM, GestionnaireIHM, Subject , Observer{

	private MM moteur;
	private IIHM ihm;
	private Command cmdTemps;
	private Command cmdMesure;
	private long tempo = 120;
	private int tempParMesure;
	private IHorloge horl;
	private final int MaxTParMesure = 7;

	Collection<Observer> obsControlleur = new ArrayList<Observer>();

	/** At configuration time: sequence digramme after command */
	public void startConfiguration(long tempo) {

		cmdTemps = new MarquerTemps(this);
		cmdMesure = new MarquerMesure(this);

		moteur = new MMImpl(this);
		moteur.setMarquerTemps(cmdTemps);
		moteur.setMarquerMesure(cmdMesure);
       	
 		//moteur.setNbTempsParMesure(4);
 		
		horl = new Horloge(this);
		Click clickCmd = new Click(moteur);
		horl.activerPeriodiquement(clickCmd, (float) 1000 / (tempo / 60)); // calculer periode en Milil second 
	
		// Ajouter les observateurs de ce controlleur

		register((MMImpl) moteur);
		register((Horloge) horl);

		// enfin creer l'IHM
		ihm = new IHM(this);

	}

	/**
	 * Increment le temps par mesure dans la limite de [1.. MaxTParMesure=7]
	 * */
	public void inc() {
		tempParMesure = moteur.getNbTempsParMesure();
		tempParMesure = ((tempParMesure) % (MaxTParMesure))  + 1;
		ihm.setCurrentTempParM(tempParMesure);
		notifyObservers();
		//moteur.setNbTempsParMesure(tempParMesure);
	}

	/**
	 * Increment le temps par mesure dans la limite de [1.. MaxTParMesure=7]
	 * */
	public void dec() {
		tempParMesure = moteur.getNbTempsParMesure();
		tempParMesure = tempParMesure -1 ;
		if(tempParMesure == 0) { tempParMesure =1;}
		ihm.setCurrentTempParM(tempParMesure);
		notifyObservers();
	}

	
	/**
	 * Demarer le metronome
	 * */
	public void start() {
		horl.startChrono();
	}

	/**
	 * Arreter le metronome
	 * 
	 * */
	public void stop() {
		horl.stopChrono();
	}

	public int getTempParmesure() {
		return tempParMesure;
	}

	public void updateMolette(Integer x) {
		// TODO Auto-generated method stub

	}

	public void updateTempo(Integer temp) {
		// TODO Auto-generated method stub

	}

	public void marquerTemps() {

		//System.out.println("  ----- marquer temps CONTROLLEUR ----- ");
		ihm.flasherLed(1); // TODO: possible de metre design pattern command
							// vers l'IHM
	}

	public void marquerMesure() {

		//System.out.println(" ******  marquer mesure  CONTROLLEUR  *******   ");
		ihm.flasherLed(2); // //TODO: possible de metre design pattern command
							// vers l'IHM
	}

	public long getTempo() {
		return tempo;
	}

	/**
	 * Enregistrement d'un onservervateur
	 * */
	public void register(Observer obj) {
		obsControlleur.add(obj);
	}

	/**
	 * Disenregistrement d'un onservervateur
	 * */
	public void unregister(Observer obj) {
		obsControlleur.remove(obj);

	}

	/**
	 * Notification des observateur du chagement de l'etat interne
	 * */
	public void notifyObservers() {
		for (Observer o : obsControlleur) {
			o.update();
		}
	}

	public void update() {
		
	}

}
