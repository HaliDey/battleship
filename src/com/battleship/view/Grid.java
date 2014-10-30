package com.battleship.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import com.battleship.model.GridListener;

public class Grid extends JPanel{	
	
	
	
	public Grid (){
		setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
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
	
	
	//class Cell

}
