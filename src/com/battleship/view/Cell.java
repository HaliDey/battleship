package com.battleship.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import com.battleship.controller.GridListener;

public class Cell  extends JPanel{
	private static final long serialVersionUID = 6514348540018007371L;
	private Color defaultBackground;
	private GridListener listener;
	

	private int cellX;
	private int cellY;

    public Cell() {
    	listener = new GridListener (this);
    	this.addMouseListener(listener);    	
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
    
}