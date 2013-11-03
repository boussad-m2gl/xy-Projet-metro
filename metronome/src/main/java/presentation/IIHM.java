package presentation;


/**
 * Interface de l'IHM principale 
 * 
 * */
public interface IIHM {

	public void flasherLed(int numLed);
	public void eteindreLed(int numLed);
	public void setCurrentTempParM(int tempParMesure);
	
}
