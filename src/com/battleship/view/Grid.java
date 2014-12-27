package com.battleship.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import com.battleship.model.Coordinates;
import com.battleship.model.GameModel;

public class Grid extends JPanel{	
	private static final long serialVersionUID = 5451380659929409310L;
	public Cell tab[][];
	private ArrayList<Coordinates> shipsCoordinates;
	private int side;

	public Grid (ArrayList<Coordinates> shipsCoordinates, int side){
		this.setLayout(new GridLayout(10, 10));
		this.tab = new Cell[10][10];
		this.side = side;
        this.initGrid();
        this.shipsCoordinates = shipsCoordinates;
	}
	
	public void initGrid(){
		for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
            	
                Cell cellPane = new Cell(this.shipsCoordinates, this.side);
                
                cellPane.setCellX(row);
                cellPane.setCellY(col);
                
                Border border = null;
                if (row < 9) {
                    if (col < 9) {
                        border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
                    }
                } else {
                    if (col < 9) {
                        border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                    }
                }
                cellPane.setBorder(border);
                
                try{
                	this.tab[row][col] = cellPane;
                } catch(Exception e){
                	System.err.println("Erreur !! row : "+row+" col : "+col);
                }
                
                this.add(cellPane);
            }
            
        }
	}

	public ArrayList<Coordinates> getShipsCoordinates() {
		return shipsCoordinates;
	}

	public void setShipsCoordinates(ArrayList<Coordinates> shipsCoordinates) {
		this.shipsCoordinates = shipsCoordinates;
	}
	
	public int getSide() {
		return side;
	}
	
}
