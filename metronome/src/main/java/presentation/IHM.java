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

public class IHM implements IIHM{

	JFrame frame;
	// JRadioButton led1;
	// JLabel led2;

	LED led1, led2;
	Player player1, player2;
	
	//Un slider pour le tempo

	 private JSlider slider ;
	 private JTextField txt ;
	 private JLabel lbl1 ;
	 private JPanel panelSilder; 
	//  temp par mesure widget 
	 
	 private JLabel labTmpParMesure;
	 private JPanel panTMesure;
	 private JPanel panNorth;
	 private JPanel panSouth;
	 private JPanel  panLed;
	// command pour etteindre les leds
    //	   LedTimer led1timer;   LedTimer led2timer;	
	// Commandes 

	 Eteindre cmdEteindreLed1, cmdEtiendreLed2;
	 Horloge hcmd;
	 
	 
	 JButton buttonInc = new JButton("INC"); 
	 JButton buttonDec = new JButton("DEC");
	 JTextField tempParMesur = new JTextField(3);
	 JButton buttonStop = new JButton("STOP");
	 JButton buttonStart = new JButton("START");
	 
	
	 
	// some attributes
	 
	 private int currentTempParM =1; 
     private int currentTempo = 120;
     
     private Command incrCmd, decrCmd, startCmd, stopCmd;
     private GestionnaireIHM controler;
     
     private Collection <Observer> obsList = new ArrayList<Observer>();
     
     
	 public IHM(GestionnaireIHM cont) {
         
		controler = cont;
		 
		frame = new JFrame(" Je suis le Metronome ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		led1 = new LED(); led1.setColor(Color.orange);
		led2 = new LED(); led2.setColor(Color.red);
		player1 = new Player();
		player2 = new Player();
		
		cmdEteindreLed1 = new Eteindre(led1);
		cmdEtiendreLed2 = new Eteindre(led2);
		hcmd =  new Horloge();
		
	    // On fixe les auttres commandes 
		
		startCmd= new Start(controler);
		stopCmd = new Stop(controler);
        incrCmd = new Inc(controler);
        decrCmd  = new Dec(controler);
		
		/*************************************************************
		                   Declaration du slider qui pour changer le tempo
		*************************************************************/

		    slider = new JSlider(JSlider.HORIZONTAL,0,10,10);//direction , min , max , current
	         
        
            slider.setFont(new Font("Tahoma",Font.BOLD,12));
	        slider.setMajorTickSpacing(2);
	        slider.setMinorTickSpacing(1);
     
	      
			Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
	        labelTable.put( new Integer( 0 ), new JLabel("0.0") );
	        labelTable.put( new Integer( 2 ), new JLabel("0.2") );
	        labelTable.put( new Integer( 4 ), new JLabel("0.4") );
	        labelTable.put( new Integer( 6 ), new JLabel("0.6") );
	        labelTable.put( new Integer( 8 ), new JLabel("0.8") );
	        labelTable.put( new Integer( 10 ), new JLabel("1.0") );
	        
	        slider.setLabelTable( labelTable);
	        slider.setPaintLabels(true);
	        slider.setPaintTicks(true);
	        slider.setPaintTrack(true);
	        slider.setAutoscrolls(true);
	        slider.setPreferredSize(new Dimension(250,250));
	       
	        lbl1 = new JLabel("position");
	        txt = new JTextField(4);
		
	        
	        slider.addChangeListener(new ChangeListener() {
	            public void stateChanged(ChangeEvent e) {
	                txt.setText(String.valueOf(slider.getValue()*0.1));
	                //TODO  : remplacer par le patron de conception observer
	                controler.updateMolette(slider.getValue()*0.1);
	            }
	        });
	        
	       panelSilder = new JPanel();
	      
	       panelSilder.add(slider);
	       panelSilder.add(lbl1);
	       panelSilder.add(txt);
	       
	       panNorth = new JPanel();
	       panNorth.setLayout( new BorderLayout());
	       panNorth.add(panelSilder, BorderLayout.WEST);
		//
	       
	       
	       /*************************************************************
                       Declaration du temp par mesure 
           *************************************************************/
	      
			labTmpParMesure = new JLabel("   Temp Par Mesure ");
			panTMesure = new JPanel(); panTMesure.setLayout(new BorderLayout());
			panTMesure.add(labTmpParMesure, BorderLayout.NORTH);
			panTMesure.add(buttonInc,BorderLayout.WEST );
			panTMesure.add(buttonDec, BorderLayout.EAST);
			tempParMesur.setText(String.valueOf(currentTempParM));
			panTMesure.add(tempParMesur,BorderLayout.CENTER );
			
			panSouth = new JPanel();
		    panSouth.setLayout(new FlowLayout());
		    panSouth.add(buttonStart, BorderLayout.SOUTH);
		    panSouth.add(buttonStop , BorderLayout.SOUTH);
		    panSouth.add(panTMesure , BorderLayout.SOUTH);
		    
			
	      //association des listenrs pour les button 
		   
		   buttonStart.addActionListener(
				   new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							startCmd.executer();
							
						}
					}
		    );
		   
		   buttonStop.addActionListener(
				   new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							stopCmd.executer();
								
						}
					}
		    );
		   buttonInc.addActionListener(
				   new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							incrCmd.executer();
							tempParMesur.setText(String.valueOf(currentTempParM));
						}
					}
		    );
		   buttonDec.addActionListener(
				   new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							decrCmd.executer();
							tempParMesur.setText(String.valueOf(currentTempParM));
						}
					}
		    );
		   
		   
		   
		// configurations finales 
	    panLed  = new JPanel(); panLed.setLayout( new BorderLayout());
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
    }
	 
   public void flasherLed(int idLed) {

		switch (idLed) {
		case 1: {
			led1.setVisible(true);
			hcmd.activerApresDelais(cmdEteindreLed1, 200);
			//player1.play("A");
		}
			;
			break;

		case 2: {
			led2.setVisible(true);  
			hcmd.activerApresDelais(cmdEtiendreLed2, 200);
			//player2.play("B");
		}
			;
			break;
		default:
			;
		}
	}

	public void eteindreLed() {
		// TODO Auto-generated method stub
	}

}
