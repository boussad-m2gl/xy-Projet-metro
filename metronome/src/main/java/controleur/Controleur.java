package controleur;

import java.util.ArrayList;
import java.util.Collection;

import observer.Observer;
import observer.Subject;

import model.Horloge;
import model.IHorloge;
import model.MM;
import model.MMImpl;
import presentation.Config;
import presentation.IHM;
import presentation.IIHM;

import command.Click;
import command.Command;
import command.MarquerMesure;
import command.MarquerTemps;

public class Controleur implements GestionnaireEvtMM, GestionnaireIHM, Subject , Observer{

	private MM moteur;
	private IIHM ihm;
	private IHorloge horl;
	private Command cmdTemps;
	private Command cmdMesure;
	private long maxTempo = Config.MaxTempo;
	private long minTempo = Config.MinTempo; 
	private int maxTParM = Config.MaxTempParMesure;
	private int minTParM = Config.MinTempParMesure;
	private long currentTempo = maxTempo;
	private int currentTParM=minTParM;
	private boolean metroActive =false;

	Collection<Observer> obsControlleur = new ArrayList<Observer>();

	private final int INC =1;
	private final int DEC =2;
	
	public Controleur() {

		cmdTemps = new MarquerTemps(this);
		cmdMesure = new MarquerMesure(this);

		moteur = new MMImpl(this);
		moteur.setMarquerTemps(cmdTemps);
		moteur.setMarquerMesure(cmdMesure);
       	moteur.setNbTempsParMesure(currentTParM);
 		
		horl = new Horloge(this);
		horl.activerPeriodiquement(new Click(moteur), (float) 1000 / (currentTempo / 60)); // calculer periode en Mili-second 

		register((MMImpl) moteur);
		register((Horloge) horl);
		
		ihm = new IHM(this);
		register((IHM)ihm);

	}

	/**
	 * Increment le temps par mesure dans la limite de [1.. MaxTParMesure=7]
	 * */
	public void inc() {
		if( ! metroActive)  return;  // guard when twice click on start 
		currentTParM = moteur.getNbTempsParMesure();
		currentTParM = getNextTParM(currentTParM,INC);
		ihm.setCurrentTempParM(currentTParM);
		notifyObservers();
		
	}

	/**
	 * Increment le temps par mesure dans la limite de [1.. MaxTParMesure=7]
	 * */
	public void dec() {
		if( ! metroActive)  return;
		currentTParM = moteur.getNbTempsParMesure();
		currentTParM = getNextTParM(currentTParM, DEC);
		ihm.setCurrentTempParM(currentTParM);
		notifyObservers();
	}

	
	/**
	 * Demarer le metronome
	 * */
	public void start() {
		if( metroActive)  return;
		((Horloge) horl).startChrono();
		metroActive =true;
	}

	/**
	 * Arreter le metronome
	 * 
	 * */
	public void stop() {
		if( ! metroActive)  return;
		((Horloge) horl).stopChrono();
		metroActive =false;
	}

	public int getTempParmesure() {
		return currentTParM;
	}

	public void updateMolette(double molvalue) {
		if( ! metroActive)  return;
		currentTempo = (long) ((maxTempo-minTempo)*molvalue + minTempo);
		notifyObservers();
	}

	public void updateTempo(Integer temp) {
		// TODO Auto-generated method stub

	}

	public void marquerTemps() {

		//System.out.println("  ----- marquer temps CONTROLLEUR ----- ");
		ihm.flasherLed(1); 						
	}

	public void marquerMesure() {

		//System.out.println(" ******  marquer mesure  CONTROLLEUR  *******   ");
		ihm.flasherLed(2); // 					
	}

	public long getTempo() {
		return currentTempo;
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
    
	/**
	 * Retourne the Temps par Mesure suivant
	 * @param val : la valeur actuelle temp par mesure
	 * @param op : l'operation soit incrementer ou decrimenter
	 * */
	private int  getNextTParM(int val, int op){
		
		switch (op){
			case INC: {
				             val +=1 ; return ( (val>maxTParM) ? minTParM :  val );
			          }
				
			case DEC :{
				             val-=1;  return ( (val < minTParM) ? minTParM :  val);
			          }
		    default: return minTParM;
		}
	}
	
}
