package com.battleship.controller;

import com.battleship.model.*;
import com.battleship.observer.Observable;
import com.battleship.view.GridWindow;
import com.battleship.view.Window;
import com.battleship.view.Grid;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener, Observable{
	private Window mView;

	public GameController (Window window){
		this.mView = window;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		//Initialisation des options du jeu (class Game dans le model)
		GameModel game = new GameModel(this.mView.gameModeGroup.getSelection().getActionCommand(),
									   this.mView.battleTypeGroup.getSelection().getActionCommand());
		
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
				
				System.out.println("Gamer 1");
				for (Ship tmp : gamer1.getShips())
				{
					System.out.println( tmp.toString() );
				}
				
				System.out.println("Gamer 2");
				for (Ship tmp : gamer2.getShips())
				{
					System.out.println( tmp.toString() );
				}
				
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
	
	@Override
	public void addObserver(Grid grid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObserver(Grid grid) {
		// TODO Auto-generated method stub
	}
}
 
