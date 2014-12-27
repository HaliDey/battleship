package com.battleship.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import com.battleship.model.Coordinates;
import com.battleship.model.GameModel;
import com.battleship.view.Cell;


public class GridListener implements MouseListener{

	private Cell cell;
	private ArrayList<Coordinates> shipsCoordinates;
	
	public GridListener(Cell cell, ArrayList<Coordinates> shipsCoordinates){
		this.cell = cell;
		this.shipsCoordinates = shipsCoordinates;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if ("Demo mode" != GameModel.getGameMode() && this.cell.getGridSide() == GameModel.getCurrentGamer())
		{
			if (Color.RED != this.cell.getDefaultBackground()){
				this.cell.setBackground(Color.BLUE);
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if ("Demo mode" != GameModel.getGameMode() && this.cell.getGridSide() == GameModel.getCurrentGamer())
		{
			this.cell.setBackground(this.cell.getDefaultBackground());
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Cell side : " + this.cell.getGridSide() + " Current Gamer :: " + GameModel.getCurrentGamer());
		if (this.cell.getGridSide() == GameModel.getCurrentGamer())
		{
			if (null != this.cell.getDefaultBackground())
			{
				if (this.cell.getDefaultBackground().equals(Color.DARK_GRAY))
				{
					System.out.println("Case déja frapper");
				} else {
					if ( ShipController.isTouched(cell.getCellX(), cell.getCellY()) )
					{
						this.cell.setBackground(Color.RED);
						this.cell.setDefaultBackground(Color.RED);
					} 
				}
			} else {
				if (1 == GameModel.getCurrentGamer()  ){
					GameModel.setCurrentGamer(2);
				} else {
					GameModel.setCurrentGamer(1);
				}
				this.cell.setBackground(Color.DARK_GRAY);
				this.cell.setDefaultBackground(Color.DARK_GRAY);
				System.out.println("raateer [GridListener]");
			}
		} else {
			System.out.println("C'est pas ton tour [GridListener]");
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public ArrayList<Coordinates> getShipsCoordinates() {
		return shipsCoordinates;
	}


	public void setShipsCoordinates(ArrayList<Coordinates> shipsCoordinates) {
		this.shipsCoordinates = shipsCoordinates;
	}

}
