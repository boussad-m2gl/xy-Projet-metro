package component;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LED extends JPanel {

	private JPanel lumiere;

	public LED() {
		lumiere = new JPanel();
		lumiere.setBorder(new EmptyBorder(10, 20, 10, 20));

		// TODO : TEST COLOR
		//this.setBackground(Color.red);
		lumiere.setBackground(Color.red);

		this.add(lumiere);
	}

	public void eteindre() {
		lumiere.setVisible(false);
	}

	public void flasher() {
		lumiere.setVisible(true);
	}

}
