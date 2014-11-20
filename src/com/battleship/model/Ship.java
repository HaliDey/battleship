package com.battleship.model;


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
 
// declaration de l'enumeration
	enum status {
		horizontal,
		verticale
	};
	
	public Ship(Coordinates c){ 
		this.coordinates=c;
	}

	
	//initialisation à 0 dans joueur
}
