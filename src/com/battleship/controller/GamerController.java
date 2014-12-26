package com.battleship.controller;


import java.util.Random;

import com.battleship.model.Coordinates;
import com.battleship.model.Ship;


public class GamerController {
private Ship ships[];
	
	public GamerController(Ship ships[]){
		this.ships = ships;
		this.placeShip();
	}
	
	public void placeShip(){
		Coordinates c1 = new Coordinates(0,4);
		Coordinates c2 = new Coordinates(3,7);
		Coordinates c3 = new Coordinates(1,4);
		Coordinates c4 = new Coordinates(5,8);
		Coordinates c5 = new Coordinates(8,10);
		
		this.ships[0].setOrientation("H");
		this.ships[1].setOrientation("V");
		this.ships[2].setOrientation("V");
		this.ships[3].setOrientation("H");
		this.ships[4].setOrientation("V");
		
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
	}
	
	public void shoot(){
		
	}
	
}
