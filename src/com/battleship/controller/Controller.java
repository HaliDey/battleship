package com.battleship.controller;

import com.battleship.model.Coordinates;
import com.battleship.model.Model;

public abstract class Controller {

	
	protected Model ship;
	protected Coordinates coordinates = new Coordinates(0,0); /*Initialization coordonnÃ©es Ã  0*/
	


	public Controller(Model ship){
		this.ship=ship;
	}

 
	//Méthode de contrôle
	  abstract void control();
	}


/* invoquer control(); dans chaque action cï¿½d chaq mï¿½thode dï¿½finie 
  Celle-ci va vï¿½rifier les donnï¿½es et informer le modï¿½le en consï¿½quence
*/

