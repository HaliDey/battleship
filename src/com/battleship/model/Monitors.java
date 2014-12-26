package com.battleship.model;


public class Monitors {
	
	
		
		private Grid monitoredgrid;
		
		// a monitor which will dog the other grid and trow an exeption if the other grid doesn't exist( construit un surveilleur de
		//près de la grille de l'autre joueur sinn lance une exeption dans le cas où la grille n'existe pas selon le mode de jeu
		
		public Monitors(Grid monitoredgrid) throws NullPointerException
		{
			if (monitoredgrid == null)
			{
				throw new NullPointerException("the monitor should dog the anonymos grid");
			}
			this.monitoredgrid = monitoredgrid;
		}
		
}
		 
		