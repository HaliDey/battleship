package com.battleship.model;


/**
 * @author 
 * Maamma Halima
 * Seurin Audrey
 * Zerrouq Noha
 * Sayadi Atef
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
	
	public Coordinates(){
		this.x = 0;
		this.y = 0;

	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Coordinates [x=" + x + ", y=" + y + "]";
	}

}
