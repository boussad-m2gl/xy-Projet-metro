package presentation;


/**
 * Interface de l'IHM principale 
 * 
 * */
public interface IIHM {

	public void flasherLed(int idLed);
	public void eteindreLed();
	public void setCurrentTempParM(int tempParMesure);
	
}
