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
//Declaration de la classe Gamer

public class Gamer {
	
//Declaration des attributs
	
	private Vector<Ship> ships;//Declaration d'un Vector <Ship> dont l'objet extensible est ici nommes ships qui selectionne tous les bateaux
	private String name;
	private int goal;
	private int nb_stockes; //nombre de stockes (Nombre de coups (Attaques)
	private Grid grid;
	
//Declaration du constructeur de la classe Gamer
	
	public Gamer(Grid grid, Vector<Ship> ships){
	
		this.setGrid(grid);
		this.setShips(ships);
	}
	
//Declaration de la methode shoot()
	
	public void shoot(){
		
		System.out.println("[GamerModel | shoot]");//afficher le joueur et ces tirs
		
	}
	
//Declaration des getters
	
	public Grid getGrid() {
		return grid;
	}	
	public Vector<Ship> getShips() {
		return ships;
	}
	
//Declaration des setters
	
	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	public void setShips(Vector<Ship> ships) {
		this.ships = ships;
	}

}