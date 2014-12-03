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
 
	static Coordinates coordinates;
	private int target; // the target( darar(cible))
 
// declaration de l'enumeration
	enum status {
		horizontal,
		verticale
	};
	
	public Ship(Coordinates c){ 
		this.coordinates=c;
	}

	
	public void increaseTarget(){
		this.target++;
	}
	
	//initialisation à 0 dans joueur
}
