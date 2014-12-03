package com.battleship.model;

import com.battleship.view.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonsActionListener implements ActionListener{
	private Window mView;

	public ButtonsActionListener (Window window){
		this.mView = window;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()){
			case "Switch Card":
				mView.getCards().next( mView.getCardsPanel() );
			break;
		}
	}
}
 
