package com.dockdev.farming;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.dockdev.farming.tools.Handler;
import com.dockdev.farming.tools.Window;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 4583230692281133623L;
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	
	private Handler handler = new Handler();
	
	private Thread thread;
	private boolean running = false;
	
	BufferedImage back;
	
	public enum State {
		Game, Menu, Paused, Shop
	}
	
	public enum Shop {
		Warehouse, Animalfeed
	}

	public enum Land {
		//Be more creative
		//Translate to 1 2 3 and 4 when using getCost()
		Small, Medium, Large, Mansion
	}
	
	public Game(){
		
		new Window((int) WIDTH, (int) HEIGHT, "Chatopia Alpha 0.0.0.1", this);
		
		try{
			back = ImageIO.read(getClass().getResourceAsStream("/background.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		for (int i = 0; i < (HEIGHT / 5); i++){
			for (int j = 0; j < (WIDTH / 16); j++){
				g.drawImage(back, (j * 16), (i * 96), null);
			}
		}
		
		g.dispose();
		bs.show();
	}

	private void tick() {
		handler.tick();
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
