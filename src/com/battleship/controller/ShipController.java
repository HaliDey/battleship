package com.battleship.controller;


import java.util.Vector;

import com.battleship.model.GameModel;
import com.battleship.model.Ship;
import com.battleship.view.GridWindow;

//Declaration de la classe ShipController

public class ShipController{
	
//Declaration des attributs
	
	private static Vector<Ship> gamer1Ships, gamer2Ships;
	private static GameModel game; 
	
//Declaration du constructeur
	
	public ShipController(GameModel game, Vector<Ship> gamer1Ships, Vector<Ship> gamer2Ships){
		
		ShipController.gamer1Ships = gamer1Ships;
		ShipController.gamer2Ships = gamer2Ships;
		ShipController.game = game;
	}
//Declaration de la methode static boolean isTouched()
	
	public static boolean isTouched(int x, int y){
		
		String currentPlayer;
		
		Vector<Ship> ships = null;
		
		if (1 == GameModel.getCurrentGamer()){
			
			//Premier joueur (Grille de Gauche)
			
			ships = ShipController.gamer1Ships;
			currentPlayer = "Joueur 1";//joueur actuelle le joueur 1
			GameModel.setCurrentGamer(2);
			
		} else {
			
			//Deuxi�me joueur (Grille de Droite)
			
			ships = ShipController.gamer2Ships;
			currentPlayer = "Joueur 2";//joueur actuelle le joueur 2
			GameModel.setCurrentGamer(1);
		}
		
		for (Ship tmp : ships) //tmp est un objet bateau
		{
			if ("H" == tmp.getOrientation()){  // parcourir horizontalement pour voir le bateau toucher
				
// on parcours le bateau en commen�ant de la premiere coordonn�e Y jusqu'� la fin du bateau (en fonction de la taille du bateau)
				
				for (int i=tmp.getCoordinates().getY(); i<=tmp.getCoordinates().getY()+tmp.getNumbercell(); i++) 
				{
					if ((x == tmp.getCoordinates().getX()) && (y == i)) // voir si le bateau est touch� 
					{
						tmp.incDamage(); // incrementer le nombre de degat 
						
						if (currentPlayer.equals("Joueur 1")) 
						{
							// on affiche du cot� joueur 1 
							GridWindow.txtAreaG1.append("[Toucher] Coordonn�es : X: " + tmp.getCoordinates().getX() + " Y: " + i + " Horizontale | Navire : " 
														+ tmp.getName()
														+ " - Etat : " + tmp.shipStatus() + "\n"); 
						} else {
							// on affiche du cot� joueur 2
							GridWindow.txtAreaG2.append("[Toucher] Coordonn�es : X: " + tmp.getCoordinates().getX() + " Y: " + i + " Horizontale | Navire : " 
									+ tmp.getName()
									+ " - Etat : " + tmp.shipStatus() + "\n");
						}
						
						ShipController.game.checkShips(ships); // voir si le bateau est coul�
						return true;
					}
				}
				
			} else { // on parcours Verticalement 
			
				if ("V" == tmp.getOrientation()){
					
// on parcours le bateau en commen�ant de la prenmiere coordonnee Y jusqu'� la fin du bateau (en fonction de la taille du bateau)
				
				for (int i=tmp.getCoordinates().getX(); i<tmp.getCoordinates().getX()+tmp.getNumbercell(); i++){
					
					if ((x == i) && (y == tmp.getCoordinates().getY()))
					{
						tmp.incDamage(); // incremente le nombre de degat 
						
						// on affiche du cot� joueur 1
						if (currentPlayer.equals("Joueur 1"))
						{
							GridWindow.txtAreaG1.append("[Toucher] Coordonn�es : X: " + tmp.getCoordinates().getX() + " Y: " + i + " Verticale | Navire : " 
														+ tmp.getName()
														+ " - Etat : " + tmp.shipStatus() + "\n");
						} else {
							// on affiche du cot� joueur 2
							GridWindow.txtAreaG2.append("[Toucher] Coordonn�es : X: " + tmp.getCoordinates().getX() + " Y: " + i + " Verticale | Navire : " 
									+ tmp.getName()
									+ " - Etat : " + tmp.shipStatus() + "\n");
						}

						ShipController.game.checkShips(ships); // voir si le bateau est coul�
						return true;
					}
				}
			}
		}
	}
		return false;
	}
		
// Declaration des getters
	public Vector<Ship> getGamer1Ships() {
		return ShipController.gamer1Ships;
	}
// Declaration des seters
	public void setGamer1Ships(Vector<Ship> gamer1Ships) {
		ShipController.gamer1Ships = gamer1Ships;
	}
	
	
}


