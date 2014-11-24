package com.battleship.controller;

import com.battleship.model.Coordinates;
import com.battleship.model.AbstractModel;

public abstract class AbstractController {

	
	protected AbstractModel ship;
	protected Coordinates coordinates = new Coordinates(0,0); /*Initialization coordonnÃ©es Ã  0*/
	


	public AbstractController(AbstractModel ship){
		this.ship=ship;
	}

	//Efface (methode aussi dans AbstractModel)
	  public void reset(){
	     this.ship.reset();
	  }
	  
	//Méthode de contrôle
	  abstract void control();
	}


/* invoquer control(); dans chaque action cï¿½d chaq mï¿½thode dï¿½finie 
  Celle-ci va vï¿½rifier les donnï¿½es et informer le modï¿½le en consï¿½quence
*/

