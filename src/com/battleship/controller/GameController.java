package com.battleship.controller;

import com.battleship.model.*;
import com.battleship.observer.Observable;
import com.battleship.view.Window;
import com.battleship.view.Grid;
import com.battleship.view.Cell;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.Border;
import javax.swing.border.MatteBorder;


public class GameController implements ActionListener, Observable{
	private Window mView;

	public GameController (Window window){
		this.mView = window;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()){
			case "Switch Card":
				
				//Initialisation des options du jeu (class Game dans le model)
				String mode = this.mView.gameModeGroup.getSelection().getActionCommand();
				String type = this.mView.battleTypeGroup.getSelection().getActionCommand();
				
				GameModel game = new GameModel();
				Gamer gamer = game.getFirstGamer();
				Gamer ia = game.getSecondGamer();
				
				IAController iac = new IAController( game.getFirstGamer().getShips() );
				
				Ship ships[] = game.getSecondGamer().getShips();
				
				for (Ship tmp : ships)
				{
					System.out.println( tmp.getShipname() + " - " + tmp.getOrientation() + " - " + tmp.getCoordinates().getX() + " - " + tmp.getCoordinates().getY() );
					
					//Afficher les bateaux sur la grille
					this.updateCell( Window.gamer2Grid, tmp ) ;
				}
				
				mView.getCards().next( mView.getCardsPanel() );
			break;
		}
	}
	
	public void updateCell(Grid grid, Ship ship){
		GridBagConstraints gbc = grid.getGbc();
		
		if (ship.getOrientation() == "V")
		{
			gbc.gridx = ship.getCoordinates().getX();
			for (int i=ship.getCoordinates().getY(); i>ship.getCoordinates().getY()+ship.getNumbercell(); i++){
				gbc.gridy = i;

                Cell cellPane = new Cell();
                
                cellPane.setCellX(ship.getCoordinates().getX());
                cellPane.setCellY(i);
                
                Border border = null;
                if (i < 9) {
                    if (ship.getCoordinates().getX() < 9) {
                        border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
                    }
                } else {
                    if (ship.getCoordinates().getX() < 9) {
                        border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                    }
                }
                cellPane.setBorder(border);
                cellPane.defaultBackground = cellPane.getBackground();
                cellPane.setBackground(Color.CYAN);
                
                grid.add(cellPane, gbc);
			}
		} else {
			
			gbc.gridy = ship.getCoordinates().getY();
			for (int i=ship.getCoordinates().getX(); i>ship.getCoordinates().getX()+ship.getNumbercell(); i++){
				gbc.gridx = i;

                Cell cellPane = new Cell();
                
                cellPane.setCellX(ship.getCoordinates().getX());
                cellPane.setCellY(i);
                
                Border border = null;
                if (ship.getCoordinates().getY() < 9) {
                    if (i < 9) {
                        border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
                    }
                } else {
                    if (i < 9) {
                        border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                    }
                }
                cellPane.setBorder(border);
                cellPane.defaultBackground = cellPane.getBackground();
                cellPane.setBackground(Color.CYAN);
                
                grid.add(cellPane, gbc);
			}
			
		}
		
		this.notifyObserver(grid);

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
 
