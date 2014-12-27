package com.battleship.controller;


import java.awt.Color;
import java.util.ArrayList;

import com.battleship.model.Coordinates;
import com.battleship.model.Ship;
import com.battleship.view.Cell;
import com.battleship.view.Grid;

public class IAController {
	private Ship ships[];
	private Grid grid;
	private ArrayList<Coordinates> shipsCoordinates;
		
	public IAController(Ship ships[], Grid grid, ArrayList<Coordinates> shipsCoordinates){
		this.ships = ships;
		this.grid = grid;
		this.shipsCoordinates = shipsCoordinates;
		
		this.placeShip();
	}
	
	public void placeShip(){
		
		Coordinates c1 = new Coordinates(0,0);
		Coordinates c2 = new Coordinates(3,7);
		Coordinates c3 = new Coordinates(2,4);
		Coordinates c4 = new Coordinates(6,2);
		Coordinates c5 = new Coordinates(9,7);
		
		this.ships[0].setOrientation("H");
		this.ships[1].setOrientation("V");
		this.ships[2].setOrientation("V");
		this.ships[3].setOrientation("H");
		this.ships[4].setOrientation("H");
		
		this.ships[0].setCoordinates(c1);
		this.ships[1].setCoordinates(c2);
		this.ships[2].setCoordinates(c3);
		this.ships[3].setCoordinates(c4);
		this.ships[4].setCoordinates(c5);
		
		/*for(Ship tmp : this.ships){
			int numbercell = tmp.getNumbercell();
			
			Random rand = new Random();
			int nmb = rand.nextInt(2)+1;
			char pos = nmb == 2? 'H' : 'V';
		}*/
		
		//Placer les bateaux sur la grille
		
		System.out.println("Classe : IAController - Methode : placeShip");
		for (Ship tmp : ships)
		{
			System.out.println( tmp.getShipname() + " - " + tmp.getOrientation() + " - " + tmp.getCoordinates().getX() + " - " + tmp.getCoordinates().getY() );
			
			try{
				if (tmp.getOrientation() == "H")
				{    
				    for (int i=tmp.getCoordinates().getY(); i<tmp.getCoordinates().getY()+tmp.getNumbercell(); i++){
				        Cell cellPane = this.grid.tab[tmp.getCoordinates().getX()][i];
				        cellPane.setBackground(Color.ORANGE);
				        cellPane.setDefaultBackground(Color.ORANGE);
				        
				        //Ajout des coordonnées 
				        this.shipsCoordinates.add(new Coordinates (tmp.getCoordinates().getX(), i));
				    }
				} else {    
				    for (int i=tmp.getCoordinates().getX(); i<tmp.getCoordinates().getX()+tmp.getNumbercell(); i++){
				       Cell cellPane = this.grid.tab[i][tmp.getCoordinates().getY()];
				       cellPane.setBackground(Color.ORANGE);
				       cellPane.setDefaultBackground(Color.ORANGE);
				       
				    	//Ajout des coordonnées
				        this.shipsCoordinates.add(new Coordinates (i, tmp.getCoordinates().getY()));
				    }
				}
	         	
            } catch(Exception e){
            	System.err.println("Erreur !! row : "+ tmp.getCoordinates().getX() +" col : "+ tmp.getCoordinates().getY());
            }
				
		}
		
		this.grid.setShipsCoordinates( this.shipsCoordinates );
	}
	
	public Ship[] getShips() {
		return ships;
	}

	public void setShips(Ship[] ships) {
		this.ships = ships;
	}

	public Grid getGrid() {
		return grid;
	}

	public void shoot(){
		
	}
	
	
}
