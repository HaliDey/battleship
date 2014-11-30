package com.battleship.model;

public class Grid {

	
	
	Cell[] monitoredgrid;
	
	
	
	
	public Cell[] getGrid()
	{
		return this.monitoredgrid.clone();
	}
}
