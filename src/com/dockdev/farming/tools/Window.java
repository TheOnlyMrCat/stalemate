package com.dockdev.farming.tools;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.dockdev.farming.Farm;

public class Window extends Canvas{
	
	private static final long serialVersionUID = 4583230692281133623L;

	 public Window(int width, int height, String title, Farm game){
	  JFrame frame = new JFrame(title);
	  
	  frame.setPreferredSize(new Dimension(width, height));
	  frame.setMaximumSize(new Dimension(width, height));
	  frame.setMinimumSize(new Dimension(width, height));
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setResizable(false);
	  frame.setLocationRelativeTo(null);
	  frame.add(game);   
	  frame.setVisible(true);
	  game.start();
	 
	 
	 
	 }
	
	
}
