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
		
		System.out.print("btn clicked " + e.getActionCommand() );
	}
	
}

/*
public class SomeActionListener {

    private JTextField textField1;
    private JComboBox combo1;
    private JTextField textField2;
    //...

    public SomeActionListener(JTextField textField1, JComboBox combo1, 
                                          JTextField textField2){
        this.textField1=textField1;
        this.combo1=combo1;
        this.textField2=textField2;
        //...
    }

    public void actionPerformed(ActionEvent e) {
        //cmd
    }

}
*/