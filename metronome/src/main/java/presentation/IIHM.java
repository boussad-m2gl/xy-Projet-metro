package presentation;

/**
 * Interface de l'IHM principale
 * 
 * */
public interface IIHM {

	public void flasherLED(int numLed);

	public void eteindreLED(int numLed);

	public void setCurrentTempParM(int tempParMesure);

}
