package com.battleship.model;

import java.util.HashMap;

public class Game {

	private Gamer gamers[]= new Gamer[2];
	private int currentGamer;
	private Ship ships[];

	public Game(){
		gamers[0]= new Gamer();
		gamers[1]= new IA();
		currentGamer = 1;
		this.ships = new Ship[5];
	}


	public void optiongame(){
		// initialiser les bateaux
		this.ships[0] = new Ship("porte-avion", null, null, 5);
		this.ships[1] = new Ship("sous-marin nucléaire", null, null, 4);
		this.ships[2] = new Ship("cuirassés furtifs 1", null, null, 3);
		this.ships[3] = new Ship("cuirassés furtifs 2", null, null, 3);
		this.ships[4] = new Ship("zodiac", null, null, 2);


	}
}
