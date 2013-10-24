package presentationPackage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *   L'interface de L'IMH de l'application metronome
 * */
 
 
public class IHM   implements IIHM  {

	JFrame frame;
	JRadioButton led1;
	JRadioButton led2;
	ButtonGroup led1Container;
	ButtonGroup led2Container;
	JTextArea  info;
	
	// command pour etteindre les leds
	LedTimer led1timer;
	LedTimer led2timer;
	
	
	public IHM(){
		
	    frame = new JFrame(" Je suis le Metronome ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());
        info= new JTextArea();
		led1 = new JRadioButton(" * LED 1 * ");  
		led2 =new JRadioButton("* LED 2 *");
		led1Container = new ButtonGroup();
		led2Container = new ButtonGroup();
		
		led1Container.add(led1); 
		led2Container.add(led2);
		info.setText("  Ceci  est un teste basique de l'application Metronome \n  \t   Tempo  = 120 , temp par mesure = 4 \n  \t\t enjoy it ! ");
		
		
		led1timer = new LedTimer(led1);
		led2timer = new LedTimer(led2);
		
		frame.add(info, BorderLayout.NORTH);
        frame.add(led1, BorderLayout.WEST); 
        frame.add(led2, BorderLayout.EAST);
        frame.setPreferredSize(new Dimension(400,400));
        frame.pack();
	    frame.setVisible(true);
	       
	}

	public void flasherLed(int idLed) {
		
			switch (idLed){
			case 1:{
			        led1.setVisible(true);
			        led1timer.Armer();
			       }; break;
			
			case 2: { led2.setVisible(true); 
			          led2timer.Armer();
			        };break;
			default : ; 
			}
	}
	
	/**
	 * LedTimer pour eteindre les Leds  
	 * */
	class LedTimer{
		
				JRadioButton rbutton;
				Timer timer = null;
				LedTimer(JRadioButton rbut){
					rbutton = rbut;
					timer = new Timer();
				}
				
				public void Armer(){
							timer.schedule(new TimerTask() {
				
					            @Override
					            public void run() {
					            	rbutton.setVisible(false);
					            }
					        }, 200); 
					  }
		}
		
	
}
