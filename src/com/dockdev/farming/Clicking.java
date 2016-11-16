package com.dockdev.farming;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.dockdev.farming.Game.State;

public class Clicking extends MouseAdapter {
	private Game game;

	public Clicking(Game game) {
		this.game = game;
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		if (mouseOver(mx, my, 210, 150, 200, 64)) {
			game.GameState = State.Game;
		}
	}

	public void mouseReleased(MouseEvent e) {

	}

	public boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width) {
			if (my > y && my < y + height) {
				return true;
			}
			return false;
		}
		return false;
	}

}
