package com.battleship.model;

import java.util.ArrayList;
import com.battleship.observer.Observable;
import com.battleship.observer.Observer;

public abstract class AbstractModel implements Observable{	
  
	//Implémentation du pattern observer
	public void addObserver(Observer obs) {
		
	}
	
	public void notifyObserver(String str) {
		
	}
	
	public void removeObserver() {
		
	}

}