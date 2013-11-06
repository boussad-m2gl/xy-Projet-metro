package presentation;

import observer.Observer;
import controleur.Controleur;

/**
 * Interface de l'IHM principale
 * 
 * */
public interface IIHM extends Observer{

	public void flasherLED(int numLed);
	public void eteindreLED(int numLed);
	public void setCurrentTempParM(int tempParMesure);
	public void setCurrentTempo(int currentTempo);
	public void setControleur(Controleur cntrl);

}
