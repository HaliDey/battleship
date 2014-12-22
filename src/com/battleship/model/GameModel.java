package com.battleship.model;

import com.battleship.observer.Observable;
import com.battleship.view.Grid;

public class GameModel implements Observable {

	private Gamer gamers[];
	private int currentGamer;
	private Ship ships[];

	public GameModel(){
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

	@Override
	public void addObserver(com.battleship.view.Grid grid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObserver(com.battleship.view.Grid grid) {
		// TODO Auto-generated method stub
		
	}

	
	
}
