package presentationPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import component.LED;

/**
 * L'interface de L'IMH de l'application metronome
 * */

public class IHM implements IIHM {

	JFrame frame;
	// JRadioButton led1;
	// JLabel led2;

	LED led1;
	LED led2;

	ButtonGroup led1Container;
	ButtonGroup led2Container;

	JTextArea info;

	// command pour etteindre les leds
	LedTimer led1timer;
	LedTimer led2timer;

	public IHM() {

		frame = new JFrame(" Je suis le Metronome ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLayout(new BorderLayout());
		info = new JTextArea();
		// led1 = new JRadioButton(" * LED 1 * ");
		// led2 =new JRadioButton("* LED 2 *");

		led1 = new LED();
		led2 = new LED();

		// led2.setBackground(Color.RED);

		// led2.setBorder(new EmptyBorder(20, 20, 20, 20));
		// JPanel jp = new JPanel();
		// jp.add(led2);

		led1Container = new ButtonGroup();
		led2Container = new ButtonGroup();

		// led1Container.add(led1);
		// led2Container.add(led2);
		info.setText("  Ceci  est un teste basique de l'application Metronome \n  \t   Tempo  = 120 , temp par mesure = 4 \n  \t\t enjoy it ! ");

		// led1timer = new LedTimer(led1);
		// led2timer = new LedTimer(led2);

		frame.add(info, BorderLayout.NORTH);
		frame.add(led1, BorderLayout.WEST);
		frame.add(led2, BorderLayout.EAST);
		frame.setPreferredSize(new Dimension(400, 400));
		frame.pack();
		frame.setVisible(true);

	}

	public void flasherLed(int idLed) {

		switch (idLed) {
		case 1: {
			led1.setVisible(true);
			led1timer.Armer();
		}
			;
			break;

		case 2: {
			led2.setVisible(true);
			led2timer.Armer();
		}
			;
			break;
		default:
			;
		}
	}

	/**
	 * LedTimer pour eteindre les Leds
	 * */
	class LedTimer {

		JButton rbutton;
		Timer timer = null;

		LedTimer(JButton rbut) {
			rbutton = rbut;
			timer = new Timer();
		}

		public void Armer() {
			timer.schedule(new TimerTask() {

				@Override
				public void run() {
					rbutton.setVisible(false);
				}
			}, 200);
		}
	}

}
