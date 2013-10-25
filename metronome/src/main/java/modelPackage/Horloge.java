package modelPackage;

import java.util.Timer;
import java.util.TimerTask;

import ObserverPackage.Observer;
import commandPackage.Click;
import commandPackage.Command;
import controleurPackage.GestionnaireEvtMM;
import controleurPackage.GestionnaireIHM;

public class Horloge  implements IHorloge, Observer {
	
    private GestionnaireEvtMM controleur;  // l'horloge connait son controlleur tous comme le moteur
	private Command clickC;
    private long periodActiveCmd;
	private Timer timer;
	
	public Horloge(GestionnaireEvtMM controlleur){
		
	  this.controleur = controlleur;
	  timer = new Timer();   
	}
	
    /**
     * Commence le chronometrage  pour executer une tache / command internce clickC
     * */ 
	public void startChrono(){
		 timer.schedule(new TimerTask() {

             @Override
             public void run() {
                 clickC.executer();
             }
         }, 0, periodActiveCmd);
	}
	
	/**
	 * Arrete l'executation de la tache en cours
	 * */
	public void stopChrono(){
		timer.cancel();
	}
	
	/**
	 * Permet d'activer periodiquement une command apres delais en MiliSecond
	 * */
	public void activerPeriodiquement(Command cmdClick, float periodEnMSecondes) {
		
		clickC = cmdClick;
		periodActiveCmd = (long)periodEnMSecondes;
	}
    /**
     * Permet d'activer une command apres un delais 
     * */
	public void activerApresDelais(Command cmd, float delaisEnSecond) {
		
		
		timer.cancel();
		timer.schedule(new TimerTask() {

             @Override
             public void run() {
                 clickC.executer();
             }
         },  (long) delaisEnSecond);
		
	}

	public void desactiver(Command cmd) {
		 stopChrono();	
	}

    /**
     * Mise a jour le t'etat interne de l'horloge vis avis de son controleur
     * 
     * */
	public void update() {
		
		periodActiveCmd = 1000/(controleur.getTempo()/60); 
		timer.cancel();
		timer.schedule(new TimerTask() {

             @Override
             public void run() {
                 clickC.executer();
             }
         }, 0, periodActiveCmd);
		
	}
	

}
