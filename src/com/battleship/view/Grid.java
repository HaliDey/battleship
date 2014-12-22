package com.battleship.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class Grid extends JPanel{	
	private static final long serialVersionUID = 5451380659929409310L;
	private GridBagConstraints gbc;
	
	public Grid (){
		setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();
        
        this.initGrid();
	}
	
	public void initGrid(){
		for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                gbc.gridx = col;
                gbc.gridy = row;

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
                add(cellPane, gbc);
                
            }
        }
	}

	public GridBagConstraints getGbc() {
		return gbc;
	}
	
}
