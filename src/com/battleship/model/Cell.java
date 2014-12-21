package com.battleship.model;

import com.battleship.model.Ship;

public class Cell {
	//ship which one of one of its parts are situated on the cell
	private Ship ship;
	// if the cell is touched
	private boolean isTouched;
	
	public Cell()
	{
		this.ship = null;
	}
	
	// Create a cell which a ship is on it
	public Cell(Ship ship)
	{
		if (ship == null)
			throw new NullPointerException();
		
		this.ship = ship;
	}
	
	//to make sure if a ship is on a cell or not 
	public boolean isEmpty()
	{
		return ship == null ? true : false;
	}

	//return true is a ship is tuched on the cell situated in
	public boolean isTouched()
	{
		return this.isTouched;
	}
	
	// return null if the ship is already touched/ the ship in the cell/ null if the cell is empty
	public Ship touched()
	{
		
	    if (this.ship != null && this.isTouched == false)
	    {
	        //this.ship.increaseTarget();
	        this.isTouched = true;	
	         return this.ship;
	    }	
	    else if(this.isTouched == false)
	    {
	        this.isTouched = true;
	    }
	    return null;
	}
	
	
	public Ship getShip()
	{
		return this.ship;
	}
        
    public void removeBateauShip()
    {
       ship = null;
    }

	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

}



