package com.battleship.controller;

import com.battleship.model.*;
import com.battleship.view.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonsActionListener implements ActionListener{
	private Window mView;

	public ButtonsActionListener (Window window){
		this.mView = window;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()){
			case "Switch Card":
				//Initialisation des options du jeu ICI (class Game dans le model)
				Game game = new Game();
				System.out.println("1");
				Gamer gamer = game.getFirstGamer();
				Gamer ia = game.getSecondGamer();
				
				System.out.println("2");
				IAController iac = new IAController( game.getFirstGamer().getShips() );
				
				System.out.println("3");
				Ship ships[] = game.getSecondGamer().getShips();
				
				System.out.println("4");
				for (Ship tmp : ships)
				{
					System.out.println( tmp.getShipname() + " - " + tmp.getOrientation() + " - " + tmp.getCoordinates().getX() + " - " + tmp.getCoordinates().getY() );
				}
				
				mView.getCards().next( mView.getCardsPanel() );
			break;
		}
	}
}
 
