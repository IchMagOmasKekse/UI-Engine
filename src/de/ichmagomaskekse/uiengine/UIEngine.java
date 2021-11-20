package de.ichmagomaskekse.uiengine;
import de.ichmagomaskekse.uiengine.graphics.ui.sampleapp.SampleAppUi1;

import java.awt.*;
import java.awt.image.BufferStrategy;

@SuppressWarnings("serial")
public class UIEngine extends Canvas implements Runnable {
	
	/* Window */
	public static int windowWidth = 1200;
	public static int windowHeight = 900;
	
	private boolean isRunning = false;
	private Thread thread;
	private Camera camera;
	private TextureAtlas textureAtlas;
	public static final int blocksize = 32;

	public static SampleAppUi1 app = null;
	static UIEngine instance;
	public static UIEngine getInstance() {
		return instance;
	}
	
	public static void main(String[] args) {
		new UIEngine();
	}
	
	public UIEngine() {
		instance = this;
		setBackground(Color.BLACK);
		new Window(windowWidth, windowHeight, "UI-Engine", this);
		app = new SampleAppUi1();
		start();
		
		camera = new Camera(0,0);
		textureAtlas = new TextureAtlas();
		this.addKeyListener(new KeyInput());
		this.addMouseListener(new MouseInput());

	}
	
	private void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	private void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	
	@SuppressWarnings("unused")
	@Override
	public void run() {
		/*
		 * GameLoop - Made by Notch
		 */
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				//update++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
			}
		}
		stop();
	}
	
	public void tick() {
		//TODO: TICK
		app.tick();
	}
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, windowWidth, windowHeight);
		g2d.translate(-camera.getX(), -camera.getY());
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
		//TODO: RENDER
		app.render(g2d);
		
		g2d.translate(camera.getX(), camera.getY());
		
		g.dispose();
		bs.show();
	}
	
	public TextureAtlas getTextureAtlas() {
		return textureAtlas;
	}
	
	public Camera getCamera() {
		return camera;
	}
	
}
