package com.battleship.view;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Pan {
	public void paintComponent(Graphics g){
		
	   
	    try {
	        Image img = ImageIO.read(new File("java.jpg"));
	        g.drawImage(img, 0, 0, (ImageObserver) this);
	        //Pour une image de fond
	        //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	      } catch (IOException e) {
	        e.printStackTrace();
	      }       
	    
	    
	  
}
}

