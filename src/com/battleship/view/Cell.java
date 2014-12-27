package com.battleship.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.battleship.controller.GridListener;
import com.battleship.model.Coordinates;
import com.battleship.model.GameModel;

public class Cell  extends JPanel{
	
	private static final long serialVersionUID = 6514348540018007371L;
	private Color defaultBackground;
	private GridListener listener;
	private int cellX;
	private int cellY;
	private int gridSide;

    public Cell(ArrayList<Coordinates> shipsCoordinates, int gridSide) {
    	listener = new GridListener (this, shipsCoordinates);
    	this.addMouseListener(listener);    	
    	this.gridSide = gridSide;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(30, 30);
    }

	public int getCellX() {
		return cellX;
	}

	public void setCellX(int cellX) {
		this.cellX = cellX;
	}

	public int getCellY() {
		return cellY;
	}

	public void setCellY(int cellY) {
		this.cellY = cellY;
	}
    
	
	public GridListener getListener() {
		return listener;
	}

	public void setListener(GridListener listener) {
		this.listener = listener;
	}

	public Color getDefaultBackground() {
		return defaultBackground;
	}

	public void setDefaultBackground(Color defaultBackground) {
		this.defaultBackground = defaultBackground;
	}

	public int getGridSide() {
		return gridSide;
	}

}