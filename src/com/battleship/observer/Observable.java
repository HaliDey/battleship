package com.battleship.observer;

import com.battleship.view.Grid;

public interface Observable {
	  public void addObserver(Grid grid);
	  public void removeObserver();
	  public void notifyObserver(Grid grid);
}