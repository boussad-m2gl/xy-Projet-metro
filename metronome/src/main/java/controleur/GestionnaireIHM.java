package controleur;

public interface GestionnaireIHM {

	public void updateMolette(Integer x);
	public void updateTempo(Integer temp);//TODO : courriger le type 
	public void start();
	public void stop();
	public void inc();
	public void dec();
	
}
