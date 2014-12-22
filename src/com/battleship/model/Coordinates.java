package com.battleship.model;

//les imports

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

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean getPosition_coordinates() {
		// TODO Auto-generated method stub
		return false;
	}

	public Object getShip() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
