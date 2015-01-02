package com.battleship.model;


import java.util.Vector;

import com.battleship.view.Grid;
import com.battleship.model.Ship;

/**
 * @author 
 * Sayadi Atef
 * Maamma Halima
 * Seurin Audrey
 * Zerrouq Noha
 */
public class Gamer {

	private Vector<Ship> ships;
	private String name;
	private int goal;
	private int nb_stockes;    /*number of stockes(nombre de coups(attaques)*/
	private Grid grid;

	public Gamer(Grid grid, Vector<Ship> ships){
		this.setGrid(grid);
		this.setShips(ships);
	}

	public void shoot(){
		System.out.println("[GamerModel | shoot]");
		
	}
	
	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public Vector<Ship> getShips() {
		return ships;
	}

	public void setShips(Vector<Ship> ships) {
		this.ships = ships;
	}

}
