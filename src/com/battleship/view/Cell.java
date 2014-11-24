package com.battleship.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.battleship.model.GridListener;

public class Cell  extends JPanel{
	public Color defaultBackground;
	private GridListener listener;
	private int cellX;
	private int cellY;

    public Cell() {
    	listener = new GridListener (this);
    	this.addMouseListener(listener);    	
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(40, 40);
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
    
    
}