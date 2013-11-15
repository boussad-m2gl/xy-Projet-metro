package adaptateur;

import command.Command;
import command.Eteindre;
import command.LireMateriel;
import controleur.Controleur;
import controleur.GestionnaireIHM;
import materiel.Materiel;
import model.Horloge;
import presentation.ClavierImpl;
import presentation.Simulateur;

/**
 * 
 * 
 * */

public class AdaptateurImpl implements Adaptateur {

	private final int LED1 = 1;
	private final int LED2 = 2;
    
	private final int delaisLectureMateriel=200; // ms
	
	private Materiel ihmSIM; // The simulated IHM
	private GestionnaireIHM controler;
	
	private Eteindre cmdEteindreLed1, cmdEtiendreLed2;
	private Horloge hcmd;
    private Command lireMateriel;
	
	
	public AdaptateurImpl() {
	
	}
	
	public void setControleur(Controleur cntrl) {
		this.controler = cntrl;
		configure();
	}

	/**
	 * Initiate some basic configurations for the Adapter
	 * 
	 * */
	private void configure(){
		
		this.ihmSIM = new Simulateur();
		cmdEteindreLed1 = new Eteindre(ihmSIM.getAfficheur().getLED(LED1));
		cmdEtiendreLed2 = new Eteindre(ihmSIM.getAfficheur().getLED(LED2));
		hcmd = new Horloge();
		lireMateriel = new LireMateriel(this);  // command to read the hardware
		// program the first reading of the hardware
		hcmd.activerApresDelais(lireMateriel, delaisLectureMateriel);
	}
	
	public void flasherLED(int numLed) {
		switch (numLed) {
		case LED1: {
			ihmSIM.getAfficheur().flasher(LED1);
			hcmd.activerApresDelais(cmdEteindreLed1, 200);

		}
			;
			break;

		case LED2: {
			ihmSIM.getAfficheur().flasher(LED2);
			hcmd.activerApresDelais(cmdEtiendreLed2, 200);
		}
			;
			break;
		default:
			;
		}
	}

	public void eteindreLED(int numLed) {
		switch (numLed) {
		case LED1:
			ihmSIM.getAfficheur().eteindre(LED1);
			break;
		case LED2:
			ihmSIM.getAfficheur().eteindre(LED2);
		}
	}

	/**
	 * Set the new Tempo par Mesure within the displayer
	 * */

	public void setCurrentTempParM(int tempParMesure) {
		ihmSIM.getAfficheur().getJTextAfficheurTparM()
				.setText(String.valueOf(tempParMesure));
	}
    /**
     * Upon request to read the hardware , we should read them  all 
     * The order of reading can be changed 
     * 
     * */
	public void lireMateiel() {
      
		if( ihmSIM.getClavier().touchePresse(ClavierImpl.BTNSTART)){
			ihmSIM.getClavier().resetTouche(ClavierImpl.BTNSTART);
			controler.start();	
		}
        if( ihmSIM.getClavier().touchePresse(ClavierImpl.BTNSTOP)){
        	ihmSIM.getClavier().resetTouche(ClavierImpl.BTNSTOP);
        	controler.stop(); 
        	
        }
        if( ihmSIM.getClavier().touchePresse(ClavierImpl.BTNINC)){
        	ihmSIM.getClavier().resetTouche(ClavierImpl.BTNINC);
        	controler.inc();
        }
        if( ihmSIM.getClavier().touchePresse(ClavierImpl.BTNDEC)){
        	ihmSIM.getClavier().resetTouche(ClavierImpl.BTNDEC);
        	controler.dec();
        }
        
        if( ihmSIM.getMolette().getChanged()){
			float v = ihmSIM.getMolette().getPosition();
			ihmSIM.getMolette().resetChanged();
			controler.updateMolette(v);
			
		}
		System.out.println("AdapteurImpl::Lire materiel");
        // program the next reading of the hardware
        hcmd.activerApresDelais(lireMateriel, delaisLectureMateriel);
		
	}
    /**
     * Update operation because Adapter is an observer (tempo observer)
     * 
     * */
	public void update() {
		ihmSIM.getAfficheur().getJTextAfficheurTempo().setText(String.valueOf(controler.getTempo()));
	}

	/**
	 * Set the new Tempo within the displayer of the material
	 * 
	 * */
	public void setCurrentTempo(int currentTempo) {
		ihmSIM.getAfficheur().getJTextAfficheurTempo()
				.setText(String.valueOf(currentTempo));
	}

}
