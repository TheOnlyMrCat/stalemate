package com.dockdev.farming.menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.dockdev.farming.Game;

public class MainMenu {
	
	private Game game;
	
	public MainMenu(Game game) {
		this.game = game;
	}
	public void tick() {

	}

	public void render(Graphics g) {
		Font fnt = new Font("arial", 1, 50);
		Font bntFnt = new Font("arial", 1, 20);
		
		g.setFont(fnt);
		g.setColor(Color.WHITE);
		g.drawString("Farm Sim", 200, 50);
		
		g.setFont(bntFnt);
		g.drawString("Play", 285, 190);
		g.drawString("Options", 272, 190 + 100);
		g.drawString("Exit", 290, 390);

		g.drawRect(210, 150, 200, 64);
		
		g.setColor(Color.WHITE);
		g.drawRect(210, 250, 200, 64);
		
		g.setColor(Color.WHITE);
		g.drawRect(210, 350, 200, 64);

	}
}
