package materiel;

import javax.swing.JTextField;

import component.LED;

public interface Afficheur {
	public void flasher(int numLed);
	public void eteindre(int numLed);
	public LED getLED(int numLed);
	public JTextField  getJTextAfficheurTempo();
	public JTextField  getJTextAfficheurTparM();
}
