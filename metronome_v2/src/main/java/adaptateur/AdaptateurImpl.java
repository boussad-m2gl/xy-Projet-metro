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
 * Class adapter wich holds responses for the operations wich v1 of the
 * metronome can do
 * */
public class AdaptateurImpl implements Adaptateur {

	private final int LED1 = 1;
	private final int LED2 = 2;
    
	private final int delaisLectureMateriel=200; // ms
	
	private Materiel ihmSIM; // The simulated IHM
	private GestionnaireIHM controler;
	// command pour etteindre les leds
	Eteindre cmdEteindreLed1, cmdEtiendreLed2;
	Horloge hcmd;
    Command lireMateriel;
	
	
	public AdaptateurImpl() {
	
	}
	
	public void setControleur(Controleur cntrl) {
		this.controler = cntrl;
		configure();
	}

	
	private void configure(){
		this.ihmSIM = new Simulateur();
		cmdEteindreLed1 = new Eteindre(ihmSIM.getAfficheur().getLED(LED1));
		cmdEtiendreLed2 = new Eteindre(ihmSIM.getAfficheur().getLED(LED2));
		hcmd = new Horloge();
		lireMateriel = new LireMateriel(this);  // command to read the hardware
		System.out.println("AdapteurImpl::Program reag the hardware");
		hcmd.activerApresDelais(lireMateriel, delaisLectureMateriel);
	}
	
	public void flasherLED(int numLed) {
		switch (numLed) {
		case LED1: {
			System.out.println("AdapateurImpl::led 1 flasher");
			ihmSIM.getAfficheur().flasher(LED1);
			hcmd.activerApresDelais(cmdEteindreLed1, 200);

		}
			;
			break;

		case LED2: {
			System.out.println("AdapateurImpl::led 2 flasher");
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
     * we should   go and leanr the state of the material 
     *   inc button pressed ? , start pressed , ?  and so on
     *   and  also the state of the slider
     * @throws Exception 
     * */
	public void lireMateiel() {
      
		if( ihmSIM.getClavier().touchePresse(ClavierImpl.BTNSTART)){
			ihmSIM.getClavier().resetTouche(ClavierImpl.BTNSTART);
			controler.start();	
			System.out.println("AdaptateurImpl::lireMatBtnStartOK");
			
		}
        if( ihmSIM.getClavier().touchePresse(ClavierImpl.BTNSTOP)){
        	ihmSIM.getClavier().resetTouche(ClavierImpl.BTNSTOP);
        	System.out.println("AdaptateurImpl::lireMatBtnStopOK");
        	controler.stop(); 
        	
        }
        if( ihmSIM.getClavier().touchePresse(ClavierImpl.BTNINC)){
        	ihmSIM.getClavier().resetTouche(ClavierImpl.BTNINC);
        	System.out.println("AdaptateurImpl::lireMatBtnIncOK");
        	controler.inc();
        }
        if( ihmSIM.getClavier().touchePresse(ClavierImpl.BTNDEC)){
        	ihmSIM.getClavier().resetTouche(ClavierImpl.BTNDEC);
        	System.out.println("AdaptateurImpl::lireMatBtnDecOK");
        	controler.dec();
        }
        
        if( ihmSIM.getMolette().getChanged()){
			float v = ihmSIM.getMolette().getPosition();
			ihmSIM.getMolette().resetChanged();
			System.out.println("AdaptateurImpl::lireMatMoletteOK");
			controler.updateMolette(v);
			
		}
		System.out.println("AdapteurImpl::Program reag the hardware");
        // program the next commad to read the hardware
        hcmd.activerApresDelais(lireMateriel, delaisLectureMateriel);
		
	}

	public void update() {
		ihmSIM.getAfficheur().getJTextAfficheurTempo().setText(String.valueOf(controler.getTempo()));
	}

	/**
	 * Set the new Tempo within the dsplayer of the material
	 * */
	public void setCurrentTempo(int currentTempo) {
		ihmSIM.getAfficheur().getJTextAfficheurTempo()
				.setText(String.valueOf(currentTempo));
	}

}
