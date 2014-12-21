package com.battleship.model;

import com.battleship.model.Coordinates;


//les imports

/**
 * @author 
 * Maamma Halima
 * Seurin Audrey
 * Zerrouq Noha
 * Sayadi Atef
 * 
 */
public abstract class Ship {
 
	private Coordinates coordinates;
	private String orientation;
	private int weight; // the target( darar(cible))
	
	public Ship(Coordinates c, String orientation, int weight){ 
		this.coordinates = c;
		this.orientation = orientation;
		this.weight = weight;
	}
	

}
