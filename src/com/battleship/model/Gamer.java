package com.battleship.model;

import com.battleship.model.Coordinates;
import com.battleship.model.Monitors;
import com.battleship.model.Ship;


//les imports

/**
 * @author 
 * Sayadi Atef
 * Maamma Halima
 * Seurin Audrey
 * Zerrouq Noha
 */
public class Gamer {

	private Ship ship[];
	private String name;
	private int goal;
	private int nb_stockes;    /*number of stockes(nombre de coups(attaques)*/
	protected Grid gd;
	private Monitors adversarygrid;

	public Gamer(Ship s[]){
		this.ship = s;	
	}
	
	public void shoot (Coordinates c){

		//renvoi si c'est toucher ou pas 


	}
	
	 
 


	public Monitors getAdversarygrid() 
	{
		return adversarygrid;
	}


	public void setAdversarygrid(Monitors adversarygrid) 
	{
		this.adversarygrid = adversarygrid;
	}


	//initialise a gamer before the game


	void initialisr(Monitors adversarygrid) throws NullPointerException
	{
		if (adversarygrid == null)
		{
			throw new NullPointerException("the monitor of the gamer " + 
					this.name + " est incorrect"); 
		}
		this.setAdversarygrid(adversarygrid);
		this.nb_stockes = 0;
	}




}
