package com.battleship.view;
import com.battleship.model.ButtonsActionListener;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


@SuppressWarnings("serial")
public class Window extends JFrame implements Observer{

	private static final Component Ship = null;

	private static final AbstractButton TypePanel = null;

	private CardLayout cards = new CardLayout();
	  
	private JPanel choicesContainer, cardsPanel, firstCardPanel, secondCardPanel;
	
	private JPanel modePanel;
	private JLabel gameModeLabel;
	private ButtonGroup gameModeGroup;
	private JRadioButton demoMode, onePlayerMode, twoPlayersMode;

	private JPanel typePanel;
	private JLabel battleTypeLabel;
	private ButtonGroup battleTypeGroup;
	private JRadioButton battleshipType, radarType, artilleryOperationType, redAlertType;
	
	private JPanel shipsPanel;
	private JLabel shipsLabel;	
	private JCheckBox aircraftCarrierChk, nuclearSubmarineChk, stealthBattleship1Chk, stealthBattleship2Chk, zodiacChk;
	
	private JButton startBtn, playBtn;
	private ButtonsActionListener listener;
	private JLabel gameModeTextView;

	public Window(){
		this.setTitle("THE BATTLE SHIP");//On donne un titre à l'application
	    this.setSize(900,800);//pour redimentionner la taille de la fenetre du menu
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
	    this.setLocationRelativeTo(null);//On centre la fenêtre sur l'écran
	    
	    listener = new ButtonsActionListener(this);
	    
	    this.initChoicesElements();
	    this.initGameElements();
	                   
	    this.setContentPane(cardsPanel);
	    this.setVisible(true);//visibilité de la fenetre
	}
	private void initChoicesElements(){
		//choix des éléments
		modePanel = new JPanel();
		modePanel.setLayout(new BoxLayout(modePanel, BoxLayout.PAGE_AXIS));
		gameModeTextView=(new JLabel("Choose the play Mode"));
		gameModeGroup = new ButtonGroup();
		demoMode = new JRadioButton("Demo mode");
		onePlayerMode = new JRadioButton("1 player Mode");
		twoPlayersMode = new JRadioButton("2 players Mode");
		
		// ajout radio buttons au groupe en selectioner seulement 1
		gameModeGroup.add(demoMode);
		gameModeGroup.add(onePlayerMode);
		gameModeGroup.add(twoPlayersMode);	
		
		// Ajout de l'élément au panel

		modePanel.add(demoMode);
		modePanel.add(onePlayerMode);
		modePanel.add(twoPlayersMode);
		
		typePanel = new JPanel();
		typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.PAGE_AXIS));
		battleTypeLabel = new JLabel("Choose the battle type");
		battleTypeGroup = new ButtonGroup();
		battleshipType = new JRadioButton("Battle Ship");
		radarType = new JRadioButton("Mission radar player");
		artilleryOperationType = new JRadioButton("Artillery operation player");
		redAlertType = new JRadioButton("Red Alert");
	
		
		// ajout radio buttons au groupe en selectioner seulement 1
		battleTypeGroup.add(battleshipType);
		battleTypeGroup.add(radarType);
		battleTypeGroup.add(artilleryOperationType);
		battleTypeGroup.add(redAlertType);
		
		// ajout des elements au panel
		typePanel.add(battleTypeLabel);
		typePanel.add(battleshipType);
		typePanel.add(radarType);
		typePanel.add(artilleryOperationType);
		typePanel.add(redAlertType);

		shipsPanel = new JPanel();
		
		shipsPanel.setLayout(new BoxLayout(shipsPanel, BoxLayout.LINE_AXIS));
		
		shipsPanel.setLayout( new GridLayout(5, 5) );
		
		//Pour nommer les differents navires par les boutons de type chekbox
		shipsLabel = new JLabel("Ship");
		battleTypeGroup = new ButtonGroup();
		aircraftCarrierChk = new JCheckBox("AirecraftCarrier");//porte_avions
		nuclearSubmarineChk = new JCheckBox("Nuclear SubMarine");//sous marin nucleaire
		stealthBattleship1Chk = new JCheckBox("Stealth armor first");//cuirasses furtifs
		stealthBattleship2Chk = new JCheckBox("Stealth armor second");//cuirasses furtifs
		zodiacChk = new JCheckBox("Zodiac");
		
		// Ajouter les elements au panel
		shipsPanel.add(aircraftCarrierChk);
		shipsPanel.add(nuclearSubmarineChk);
		shipsPanel.add(stealthBattleship1Chk);
		shipsPanel.add(stealthBattleship2Chk);
		shipsPanel.add(zodiacChk);						

		startBtn = new JButton("Start");
		
		startBtn.setActionCommand("Switch Card");
		startBtn.addActionListener(listener);//ajout d'un ecouteur sur le bouton start
		
		choicesContainer = new JPanel();
		choicesContainer.setLayout(new BoxLayout(choicesContainer, BoxLayout.LINE_AXIS));
		choicesContainer.add(modePanel);
		choicesContainer.add(typePanel);						
		
		firstCardPanel = new JPanel();
		firstCardPanel.setLayout(new BoxLayout(firstCardPanel, BoxLayout.PAGE_AXIS));
		firstCardPanel.add(choicesContainer);
		firstCardPanel.add(shipsLabel);
		firstCardPanel.add(shipsPanel);
		firstCardPanel.add(startBtn);
		
		
		// game elements container
		//premiere page
		/*firstCardPanel = new JPanel();
		cards = new CardLayout();
		cardsPanel = new JPanel();
		cardsPanel.setLayout(cards);*/
		
		
		
		//seconde page
		secondCardPanel = new JPanel();
		cards = new CardLayout();	
		cardsPanel = new JPanel();
		cardsPanel.setLayout(cards);
		cards.show(cardsPanel, "First Screen");
		cardsPanel.add(firstCardPanel, "Fruits");
        cardsPanel.add(secondCardPanel, "Veggies");
	}
	
	/*public Container buildContentPane() {
		// TODO Auto-generated method stub
		return null;
	}*/

	private void initGameElements(){		
		//premiere grille du joueur 1
		secondCardPanel.add(new JLabel("Gamer 1"));
		secondCardPanel.add(new Grid() );
		
		//seconde grille pour le joueur 2
		secondCardPanel.add(new JLabel("Gamer 2"));
		secondCardPanel.add(new Grid() );
		

		
		
		
		
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {}
	
	public CardLayout getCards() {
		return cards;
	}

	public void setCards(CardLayout cards) {
		this.cards = cards;
	}

	public JPanel getCardsPanel() {
		return cardsPanel;
	}

	public void setCardsPanel(JPanel cardsPanel) {
		this.cardsPanel = cardsPanel;
	}

	public static AbstractButton getTypepanel() {
		return TypePanel;
	}

	public static Component getShip() {
		return Ship;
	}

	public JButton getPlayBtn() {
		return playBtn;
	}

	public void setPlayBtn(JButton playBtn) {
		this.playBtn = playBtn;
	}

	public JLabel getGameModeLabel() {
		return gameModeLabel;
	}

	public void setGameModeLabel(JLabel gameModeLabel) {
		this.gameModeLabel = gameModeLabel;
	}

	public JLabel getGameModeTextView() {
		return gameModeTextView;
	}

	public void setGameModeTextView(JLabel gameModeTextView) {
		this.gameModeTextView = gameModeTextView;
	}

	
}
