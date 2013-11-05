package presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;

import materiel.Clavier;
import materiel.Molette;

public class IHM_V2  extends JFrame {

	private Clavier clavier;
	private Molette molette;
	
	 public IHM_V2() {
		  clavier = new ClavierImpl();
		  molette = new MoletteImpl();
		  
		  
		 getContentPane().setLayout(new BorderLayout());
		  this.getContentPane().add((Component) molette , BorderLayout.NORTH);
		  this.getContentPane().add((Component) clavier, BorderLayout.SOUTH);
		  
		  setPreferredSize(new Dimension(500,500));
		  setSize(new Dimension(500,500));
		  setVisible(true);
		  pack();
	}
	 
	 
	 
	 public static  void main(String []  args){
		 IHM_V2  ihmv2 = new IHM_V2();
		 ihmv2.setDefaultCloseOperation(EXIT_ON_CLOSE);
				 
		 
	 }
}
