package com.battleship.core;

import com.battleship.controller.*;
import com.battleship.model.*;
import com.battleship.view.*;

public class Main {
	
	public static void main(String[] args) {
		Model mod = new Model();  
		
		
		Window win = new Window();
		
		mod.addObserver(win);

	}

}
