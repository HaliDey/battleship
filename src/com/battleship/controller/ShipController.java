package com.battleship.controller;


import com.battleship.model.GameModel;
import com.battleship.model.Ship;


public class ShipController{
	
	private static Ship[] gamer1Ships, gamer2Ships;
	private static GameModel game; 
	
	public ShipController(GameModel game, Ship[] gamer1Ships, Ship[] gamer2Ships){
		ShipController.gamer1Ships = gamer1Ships;
		ShipController.gamer2Ships = gamer2Ships;
		ShipController.game = game;
	}

	public static boolean isTouched(int x, int y){
		String tour;
		
		Ship[] ships = null;
		
		if (1 == GameModel.getCurrentGamer()  ){
			//Premier joueur (Grille de Gauche)
			ships = ShipController.gamer1Ships;
			tour = "Joueur 2";
			GameModel.setCurrentGamer(2);
		} else {
			//Deuxi�me joueur (Grille de Droite)
			ships = ShipController.gamer2Ships;
			tour = "Joueur 1";
			GameModel.setCurrentGamer(1);
		}
		
		for (Ship tmp : ships)
		{
			if ("H" == tmp.getOrientation()){
				for (int i=tmp.getCoordinates().getY(); i<tmp.getCoordinates().getY()+tmp.getNumbercell(); i++)
				{
					if ((x == tmp.getCoordinates().getX()) && (y == i))
					{
						tmp.incDamage();
						System.out.println("[ShipController | isTouched] H, true, " + tour);
						
						ShipController.game.checkShips(ships);
						
						return true;
					}
				}
				
			} else {
				for (int i=tmp.getCoordinates().getX(); i<tmp.getCoordinates().getX()+tmp.getNumbercell(); i++){
					if ((x == i) && (y == tmp.getCoordinates().getY()))
					{
						tmp.incDamage();
						System.out.println("[ShipController | isTouched] V, true, " + tour);

						ShipController.game.checkShips(ships);
						
						return true;
					}
				}
			}
		}
		System.out.println("[ShipController | isTouched] false, " + tour);
		return false;
	}
		
	
	public Ship[] getGamer1Ships() {
		return ShipController.gamer1Ships;
	}

	public void setGamer1Ships(Ship[] gamer1Ships) {
		ShipController.gamer1Ships = gamer1Ships;
	}
	
	
}


