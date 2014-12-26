package com.battleship.model;

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

	private Ship ships[];
	private String name;
	private int goal;
	private int nb_stockes;    /*number of stockes(nombre de coups(attaques)*/
	private Grid grid;

	public Gamer(Grid grid2, Ship ships[]){
		this.setGrid(grid2);
		this.setShips(ships);
		
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid2) {
		this.grid = grid2;
	}

	public Ship[] getShips() {
		return ships;
	}

	public void setShips(Ship ships[]) {
		this.ships = ships;
	}




}
