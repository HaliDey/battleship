package com.battleship.model;

import java.util.HashMap;

public class Game {

	private Gamer gamers[];
	private int currentGamer;
	private Ship ships[];

	public Game(){
		this.optiongame();
		
		this.gamers = new Gamer[2];
		this.gamers[0] = new Gamer(new Grid(), ships);
		this.gamers[1] = new IA(new Grid(), ships);
		this.currentGamer = 1;
		
	}

	public void optiongame(){
		// initialiser les bateaux
		this.ships = new Ship[5];
		this.ships[0] = new Ship("porte-avion", new Coordinates(), "", 5);
		this.ships[1] = new Ship("sous-marin nucléaire", new Coordinates(), "", 4);
		this.ships[2] = new Ship("cuirassés furtifs 1", new Coordinates(), "", 3);
		this.ships[3] = new Ship("cuirassés furtifs 2", new Coordinates(), "", 3);
		this.ships[4] = new Ship("zodiac", new Coordinates(), "", 2);
	}
	
	
	public Gamer getFirstGamer()
	{
		return this.gamers[0];
	}
	
	public Gamer getSecondGamer()
	{
		return this.gamers[1];
	}
	
}
