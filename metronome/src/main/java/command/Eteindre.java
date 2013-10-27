package command;

import component.LED;

import presentation.IIHM;

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
