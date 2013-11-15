package adaptateur;

import presentation.IIHM;

/**
 * Interface adapter which will extends the IHM Interface IIHM
 * 
 * The controller will communicate with the hardware using this Interface
 * 
 * */

public interface Adaptateur extends IIHM {

	public void lireMateiel();
}
