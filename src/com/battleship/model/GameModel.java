package com.battleship.model;

import java.util.ArrayList;
import java.util.Vector;

import com.battleship.view.Grid;

public class GameModel{

	private Gamer gamers[];
	private static int currentGamer;
	private Vector<Ship> shipsGamer1, shipsGamer2;
	private static String gameMode, gameType, gameStatus;

	private ArrayList<Coordinates> shipsCoordinatesGamer1;
	private static ArrayList<Coordinates> shipsCoordinatesGamer2;

	public GameModel(String gameMode, String gameType, Vector<Ship> ships){
		//this.optiongame();
		
		this.gameMode = gameMode;
		this.gameType = gameType;
		
		this.shipsGamer1 = ships;
		this.shipsGamer2 = ships;
		
		this.setGameStatus("Partie en cours");

		this.shipsCoordinatesGamer1 = new ArrayList<Coordinates>();
		this.shipsCoordinatesGamer2 = new ArrayList<Coordinates>();
		
		this.gamers = new Gamer[2];
		if ("Demo mode" == this.gameMode) { this.gamers[0] = new IA(new Grid(this.shipsCoordinatesGamer1, 1), shipsGamer1); }
		else { this.gamers[0] = new Gamer(new Grid(this.shipsCoordinatesGamer1, 1), shipsGamer1); }
		this.gamers[1] = new IA(new Grid(this.shipsCoordinatesGamer2, 2), shipsGamer2);
		
		currentGamer = 1;
	}
	
	public boolean checkShips(Vector<Ship> ships){
		for (Ship tmp : ships){
			if (!tmp.estCoule()) return false;
		}
		
		System.out.println("Partie fini !" + gameStatus);
		return true;
	}
	
	public Gamer getFirstGamer()
	{
		return this.gamers[0];
	}
	
	public Gamer getSecondGamer()
	{
		return this.gamers[1];
	}

	public ArrayList<Coordinates> getShipsCoordinatesGamer1() {
		return shipsCoordinatesGamer1;
	}

	public void setShipsCoordinatesGamer1(ArrayList<Coordinates> shipsCoordinatesGamer1) {
		this.shipsCoordinatesGamer1 = shipsCoordinatesGamer1;
	}

	public static ArrayList<Coordinates> getShipsCoordinatesGamer2() {
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
	
	
}
