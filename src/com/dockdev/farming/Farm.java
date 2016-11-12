package com.dockdev.farming;

import java.awt.Canvas;

public class Farm extends Canvas implements Runnable {

	public static final long serialVersionUID = 23479874098374918L;

	private Thread thread;
	private boolean running = false;

	public enum State {
		Game, Menu, Paused
	}

	public enum Land {
		//Be more creative
		//Translate to 1 2 3 and 4 when using getCost()
		Small, Medium, Large, Mansion
	}

	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 100.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void render() {
		// TODO Auto-generated method stub

	}

	private void tick() {
		// TODO Auto-generated method stub

	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
		System.out.println("Started");
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
			System.out.println("Stopping");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
