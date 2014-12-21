package com.battleship.model;

public class Game {
	
	private Gamer gamers[]= new Gamer[2];
	private  int gameron=1;
	
 public Game(){
	 gamers[0]= new Gamer();
	 gamers[1]= new IA();
 }

}
