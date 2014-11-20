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
public class Coordinates {

//declaration des attributs
	private int x;
	private int y;
	
//declaration du constructeur
	public Coordinates(int x, int y){
		this.x=x;
		this.y=y;

	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
