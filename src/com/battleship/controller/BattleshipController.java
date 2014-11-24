package com.battleship.controller;
import com.battleship.model.AbstractModel;
import com.battleship.model.Coordinates;
import com.battleship.model.Ship;

public abstract class BattleshipController extends AbstractController{
	
	
/*public BattleshipController(){

	protected AbstractModel ship;
	protected Coordinates coordinates = new Coordinates(0,0); /*Initialization coordonnees a 0*/

	public void AbstractController(AbstractModel ship){
		this.ship=ship;
	}

	//Efface (methode aussi dans AbstractModel)
	  public void reset(){
	     this.ship.reset();
	  }
	  
	//Méthode de contrôle
	  abstract void control1();
		
	public BattleshipController(AbstractModel ship) {
		super(ship);
		// TODO Auto-generated constructor stub
	}

	public void control(){
	/* définir la méthode controle déclarée dans AbstractControler  */
	}
}
//


