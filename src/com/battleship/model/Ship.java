package com.battleship.model;

import com.battleship.model.Coordinates;

/**
 * @author 
 * Maamma Halima
 * Seurin Audrey
 * Zerrouq Noha
 * Sayadi Atef
 */

public class Ship {
	
	private int numbercell;
	private String shipname;
	private int damage;
	private Coordinates coordinates;
	private String orientation;
	
	public Ship(String shipname, Coordinates c, String orientation, int numbercell)
	{
		this.numbercell = numbercell;
		this.shipname = shipname;
		this.damage = 0;
		this.setCoordinates(c);
		this.orientation = orientation;
	}
		 
	/**
	 * Renvoie les dgts du bateau c'est dire le nombre de compartiments dtruits.
	 * @return Renvoie les dgts du bateau.
	 */
	public int getDamage()
	{
		return this.damage;
	}
	
	
	public void incDamage()
	{
		if (!this.estCoule())
		{
			this.damage++;
		}
		System.out.println("[Ship Model | incDamage]" + this.toString());
	}
	
	
	@Override
	public String toString() {
		return "Ship [numbercell=" + numbercell + ", shipname=" + shipname
				+ ", damage=" + damage + ", coordinates=" + coordinates
				+ ", orientation=" + orientation + ", estCouler=" + this.estCoule() + "]";
	}

	public boolean estCoule()
	{
		return this.damage == this.numbercell ? true : false;
	}
	
	
	public String getName()
	{
		return this.shipname;
	}
	
	/**
	 * Renvoi l'orientation du bateau : vrai si horizontale, sinon verticale.
.
	 */
	public String getOrientation()
	{
		return this.orientation;
	}
	
	public void setOrientation(String orientation)
	{
		this.orientation = orientation;
	}
	
	public int getNumbercell() {
		return numbercell;
	}

	 
	public String getShipname() {
		return shipname;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

}
