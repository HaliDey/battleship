package com.battleship.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import com.battleship.model.Coordinates;

//Declaration de la classe Grid qui herite de la classe JPanel (conteneur léger générique)

public class Grid extends JPanel{	
	private static final long serialVersionUID = 5451380659929409310L;
	public Cell tab[][]; //declaration d'un tableau a deux dimensions
	private ArrayList<Coordinates> shipsCoordinates;
	private int side;//declaration du cote
	
//Declaration du constructeur de la grille
	
	public Grid (ArrayList <Coordinates> shipsCoordinates, int side){

		this.setLayout(new GridLayout(10, 10)); // Définit le gestionnaire de présentation de ce conteneur. Cette méthode modifie les informations relatives schéma,
		this.tab = new Cell[10][10]; //dimmension du tableau
		this.side = side; //declaration des cotes
        this.initGrid(); // appel de la methode pour dessiner la grille
        this.shipsCoordinates = shipsCoordinates;
	}
	
// Methode pour dessiner la grille
	
	public void initGrid(){
		
	//Boucle For qui parcours en ligne la grille
		
		for (int row = 0; row < 10; row++) {
			
			//Boucle For qui parcours en colonne la grille
			
            for (int col = 0; col < 10; col++) {
            	
                Cell cellPane = new Cell(this.shipsCoordinates, this.side);
                
                cellPane.setCellX(row);//affiche la ligne
                cellPane.setCellY(col);//affiche le colonne
                Border border = null;
                
//Parcours si la colonne est inferieur de la grille est inférieur à 9 cases 
                
                if (row < 9) {

//Parcours si la colonne est inferieur de la grille est inférieur à 9 cases 
                	
                    if (col < 9) {
                    	
//Creation de la bordure mate avec les encarts et la couleur secifique ici gris.
                    
                        border = new MatteBorder(1, 1, 0, 0, Color.GRAY); //MatteBorder(int top, int left, int bottom,int right,Color matteColor)
                      
                    } else {
                        border = new MatteBorder(1, 1, 0, 1, Color.GRAY); //MatteBorder(int top, int left, int bottom,int right,Color matteColor)
                    }
                } else {

//Parcours si la colonne est inferieur de la grille est inférieur à 9 cases 
                    if (col < 9) {
                    	
                        border = new MatteBorder(1, 1, 1, 0, Color.GRAY); //MatteBorder(int top, int left, int bottom,int right,Color matteColor)
                    } else {
                        border = new MatteBorder(1, 1, 1, 1, Color.GRAY); //MatteBorder(int top, int left, int bottom,int right,Color matteColor)
                    }
                }
                cellPane.setBorder(border);//renvoie la bordure
//Declaration du try {...} catch {...} qui gere les exceptions
                try{
                	
                	this.tab[row][col] = cellPane;
                	
                } catch(Exception e){
                	
                	System.err.println("Erreur !! row : "+row+" col : "+col);//affiche l'erreur su la ligne(row) et la collonne (col)
                }
                
                this.add(cellPane);
            }
            
        }
	}
//Declaration des getters
	public ArrayList<Coordinates> getShipsCoordinates() {
		return shipsCoordinates;
	}
	public int getSide() {
		return side;
	}
//Declaration des setters
	public void setShipsCoordinates(ArrayList<Coordinates> shipsCoordinates) {
		this.shipsCoordinates = shipsCoordinates;
	}
	
	
	
}