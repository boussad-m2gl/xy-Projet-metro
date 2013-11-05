package command;

import component.LED;


/**
 * La commande Eteindre 
 * */
public class Eteindre  implements Command {

	private LED  led;
	
	public Eteindre(LED led ) {
	 this.led = led; 
	}
	
	/**
	 * Eteindre la led 
	 * */
	public void executer() {
        this.led.eteindre();
	}
	

}
