package com.battleship.view;
import com.battleship.model.ButtonsActionListener;

import java.awt.CardLayout;
import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Window extends JFrame implements Observer{

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

	public Window(){
		this.setTitle("Bataille navale");
	    this.setSize(700, 600);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    
	    listener = new ButtonsActionListener(this);
	    
	    this.initChoicesElements();
	    this.initGameElements();
	                   
	    this.setContentPane(cardsPanel);
	    this.setVisible(true);
	}
	
	private void initChoicesElements(){
		modePanel = new JPanel();
		modePanel.setLayout(new BoxLayout(modePanel, BoxLayout.PAGE_AXIS));
		gameModeLabel = new JLabel("Mode de jeu");
		gameModeGroup = new ButtonGroup();
		demoMode = new JRadioButton("Mode demo");
		onePlayerMode = new JRadioButton("Mode 1 Joueur");
		twoPlayersMode = new JRadioButton("Mode 2 Joueurs");
		// Adding radio buttons to a group so only one will be selected
		gameModeGroup.add(demoMode);
		gameModeGroup.add(onePlayerMode);
		gameModeGroup.add(twoPlayersMode);	
		// Adding elements to a panel
		modePanel.add(gameModeLabel);
		modePanel.add(demoMode);
		modePanel.add(onePlayerMode);
		modePanel.add(twoPlayersMode);
		
		typePanel = new JPanel();
		typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.PAGE_AXIS));
		battleTypeLabel = new JLabel("Type de bataille");
		battleTypeGroup = new ButtonGroup();
		battleshipType = new JRadioButton("Bataille Navale");
		radarType = new JRadioButton("Joueur Mission Radar");
		artilleryOperationType = new JRadioButton("Joueurs Opération Artillerie");
		redAlertType = new JRadioButton("Alerte rouge");
		// Adding radio buttons to a group so only one will be selected
		battleTypeGroup.add(battleshipType);
		battleTypeGroup.add(radarType);
		battleTypeGroup.add(artilleryOperationType);
		battleTypeGroup.add(redAlertType);
		// Adding elements to a panel
		typePanel.add(battleTypeLabel);
		typePanel.add(battleshipType);
		typePanel.add(radarType);
		typePanel.add(artilleryOperationType);
		typePanel.add(redAlertType);

		shipsPanel = new JPanel();
		//shipsPanel.setLayout(new BoxLayout(shipsPanel, BoxLayout.LINE_AXIS));
		shipsPanel.setLayout( new GridLayout(1, 5) );
		
		shipsLabel = new JLabel("Navires");
		aircraftCarrierChk = new JCheckBox("porte-avions");
		nuclearSubmarineChk = new JCheckBox("sous-marin nucléaire");
		stealthBattleship1Chk = new JCheckBox("cuirassés furtifs");
		stealthBattleship2Chk = new JCheckBox("cuirassés furtifs");
		zodiacChk = new JCheckBox("zodiac");
		// Adding elements to a panel
		shipsPanel.add(aircraftCarrierChk);
		shipsPanel.add(nuclearSubmarineChk);
		shipsPanel.add(stealthBattleship1Chk);
		shipsPanel.add(stealthBattleship2Chk);
		shipsPanel.add(zodiacChk);						

		startBtn = new JButton("Commencer");
		startBtn.setActionCommand("Switch Card");
		
		
		startBtn.addActionListener(listener);
		
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
		secondCardPanel = new JPanel();
		
		cards = new CardLayout();	
		cardsPanel = new JPanel();
		cardsPanel.setLayout(cards);
		cards.show(cardsPanel, "First Screen");
		cardsPanel.add(firstCardPanel, "Fruits");
        cardsPanel.add(secondCardPanel, "Veggies");
	}
	
	private void initGameElements(){		
		secondCardPanel.add(new JLabel("Second screen"));
		
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
	
	
}
