package com.battleship.view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GridWindow extends JFrame{

	private static final long serialVersionUID = -3399602846645562507L;
	private JPanel mainPanel;
	public static JTextArea txtAreaG1;
	public static JTextArea txtAreaG2;
	
	public GridWindow(Grid gamer1Grid, Grid gamer2Grid){
		this.setTitle("Bataille Navale");  //On donne un titre à l'application
	    this.setSize(880,680);  //Pour redimentionner la taille de la fenetre du menu
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
	    this.setLocationRelativeTo(null);  //On centre la fenêtre sur l'écran
	    this.setResizable(false);
	    
	    txtAreaG1 = new JTextArea(15, 30);
	    txtAreaG1.setEditable(false);
	    txtAreaG1.setLineWrap(true);
	    txtAreaG2 = new JTextArea(15, 30);
	    txtAreaG2.setEditable(false);
	    txtAreaG2.setLineWrap(true);
	    
	    JScrollPane scrollArea1 = new JScrollPane (txtAreaG1);
	    scrollArea1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollArea1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    
	    JScrollPane scrollArea2 = new JScrollPane (txtAreaG2);
	    scrollArea2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollArea2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	    mainPanel = new JPanel();
	    mainPanel.setLayout(new GridLayout(2, 2, 15, 15));
	    
		mainPanel.add( gamer1Grid );
		mainPanel.add(gamer2Grid);
		
		mainPanel.add( scrollArea1 );
		mainPanel.add( scrollArea2 );
		
	    this.setContentPane(mainPanel);
	    this.setVisible(true);//visibilité de la fenetre
	}
	
}
