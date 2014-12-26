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
		// TODO Auto-generated method stub
		switch (e.getActionCommand()){
			case "Switch Card":
			break;
		}
		
		//Initialisation des options du jeu (class Game dans le model)
		String mode = this.mView.gameModeGroup.getSelection().getActionCommand();
		String type = this.mView.battleTypeGroup.getSelection().getActionCommand();
		
		GameModel game = new GameModel();
		Gamer gamer = game.getFirstGamer();
		Gamer ia = game.getSecondGamer();
		
		IAController iac = new IAController( game.getFirstGamer().getGrid(),  game.getFirstGamer().getShips() );
		IAController iac2 = new IAController( game.getSecondGamer().getGrid(), game.getSecondGamer().getShips() );
		
		mView.setVisible(false); //you can't see me!
		mView.dispose(); //Destroy the JFrame object
		
		GridWindow gw = new GridWindow(iac.getGrid(), iac2.getGrid());  
		
		//mView.getCards().next( mView.getCardsPanel() );
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
 
