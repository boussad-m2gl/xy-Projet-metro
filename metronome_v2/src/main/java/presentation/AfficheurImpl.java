package presentation;

import java.awt.Color;

import javax.swing.JPanel;

import component.LED;
import materiel.Afficheur;

public class AfficheurImpl  extends JPanel implements Afficheur {

	
	private final int idLED1=1;  
	private final int idLED2=2;  
	
	private  LED  led1;
	private  LED led2; 
	
	
	
	public AfficheurImpl() {
		
		led1 = new LED();
		led1.setColor(Color.orange);
		led2 = new LED();
		led2.setColor(Color.red);
		
	    add(led1);
	    add(led2);
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
}
