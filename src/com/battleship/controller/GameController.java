package com.battleship.controller;

import com.battleship.model.*;
import com.battleship.view.GridWindow;
import com.battleship.view.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

public class GameController implements ActionListener{
	private Window mView;

	public GameController (Window window){
		this.mView = window;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		//Initialisation des bateaux
		//Ship[] ships = new Ship[5];
		Vector<Ship> ships = new Vector<Ship>();
		
		int selectedShips = 0;
		if (this.mView.aircraftCarrierChk.isSelected()){ships.add(new Ship("porte-avion", new Coordinates(), "", 5));selectedShips++;}
		if (this.mView.nuclearSubmarineChk.isSelected()){ships.add(new Ship("sous-marin nucl�aire", new Coordinates(), "", 4));selectedShips++;}
		if (this.mView.stealthBattleship1Chk.isSelected()){ships.add(new Ship("cuirass�s furtifs 1", new Coordinates(), "", 3));selectedShips++;}
		if (this.mView.stealthBattleship2Chk.isSelected()){ships.add(new Ship("cuirass�s furtifs 2", new Coordinates(), "", 3));selectedShips++;}
		if (this.mView.zodiacChk.isSelected()){ships.add(new Ship("zodiac", new Coordinates(), "", 2));selectedShips++;}
		
		if (0 == selectedShips)
		{
			JOptionPane.showMessageDialog(this.mView, "Vous devez au moins selectionner un navire");
			return;
		}
		
		//Initialisation des options du jeu (class Game dans le model)
		GameModel game = new GameModel(this.mView.gameModeGroup.getSelection().getActionCommand(),
											   this.mView.battleTypeGroup.getSelection().getActionCommand(), ships);
				
		//Initialisation des Joueurs
		Gamer gamer1 = game.getFirstGamer();
		Gamer gamer2 = game.getSecondGamer();		
		
		switch( game.getGameMode() ){
			case "Demo mode":
				IAController iac = new IAController( gamer1.getShips(), game.getFirstGamer().getGrid(), game.getShipsCoordinatesGamer1() );
				IAController iac2 = new IAController( gamer2.getShips(), game.getSecondGamer().getGrid(), game.getShipsCoordinatesGamer2() );
				ShipController sc = new ShipController(game, gamer1.getShips(), gamer2.getShips());
				
				mView.setVisible(false);
				mView.dispose();
				
				GridWindow gw = new GridWindow(iac.getGrid(), iac2.getGrid()); 
				while ("Partie en cours" == game.getGameStatus())
				{
					gamer1.shoot();
					gamer2.shoot();
				}

				System.out.println( game.getGameStatus() );
				gw.txtAreaG1.append("\tPartie Fini ! " + game.getGameStatus());
				gw.txtAreaG2.append("\tPartie Fini ! " + game.getGameStatus());
				break;
				
			case "1 player Mode":
				System.out.println("1 player Mode Selected");
				
				GamerController gc = new GamerController( gamer1.getShips(), game.getFirstGamer().getGrid(), game.getShipsCoordinatesGamer1() );
				IAController iac1 = new IAController( gamer2.getShips(), game.getSecondGamer().getGrid(), game.getShipsCoordinatesGamer2() );
				
				ShipController sc2 = new ShipController(game, gamer1.getShips(), gamer2.getShips());
				
				mView.setVisible(false);
				mView.dispose();
				
				GridWindow gw2 = new GridWindow(gc.getGrid(), iac1.getGrid()); 
				break;
				
			case "2 player Mode":
				System.out.println("2 players Mode Selected");
				
				GamerController gc1 = new GamerController( gamer1.getShips(), game.getFirstGamer().getGrid(), game.getShipsCoordinatesGamer1() );
				GamerController gc2 = new GamerController( gamer2.getShips(), game.getSecondGamer().getGrid(), game.getShipsCoordinatesGamer2() );
				ShipController sc3 = new ShipController(game, gamer1.getShips(), gamer2.getShips());
				
				mView.setVisible(false);
				mView.dispose();
				
				GridWindow gw3 = new GridWindow(gc1.getGrid(), gc2.getGrid()); 
				break;
		}
		
	}
	
}

