package controleurPackage;

import java.util.ArrayList;
import java.util.Collection;

import presentationPackage.IHM;
import presentationPackage.IIHM;
import ObserverPackage.Observer;
import ObserverPackage.Subject;
import modelPackage.Horloge;
import modelPackage.IHorloge;
import modelPackage.MM;
import modelPackage.MMImpl;
import commandPackage.Click;
import commandPackage.Command;
import commandPackage.MarquerMesure;
import commandPackage.MarquerTemps;

public class Controleur  implements GestionnaireEvtMM , GestionnaireIHM , Subject{

	 private MM moteur;
	 private IIHM ihm;
	 private Command cmdTemps;
	 private Command cmdMesure;
	 private long tempo;
	 private int tempParMesure;
	 IHorloge horl;
	 private final int MaxTParMesure = 7;
	 
	 Collection<Observer> obsControlleur = new ArrayList();
	 
	 /**  At configuration time: sequence digramme after command  */
     public void StartConfiguration(long tempo){
    	  
    	  cmdTemps = new MarquerTemps(this);
    	  cmdMesure =  new MarquerMesure(this);
    	  
		  moteur = new MMImpl(this);
    	  moteur.setMarquerTemps(cmdTemps);
		  moteur.setMarquerMesure(cmdMesure);
		  
		  horl = new Horloge(this);
		  Click clickCmd = new Click(moteur);
          horl.activerPeriodiquement(clickCmd,(float) 1000/(tempo/60));	// calculer le periode en ms
          
          // Ajouter  les observateurs de ce controlleur
          
          register((MMImpl)moteur); register((Horloge)horl);
          
          // enfin creer l'IHM 
          ihm = new IHM();
          
      }
	  
	 /**
	  * Increment le temps par mesure dans la limite de [1.. MaxTParMesure=7]
	  * */
    public void Inc(){
    	
    	tempParMesure= ((tempParMesure+1)% (MaxTParMesure+1)); 
    	if(tempParMesure ==0) { tempParMesure=1;}
    	notifyObservers();
    
    }
    
    /**
     * Demarer le metronome 
     * */
    public void start(){
    	horl.startChrono();
    }
    
    /**
     * Arreter le metronome
     * 
     * */
    public void stop(){ 
    	horl.stopChrono(); 
    }
    
    
    public int getTempParmesure(){
    	return tempParMesure;
    }
	public void updateMolette(Integer x) {
		// TODO Auto-generated method stub
		
	}

	public void updateTempo(Integer temp) {
		// TODO Auto-generated method stub
		
	}

	public void marquerTemps() {
	
		System.out.println("  ----- marquer temps CONTROLLEUR ----- ");
		ihm.flasherLed(1);  //TODO:  possible de metre design pattern command vers l'IHM	
	}

	public void marquerMesure() {
		
		System.out.println(" ******  marquer mesure  CONTROLLEUR  *******   ");
		ihm.flasherLed(2); //  //TODO:  possible de metre design pattern command vers l'IHM	
	}


	public long getTempo() {
		   return tempo;
	}

    /**
     * Enregistrement d'un onservervateur
     * */
	public void register(Observer obj) {	
		obsControlleur.add(obj);
	}

    /**
     * Disenregistrement d'un onservervateur
     * */
	public void unregister(Observer obj) {
		obsControlleur.remove(obj);
		
	}

    /**
     * Notification des observateur du chagement de l'etat interne 
     * */
	public void notifyObservers() {
		for(Observer o : obsControlleur){
			o.update();
		}	
	}
	
}
