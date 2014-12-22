package com.battleship.controller;


import java.util.Random;

import com.battleship.view.Grid;
import com.battleship.model.Gamer;


public class GamerController {
	private Gamer gamer;
	
	public GamerController(Gamer gamer){
		this.gamer = gamer;
	}
	
	public void placeShip(){
		Grid g= new Grid();
		for(int i=0; i<5; i++){
			Random rand= new Random();
			int nmb= rand.nextInt(2-1+1)+1;
			char pos =nmb==2? 'H' : 'V';
		}
	}
	
	public void shoot(){
		
	}
	
}
