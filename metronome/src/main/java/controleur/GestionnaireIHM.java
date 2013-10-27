package controleur;

public interface GestionnaireIHM {

	public void updateMolette(double d);
	public void updateTempo(Integer temp);//TODO : courriger le type 
	public void start();
	public void stop();
	public void inc();
	public void dec();
	
}
