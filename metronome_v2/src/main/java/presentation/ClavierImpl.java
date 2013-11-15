package presentation;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import materiel.Clavier;

public class ClavierImpl extends JPanel implements Clavier {

	
	private static final long serialVersionUID = 1L;
	
	public  static final int BTNSTART = 1;
	public static final int BTNSTOP = 2;
	public static final int BTNINC = 3;
	public static final int BTNDEC = 4;

	// quatre bouton

	private JButton btnStart;
	private JButton btnStop;
	private JButton btnInc;
	private JButton btnDec;

	// some flags to handle the commands from the user
	private boolean startActive;
	private boolean stopActive;
	private boolean incActive;
	private boolean decActive;

	public ClavierImpl() {

		btnStart = new JButton("start");
		btnStop = new JButton("stop");
		btnInc = new JButton("inc");
		btnDec = new JButton("dec");

		this.add(btnStart);
		this.add(btnStop);
		this.add(btnInc);
		this.add(btnDec);

		// declare some listeners 
		btnStart.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {  // active on rasing front
			      startActive =  true;  // Rise the flag
			}

		});
		
		btnStop.addMouseListener(new MouseAdapter() { // active on rasing front

			@Override
			public void mouseReleased(MouseEvent e) {
			      stopActive =  true; // flag Up
			}

		});
	
		
		btnInc.addMouseListener(new MouseAdapter() { // active on rasing front

			@Override
			public void mouseReleased(MouseEvent e) { 
			    incActive =  true;  // flag up
			}

		});
		
		btnDec.addMouseListener(new MouseAdapter() { // active on rasing front

			@Override
			public void mouseReleased(MouseEvent e) {
			    decActive =  true;  // flag up

			}

		});
	}
    /**
     * @return : true weather the required button was pressed
     * @param  : button identifier
     * */
	public boolean touchePresse(int key)  {

		switch (key) {

		case BTNSTART:
			return startActive;
		case BTNSTOP:
			return stopActive;
		case BTNINC:
			return incActive;
		case BTNDEC:
			return decActive;
		default:
			return false;
		}

	}
	
	 /**
     *  Reset a given button , put its corresponding flag to false
     *  @param  : button identifier
     * */
	public void resetTouche(int key){

		switch (key) {

		case BTNSTART:
			 startActive = false; break; // put down the flag
		case BTNSTOP:
		       stopActive = false; break;
		case BTNINC:
			 incActive = false; break;
		case BTNDEC:
			 decActive = false; break;
		default:
			break;
		}
	}
	
}
