package com.battleship.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import com.battleship.view.Cell;


public class GridListener implements MouseListener{

	private Cell cell;
	
	public GridListener(Cell cell){
		this.cell = cell;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		this.cell.setBackground(Color.BLUE);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.cell.setBackground(this.cell.getDefaultBackground());
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("Mouse Pressed ! : row " + this.cell.getCellX() + " col : " + this.cell.getCellY());
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
