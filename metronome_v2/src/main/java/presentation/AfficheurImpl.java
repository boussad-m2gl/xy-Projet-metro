package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import component.LED;
import materiel.Afficheur;

public class AfficheurImpl  extends JPanel implements Afficheur {

	
	private final int idLED1=1;  
	private final int idLED2=2;  
	
	private  LED  led1;
	private  LED led2; 
	private JTextField afficheurTempo;
	private JLabel labTempo; 
	private JTextField afficheurTparM;
	private JLabel labTparM; 
	
	//Panels 
	private JPanel panLed;
	private JPanel panTempo;
	private JPanel panTparM;
	private JPanel panAfficheursTxt;
	
	public AfficheurImpl() {
		
		led1 = new LED(); led1.setColor(Color.orange);
		led2 = new LED(); led2.setColor(Color.red);
		 
		afficheurTempo = new JTextField();afficheurTempo.setColumns(7);
	    labTempo= new JLabel();  labTempo.setText("Tempo :");
		
		 afficheurTparM = new JTextField(); afficheurTparM.setColumns(3);
         labTparM= new JLabel();  labTparM.setText("Tmp par Mesure :");
	     
	     panLed =new JPanel();  panLed.setLayout(new BorderLayout());
	     panLed.add(led1, BorderLayout.WEST); panLed.add(led2, BorderLayout.EAST);
	    
	     // Les afficheurs 
	     panTempo = new JPanel();  panTempo.setLayout(new BorderLayout());
	     panTempo.add(labTempo,BorderLayout.WEST);  panTempo.add(afficheurTempo,BorderLayout.EAST); 
	     
	     
		 panTparM= new JPanel();  panTparM.setLayout(new BorderLayout());
		 panTparM.add(labTparM,BorderLayout.WEST);  panTparM.add(afficheurTparM,BorderLayout.EAST); 
	     
		 
		 panAfficheursTxt = new JPanel(); panAfficheursTxt.setLayout(new BorderLayout());
		 panAfficheursTxt.add(panTempo, BorderLayout.NORTH);
		 panAfficheursTxt.add(panTparM, BorderLayout.SOUTH);
		 panLed.setPreferredSize(new Dimension(200,100));
	
		 
		 this.setLayout(new BorderLayout());
		 this.add(panAfficheursTxt, BorderLayout.WEST);
		 this.add(panLed, BorderLayout.EAST);
	}
	
	
	public void flasher(int numLed){
		
		switch (numLed){
			case idLED1: led1.flasher(); break;
			case idLED2: led2.flasher() ; break;
		}
	}
	
    public void eteindre(int numLed){
		
     	switch (numLed){
	    	case idLED1: led1.eteindre(); break;
		    case idLED2: led2.eteindre() ; break;
     	}
	}


	public LED getLED(int numLed) {
		switch (numLed) {
			case idLED1:
				return led1;
			case idLED2:
				return led2;
			default:
				return null;
		}
	}
	
	public JTextField  getJTextAfficheurTempo(){
		return afficheurTempo;
	}
	
	public JTextField  getJTextAfficheurTparM(){
		return afficheurTparM;
	}
}
