package com.battleship.model;

import java.util.ArrayList;

import com.battleship.observer.Observable;
import com.battleship.view.Grid;

public class GameModel implements Observable {

	private Gamer gamers[];
	private static int currentGamer;
	private Ship shipsGamer1[], shipsGamer2[];
	private static String gameMode, gameType, gameStatus;

	private ArrayList<Coordinates> shipsCoordinatesGamer1, shipsCoordinatesGamer2;

	public GameModel(String gameMode, String gameType){
		this.optiongame();
		
		this.gameMode = gameMode;
		this.gameType = gameType;
		this.setGameStatus("Partie en cours");

		this.shipsCoordinatesGamer1 = new ArrayList<Coordinates>();
		this.shipsCoordinatesGamer2 = new ArrayList<Coordinates>();
		
		this.gamers = new Gamer[2];
		if ("Demo mode" == this.gameMode) { this.gamers[0] = new IA(new Grid(this.shipsCoordinatesGamer1, 1), shipsGamer1); }
		else { this.gamers[0] = new Gamer(new Grid(this.shipsCoordinatesGamer1, 1), shipsGamer1); }
		this.gamers[1] = new IA(new Grid(this.shipsCoordinatesGamer2, 2), shipsGamer2);
		
		currentGamer = 1;
	}

	public void optiongame(){
		// initialiser les bateaux
		this.shipsGamer1    = new Ship[5];
		this.shipsGamer1[0] = new Ship("porte-avion", new Coordinates(), "", 5);
		this.shipsGamer1[1] = new Ship("sous-marin nucléaire", new Coordinates(), "", 4);
		this.shipsGamer1[2] = new Ship("cuirassés furtifs 1", new Coordinates(), "", 3);
		this.shipsGamer1[3] = new Ship("cuirassés furtifs 2", new Coordinates(), "", 3);
		this.shipsGamer1[4] = new Ship("zodiac", new Coordinates(), "", 2);
		
		this.shipsGamer2    = new Ship[5];
		this.shipsGamer2[0] = new Ship("porte-avion", new Coordinates(), "", 5);
		this.shipsGamer2[1] = new Ship("sous-marin nucléaire", new Coordinates(), "", 4);
		this.shipsGamer2[2] = new Ship("cuirassés furtifs 1", new Coordinates(), "", 3);
		this.shipsGamer2[3] = new Ship("cuirassés furtifs 2", new Coordinates(), "", 3);
		this.shipsGamer2[4] = new Ship("zodiac", new Coordinates(), "", 2);
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

	public ArrayList<Coordinates> getShipsCoordinatesGamer1() {
		return shipsCoordinatesGamer1;
	}

	public void setShipsCoordinatesGamer1(ArrayList<Coordinates> shipsCoordinatesGamer1) {
		this.shipsCoordinatesGamer1 = shipsCoordinatesGamer1;
	}

	public ArrayList<Coordinates> getShipsCoordinatesGamer2() {
		return shipsCoordinatesGamer2;
	}

	public void setShipsCoordinatesGamer2(ArrayList<Coordinates> shipsCoordinatesGamer2) {
		this.shipsCoordinatesGamer2 = shipsCoordinatesGamer2;
	}

	public static String getGameMode() {
		return gameMode;
	}

	public String getGameType() {
		return gameType;
	}

	public static int getCurrentGamer() {
		return currentGamer;
	}

	public static void setCurrentGamer(int currentGamer) {
		GameModel.currentGamer = currentGamer;
	}

	public String getGameStatus() {
		if ( this.checkShips(this.shipsGamer1) )
			return "Joueur 2 a gagner";
		
		if ( this.checkShips(this.shipsGamer2) )
			return "Joueur 1 a gagner";
		
		return gameStatus;
	}

	public void setGameStatus(String gameStatus) {
		this.gameStatus = gameStatus;
	}
	
	public boolean checkShips(Ship[] ships){
		for (Ship tmp : ships){
			if (!tmp.estCoule()) return false;
		}
		
		return true;
	}
}
