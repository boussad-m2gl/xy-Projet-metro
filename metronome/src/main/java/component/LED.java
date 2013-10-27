package component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LED extends JPanel {

    private Color couleur;	
	public LED() {
		
		setBackground(Color.black);
        setPreferredSize(new Dimension(100,100));
        setOpaque(true);
	}

	public void setColor(Color col){
		   couleur = col;
		   //repaint();
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
		   g.setColor( couleur);
		   g.fillRect(10, 10, 80, 80);
		  
	    }

}
