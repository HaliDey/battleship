package com.battleship.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.battleship.observer.Observer;

public class GridWindow extends JFrame implements Observer{

	private static final long serialVersionUID = -3399602846645562507L;
	private JPanel mainPanel;
	
	public GridWindow(Grid gamer1Grid, Grid gamer2Grid){
		this.setTitle("Bataille Navale");  //On donne un titre à l'application
	    this.setSize(750,550);  //Pour redimentionner la taille de la fenetre du menu
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
	    this.setLocationRelativeTo(null);  //On centre la fenêtre sur l'écran
	    this.setResizable(false);
	    
	    mainPanel = new JPanel();
	    
	    mainPanel = new JPanel();
	    mainPanel.add(new JLabel("Gamer 1"));
		mainPanel.add( gamer1Grid );
		
		//seconde grille pour le joueur 2
		mainPanel.add(new JLabel("Gamer 2"));
		mainPanel.add(gamer2Grid);
	    
	    this.setContentPane(mainPanel);
	    this.setVisible(true);//visibilité de la fenetre
	}
	
	@Override
	public void update(Grid grid) {
		// TODO Auto-generated method stub
		
	}

}
