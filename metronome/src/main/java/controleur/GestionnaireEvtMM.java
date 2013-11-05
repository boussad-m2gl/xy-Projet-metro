package controleur;

/**
 *  Gestion des evenements du moteur 
 * */
public interface GestionnaireEvtMM {
	
	public void marquerTemps();
	public void marquerMesure();
	public int getTempParmesure();
	public long getTempo();
	public void updateTempo(long tempo); 
	
}
