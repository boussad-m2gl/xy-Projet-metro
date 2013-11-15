package materiel;

import javax.swing.JTextField;

import component.LED;

/**
 * Interface Afficheur : contains all the opérations that can be performed
 * on  a displaying device
 * Here : we consider a displaying device will contains Leds(2), 
 * textField for tempo and TextField for Temp par mesure
 *  
 * */
public interface Afficheur {
	
	public void flasher(int numLed);
	public void eteindre(int numLed);
	public LED getLED(int numLed);
	public JTextField  getJTextAfficheurTempo();
	public JTextField  getJTextAfficheurTparM();
	
}
