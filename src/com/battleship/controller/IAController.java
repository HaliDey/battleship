package com.battleship.controller;

import java.util.Random;

import com.battleship.view.Grid;

public class IAController {

	
	public void placeShip(){
		Grid g= new Grid();
		for(int i=0; i<5; i++){
			Random rand= new Random();
			int nmb= rand.nextInt(2-1+1)+1;
			char pos =nmb==2? 'H' : 'V';
			
				

		
		}
	}
}
