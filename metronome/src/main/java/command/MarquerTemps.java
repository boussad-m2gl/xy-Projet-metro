package command;

import controleur.GestionnaireEvtMM;
import java.awt.*;
import org.jfugue.Player;

public class MarquerTemps implements Command {
	
	 private GestionnaireEvtMM gstmm;
	 
	 public MarquerTemps(GestionnaireEvtMM c){
	    gstmm= c;
	 }
	 
	 public void executer() {
		gstmm.marquerTemps();	
	 } 
	 
}

