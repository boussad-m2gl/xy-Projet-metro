package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import materiel.Clavier;

public class ClavierImpl extends JPanel implements Clavier {

	private final int BTNSTART = 1;
	private final int BTNSTOP = 2;
	private final int BTNINC = 3;
	private final int BTNDEC = 4;

	// quatre bouton

	private JButton btnStart;
	private JButton btnStop;
	private JButton btnInc;
	private JButton btnDec;

	// booleens
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

		btnStart.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
			    System.out.println(" Mouse released ");
			    
			      startActive =  true;
			      System.out.println("START is now :"+startActive);
				//super.mouseReleased(e);
			}

		});
		
		btnStop.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
			    System.out.println(" Mouse released ");
			    
			      stopActive =  true;
			   
				//super.mouseReleased(e);
			}

		});
	
		
		btnInc.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
			    System.out.println(" Mouse released ");
			    
			    incActive =  true;
			 
				//super.mouseReleased(e);
			}

		});
		
		btnDec.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
			    System.out.println(" Mouse released ");
			    
			    decActive =  true;

				//super.mouseReleased(e);
			}

		});
	}

	public boolean touchePresse(int key) throws Exception {

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
			throw new Exception(key + " is not correct key.");
		}

	}
	
	public void resetTouche(int key) throws Exception {

		switch (key) {

		case BTNSTART:
			 startActive = false; break;
		case BTNSTOP:
		       stopActive = false; break;
		case BTNINC:
			 incActive = false; break;
		case BTNDEC:
			 decActive = false; break;
		default:
			throw new Exception(key + " is not correct key.");
		}

	}
}
