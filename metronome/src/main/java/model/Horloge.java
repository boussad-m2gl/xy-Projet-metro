package model;

import java.util.Timer;
import java.util.TimerTask;

import observer.Observer;

import command.Click;
import command.Command;
import controleur.GestionnaireEvtMM;
import controleur.GestionnaireIHM;

public class Horloge  implements IHorloge, Observer {
	
    private GestionnaireEvtMM controleur;  // l'horloge connait son controlleur tous comme le moteur
	private Command clickC;
    private long periodActiveCmd;
	private Timer timer;
	private Timer timer2 = new Timer();
	private Timer timer3 = new Timer();
	
	public Horloge(GestionnaireEvtMM controlleur){
	  this.controleur = controlleur;
	  timer = new Timer();
	}
	
	
	public Horloge(){
		 timer = new Timer();   
	}	
	
    /**
     * Commence le chronometrage  pour executer une tache / command internce clickC
     * */ 
	public void startChrono(){
		 timer = new Timer();
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
	public  void activerApresDelais( Command cmd, float delaisEnSecond) {
		
		final Command cmtToExecute = cmd;
		
			timer2.schedule(new TimerTask() {
	
	             @Override
	             public void run() {
	            	 cmtToExecute.executer();
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
		stopChrono();
		periodActiveCmd =   (long) ((new Double(1000))/(new Double(controleur.getTempo())/60)); 
		startChrono();	
	}

}
