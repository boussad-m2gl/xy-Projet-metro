package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jfugue.Player;

import observer.Observer;
import observer.Subject;

import model.Horloge;

import command.Command;
import command.Dec;
import command.Eteindre;
import command.Inc;
import command.Start;
import command.Stop;
import component.LED;
import controleur.GestionnaireIHM;

/**
 * L'interface de L'IMH de l'application metronome
 * */

public class IHM implements IIHM, Observer {

	JFrame frame;

	LED led1, led2;
	Player player1, player2;

	// Un slider pour le tempo
	private JSlider molette;
	private JTextField afficheurTempo;
	private JLabel afficheurTempoLab;
	private JPanel panelSilder;
	// temp par mesure widget
	private JLabel labTmpParMesure;
	private JPanel panTMesure;
	private JPanel panNorth;
	private JPanel panSouth;
	private JPanel panLed;
	// command pour etteindre les leds
	Eteindre cmdEteindreLed1, cmdEtiendreLed2;
	Horloge hcmd;
	JButton buttonInc = new JButton("INC");
	JButton buttonDec = new JButton("DEC");
	JTextField tempParMesur = new JTextField(3);
	JButton buttonStop = new JButton("STOP");
	JButton buttonStart = new JButton("START");

	private int currentTempParM = 2;
	private int currentTempo = 120;

	private Command incrCmd, decrCmd, startCmd, stopCmd;
	private GestionnaireIHM controler;

	public IHM(GestionnaireIHM cont) {

		controler = cont;

		frame = new JFrame("Metronome -V1 ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		led1 = new LED();
		led1.setColor(Color.orange);
		led2 = new LED();
		led2.setColor(Color.red);
		player1 = new Player();
		player2 = new Player();

		cmdEteindreLed1 = new Eteindre(led1);
		cmdEtiendreLed2 = new Eteindre(led2);
		hcmd = new Horloge();

		// On fixe les autres commandes

		startCmd = new Start(controler);
		stopCmd = new Stop(controler);
		incrCmd = new Inc(controler);
		decrCmd = new Dec(controler);

		/*************************************************************
		 * Declaration du slider pour changer le tempo
		 *************************************************************/

		molette = new JSlider(JSlider.HORIZONTAL, 0, 10, 10);// direction , min
																// , max ,
																// current
		molette.setFont(new Font("Tahoma", Font.BOLD, 12));
		molette.setMajorTickSpacing(2);
		molette.setMinorTickSpacing(1);

		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(new Integer(0), new JLabel("0.0"));
		labelTable.put(new Integer(2), new JLabel("0.2"));
		labelTable.put(new Integer(4), new JLabel("0.4"));
		labelTable.put(new Integer(6), new JLabel("0.6"));
		labelTable.put(new Integer(8), new JLabel("0.8"));
		labelTable.put(new Integer(10), new JLabel("1.0"));

		molette.setLabelTable(labelTable);
		molette.setPaintLabels(true);
		molette.setPaintTicks(true);
		molette.setPaintTrack(true);
		molette.setAutoscrolls(true);
		molette.setPreferredSize(new Dimension(250, 250));

		afficheurTempoLab = new JLabel("  AFFICHEUR TEMPO ");
		afficheurTempo = new JTextField(7);
		afficheurTempo.setText(String.valueOf(Config.MaxTempo));

		molette.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				controler.updateMolette(molette.getValue() * 0.1);
			}
		});

		panelSilder = new JPanel();
		panelSilder.setLayout(new BorderLayout());
		panelSilder.add(molette, BorderLayout.SOUTH);
		panelSilder.add(afficheurTempoLab, BorderLayout.NORTH);
		panelSilder.add(afficheurTempo, BorderLayout.CENTER);

		panNorth = new JPanel();
		panNorth.setLayout(new BorderLayout());
		panNorth.add(panelSilder, BorderLayout.WEST);

		/*************************************************************
		 * Declaration du temp par mesure
		 *************************************************************/

		labTmpParMesure = new JLabel("   TEMP PAR MESURE ");
		panTMesure = new JPanel();
		panTMesure.setLayout(new BorderLayout());
		panTMesure.add(labTmpParMesure, BorderLayout.NORTH);
		panTMesure.add(buttonInc, BorderLayout.WEST);
		panTMesure.add(buttonDec, BorderLayout.EAST);
		tempParMesur.setText(String.valueOf(currentTempParM));
		panTMesure.add(tempParMesur, BorderLayout.CENTER);

		panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		panSouth.add(buttonStart, BorderLayout.SOUTH);
		panSouth.add(buttonStop, BorderLayout.SOUTH);
		panSouth.add(panTMesure, BorderLayout.SOUTH);

		// Association des listeners pour les buttons

		buttonStart.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				startCmd.executer();

			}
		});

		buttonStop.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				stopCmd.executer();

			}
		});
		buttonInc.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				incrCmd.executer();
				tempParMesur.setText(String.valueOf(currentTempParM));
			}
		});
		buttonDec.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				decrCmd.executer();
				tempParMesur.setText(String.valueOf(currentTempParM));
			}
		});

		// configurations finales
		panLed = new JPanel();
		panLed.setLayout(new BorderLayout());
		panLed.add(led1, BorderLayout.NORTH);
		panLed.add(led2, BorderLayout.SOUTH);

		panNorth.add(panLed, BorderLayout.EAST);
		frame.add(panNorth, BorderLayout.NORTH);
		frame.add(panSouth, BorderLayout.CENTER);

		frame.setPreferredSize(new Dimension(800, 600));
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);

	}

	public int getCurrentTempParM() {
		return currentTempParM;
	}

	public void setCurrentTempParM(int currentTempParM) {
		this.currentTempParM = currentTempParM;
	}

	public int getCurrentTempo() {
		return currentTempo;
	}

	public void setCurrentTempo(int currentTempo) {
		this.currentTempo = currentTempo;
		afficheurTempo.setText(String.valueOf(this.currentTempo));
	}

	public void flasherLED(int numLed) {

		switch (numLed) {
		case 1: {
			led1.flasher();
			hcmd.activerApresDelais(cmdEteindreLed1, 200);
			// player1.play("A");
		}
			;
			break;

		case 2: {
			led2.flasher();
			hcmd.activerApresDelais(cmdEtiendreLed2, 200);
			// player2.play("B");
		}
			;
			break;
		default:
			;
		}
	}

	public void eteindreLED(int numLed) {
		switch (numLed) {
		case 1:
			led1.eteindre();
			break;
		case 2:
			led2.eteindre();
		}
	}

	public void update() {
		afficheurTempo.setText(String.valueOf(controler.getTempo()));
	}

}
