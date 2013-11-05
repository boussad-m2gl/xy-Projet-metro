package controleur;


/**
 *  Gestion des evenements de l'IHM
 * */
public interface GestionnaireIHM {

	public void updateMolette(double d);
	public void start();
	public void stop();
	public void inc();
	public void dec();
	public long getTempo();
	
}
