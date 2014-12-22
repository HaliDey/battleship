package com.battleship.model;

import com.battleship.model.Coordinates;
import com.battleship.model.Monitors;
import com.battleship.model.Ship;
import com.battleship.view.Grid;

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
	private Monitors adversarygrid;

	public Gamer(com.battleship.view.Grid grid2, Ship ships[]){
		this.setGrid(grid2);
		this.setShips(ships);
		
	}

	public Monitors getAdversarygrid() 
	{
		return adversarygrid;
	}


	public void setAdversarygrid(Monitors adversarygrid) 
	{
		this.adversarygrid = adversarygrid;
	}


	//initialise a gamer before the game


	void initialisr(Monitors adversarygrid) throws NullPointerException
	{
		if (adversarygrid == null)
		{
			throw new NullPointerException("the monitor of the gamer " + 
					this.name + " est incorrect"); 
		}
		this.setAdversarygrid(adversarygrid);
		this.nb_stockes = 0;
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
