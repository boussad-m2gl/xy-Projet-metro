package presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;

import materiel.Afficheur;
import materiel.Clavier;
import materiel.Materiel;
import materiel.Molette;
import model.Horloge;

public class Simulateur extends JFrame implements Materiel {

	private Clavier clavier;
	private Molette molette;
	private Afficheur afficheur;

	public Simulateur() {
		clavier = new ClavierImpl();
		molette = new MoletteImpl();
		afficheur = new AfficheurImpl();

		getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add((Component) afficheur, BorderLayout.NORTH);
		this.getContentPane().add((Component) molette, BorderLayout.CENTER);
		this.getContentPane().add((Component) clavier, BorderLayout.SOUTH);

		setTitle("Metronome V2");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500, 500));
		setSize(new Dimension(500, 500));
		setVisible(true);
		pack();
		
	}

	public static void main(String[] args) {
		Simulateur ihmv2 = new Simulateur();
		
	}

	public Horloge getHolorge() {
		// TODO Auto-generated method stub
		return null;
	}

	public Clavier getClavier() {
		return clavier;
	}

	public materiel.Molette getMolette() {

		return molette;
	}

	public materiel.EmetteurSonore EmetteurSonore() {

		return null;
	}

	public Afficheur getAfficheur() {

		return afficheur;
	}
}
