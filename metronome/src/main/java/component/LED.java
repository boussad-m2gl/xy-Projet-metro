package component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * La class LED: represente une Led : qui est composant lumineux 
 *  
 * */
public class LED extends JPanel {

	private static final long serialVersionUID = 1L;
	private Color couleur;

	public LED() {
		setBackground(Color.black);
		setPreferredSize(new Dimension(100, 100));
		setOpaque(true);
	}

	public void setColor(Color col) {
		couleur = col;
		// repaint();
	}

	public void eteindre() {
		setVisible(false);
	}

	public void flasher() {
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {

		super.paintComponent(g);
		g.setColor(couleur);
		g.fillRect(10, 10, 80, 80);
	}

}
