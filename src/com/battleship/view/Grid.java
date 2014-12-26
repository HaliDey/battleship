package com.battleship.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class Grid extends JPanel{	
	private static final long serialVersionUID = 5451380659929409310L;
	public Cell tab[][];
	
	public Grid (){
		this.setLayout(new GridLayout(10, 10));
		this.tab = new Cell[10][10];
        this.initGrid();
	}
	
	public void initGrid(){
		for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
            	
                Cell cellPane = new Cell();
                
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
	
}
