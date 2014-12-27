package com.battleship.model;

import java.awt.Color;
import java.util.Random;

import com.battleship.controller.ShipController;
import com.battleship.view.Cell;
import com.battleship.view.Grid;

public class IA extends Gamer {
	
	private Grid grid;
	
	public IA(Grid grid, Ship ships[]){
		super(grid, ships);
		this.grid = grid;
	}
	
	public void shoot(){
		Random rand = new Random();
		int x = rand.nextInt(10);
		int y = rand.nextInt(10);
		
		Cell cell = grid.tab[x][y];
		
		
		if (cell.getGridSide() == GameModel.getCurrentGamer())
		{
			if (null != cell.getDefaultBackground())
			{
				if (cell.getDefaultBackground().equals(Color.DARK_GRAY))
				{
					System.out.println("Case déja frapper");
				} else {
					if ( ShipController.isTouched(cell.getCellX(), cell.getCellY()) )
					{
						cell.setBackground(Color.RED);
						cell.setDefaultBackground(Color.RED);
					} 
				}
			} else {
				if (1 == GameModel.getCurrentGamer()  ){
					GameModel.setCurrentGamer(2);
				} else {
					GameModel.setCurrentGamer(1);
				}
				cell.setBackground(Color.DARK_GRAY);
				cell.setDefaultBackground(Color.DARK_GRAY);
				System.out.println("[IA Model | shoot] Rater ");
			}
		} else {
			System.out.println("[IA Model | shoot] C'est pas ton tour");
		}
		
	}

}
