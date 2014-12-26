package com.battleship.view;

import com.battleship.controller.GameController;
import com.battleship.observer.Observer;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;

public class Window extends JFrame{

	private static final long serialVersionUID = -8106084731437307782L;
	private static final Component Ship = null;
	private static final AbstractButton TypePanel = null;

	private JPanel cardsPanel, gameElementsPanel, gameGridPanel;
	
	private JRadioButton demoMode, onePlayerMode, twoPlayersMode;
	private JRadioButton battleshipType, radarType, artilleryOperationType, redAlertType;
	private JCheckBox aircraftCarrierChk, nuclearSubmarineChk, stealthBattleship1Chk, stealthBattleship2Chk, zodiacChk;
	private JButton startBtn, playBtn;
	private GroupLayout layout;
	
	private static Grid gamer1Grid;
	public static Grid gamer2Grid;
	public ButtonGroup gameModeGroup, battleTypeGroup;
	
	private GameController listener;
	private JLabel gameModeTextView;

	public Window()
	{
		this.setTitle("Bataille Navale");  //On donne un titre à l'application
	    this.setSize(750,550);  //Pour redimentionner la taille de la fenetre du menu
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
	    this.setLocationRelativeTo(null);  //On centre la fenêtre sur l'écran
	    this.setResizable(false);
	    
	    listener = new GameController(this);
	    gameElementsPanel = new JPanel();
	    this.initElements();
	    //this.initGameElements();
	    
	    /*cards = new CardLayout();   
        cardsPanel = new JPanel();
        cardsPanel.setLayout(cards);
        
        cardsPanel.add(gameElementsPanel);
       !!!! cardsPanel.add(gameGridPanel);!!!*/
	                   
	    this.setContentPane(gameElementsPanel);
	    this.setVisible(true);//visibilité de la fenetre
	}
	
	public void initElements()
	{
		/*
		 * Mode de jeu
		 */
		JLabel gameModeLabel = new JLabel("Mode de jeu");
		gameModeLabel.setFont(new Font("Segoe UI",Font.PLAIN,18));
		gameModeGroup = new ButtonGroup();
		demoMode = new JRadioButton("Demo mode", true);
		demoMode.setActionCommand("Demo mode");
		onePlayerMode = new JRadioButton("1 player Mode");
		onePlayerMode.setActionCommand("1 player Mode");
		onePlayerMode.setEnabled(false);
		twoPlayersMode = new JRadioButton("2 players Mode");
		twoPlayersMode.setEnabled(false);
		twoPlayersMode.setActionCommand("2 player Mode");
		//Grouper les Radio btns pour limiter la selection
		gameModeGroup.add(demoMode);
		gameModeGroup.add(onePlayerMode);
		gameModeGroup.add(twoPlayersMode);	
		
		/*
		 * Type de combat 
		 */
		JLabel battleTypeLabel = new JLabel("Type de bataille");
		battleTypeLabel.setFont(new Font("Segoe UI",Font.PLAIN,18));
		battleTypeGroup = new ButtonGroup();
		battleshipType = new JRadioButton("Battle Ship", true);
		battleshipType.setActionCommand("Battle Ship");
		radarType = new JRadioButton("Mission radar player");
		radarType.setActionCommand("Mission radar player");
		radarType.setEnabled(false);
		artilleryOperationType = new JRadioButton("Artillery operation player");
		artilleryOperationType.setActionCommand("Artillery operation player");
		artilleryOperationType.setEnabled(false);
		redAlertType = new JRadioButton("Red Alert");
		redAlertType.setActionCommand("Red Alert");
		redAlertType.setEnabled(false);
		//Grouper les Radio btns pour limiter la selection
		battleTypeGroup.add(battleshipType);
		battleTypeGroup.add(radarType);
		battleTypeGroup.add(artilleryOperationType);
		battleTypeGroup.add(redAlertType);

		/*
		 * Navires
		 */
		JLabel shipsLabel = new JLabel("Navires");
		shipsLabel.setFont(new java.awt.Font("Segoe UI", 0, 18));
		aircraftCarrierChk = new JCheckBox("AirecraftCarrier");//porte avions
		nuclearSubmarineChk = new JCheckBox("Nuclear SubMarine");//sous marin nucleaire
		stealthBattleship1Chk = new JCheckBox("Stealth armor first");//cuirasses furtifs
		stealthBattleship2Chk = new JCheckBox("Stealth armor second");//cuirasses furtifs
		zodiacChk = new JCheckBox("Zodiac");
		
		
		/*
		 * Placer les elements 
		 */
		startBtn = new JButton("Commencer");
		startBtn.setActionCommand("Switch Card");
        startBtn.addActionListener(listener);//ajout d'un ecouteur sur le bouton start
        
        
		layout = new GroupLayout(gameElementsPanel);
		gameElementsPanel.setLayout( layout );
		
		JSeparator separateur = new JSeparator();
		
		layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addGap(0, 0, Short.MAX_VALUE)
	                .addComponent(startBtn)
	                .addGap(49, 49, 49))
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(48, 48, 48)
	                        .addComponent(separateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(118, 118, 118)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
	                            .addComponent(gameModeLabel)
	                            .addComponent(demoMode)
	                            .addComponent(onePlayerMode)
	                            .addComponent(twoPlayersMode))
	                        .addGap(130, 130, 130)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
	                            .addComponent(artilleryOperationType)
	                            .addComponent(redAlertType)
	                            .addComponent(battleTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(battleshipType)
	                            .addComponent(radarType)))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(76, 76, 76)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(aircraftCarrierChk)
	                                .addGap(125, 125, 125)
	                                .addComponent(nuclearSubmarineChk)
	                                .addGap(114, 114, 114)
	                                .addComponent(stealthBattleship1Chk))
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(111, 111, 111)
	                                .addComponent(stealthBattleship2Chk)
	                                .addGap(120, 120, 120)
	                                .addComponent(zodiacChk))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(322, 322, 322)
                                    .addComponent(shipsLabel)))
	                .addContainerGap(142, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addContainerGap(51, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(separateur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                        .addGroup(layout.createSequentialGroup()
	                            .addComponent(gameModeLabel)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                            .addComponent(demoMode)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                            .addComponent(onePlayerMode)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                            .addComponent(twoPlayersMode)
	                            .addGap(23, 23, 23))
	                        .addGroup(layout.createSequentialGroup()
	                            .addComponent(battleTypeLabel)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                            .addComponent(battleshipType)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                            .addComponent(radarType)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                            .addComponent(artilleryOperationType)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(redAlertType))))
                        .addGap(59, 59, 59)
                .addComponent(shipsLabel)
                .addGap(36, 36, 36)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(nuclearSubmarineChk)
	                    .addComponent(aircraftCarrierChk)
	                    .addComponent(stealthBattleship1Chk))
	                .addGap(71, 71, 71)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(stealthBattleship2Chk)
	                    .addComponent(zodiacChk))
	                .addGap(75, 75, 75)
	                .addComponent(startBtn)
	                .addGap(48, 48, 48))
	        );
	        
	}
	
	public JButton getStartBtn() {
		return startBtn;
	}

	public Container buildContentPane() {
		// TODO Auto-generated method stub
		return null;
	}

	private void initGameElements(){		
		//premiere grille du joueur 1
		gameGridPanel = new JPanel();
		gameGridPanel.add(new JLabel("Gamer 1"));
		gamer1Grid = new Grid();
		gameGridPanel.add( gamer1Grid );
		
		//seconde grille pour le joueur 2
		gameGridPanel.add(new JLabel("Gamer 2"));
		gamer2Grid = new Grid();
		gameGridPanel.add(gamer2Grid );
	}
	
	public JPanel getCardsPanel() {
        return cardsPanel;
    }
	
	public JPanel getGameGridPanel()
	{
		return this.gameGridPanel;
	}

	/*public  Grid getGamer1Grid() {
		return gamer1Grid;
	}

	public  Grid getGamer2Grid() {
		return gamer2Grid;
	}
	
	public  void setGamer2Grid(Grid grid) {
		gamer2Grid = grid;
	}*/

	
}
