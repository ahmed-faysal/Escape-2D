package com.escape;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import com.escape.assets.Assets;
import com.escape.graphics.Display;
import com.escape.graphics.Splash;
import com.escape.managers.KeyManager;
import com.escape.managers.MouseManager;
import com.escape.states.GameState;
import com.escape.states.MenuState;
import com.escape.states.SettingsState;
import com.escape.states.State;
import com.escape.utils.ViewPort;

public class Game implements Runnable{

	private String title;
	private int width, height;
	private boolean running = false;
	
	private Display display;
	private Thread thread;
	private Graphics g;
	private BufferStrategy bs;
	
	private KeyManager km;
	private MouseManager mm;
	
	private ViewPort vp;
	
	public State gamestate, menustate, settingstate;
	
	public Game(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
	}
	
	private void init(){
		display = new Display(title, width, height);
		Assets.init();
		
		km = new KeyManager();
		display.getCanvas().addKeyListener(km);
		
		mm = new MouseManager();
		display.getCanvas().addMouseListener(mm);
		display.getCanvas().addMouseMotionListener(mm);
		
		vp = new ViewPort(this, 0, 0);
		
		gamestate = new GameState(this);
		settingstate = new SettingsState(this);
		menustate = new MenuState(this);
		State.setState(menustate);
	}
		
	@Override
	public void run() {
		init();
		
		try {
			Splash.initSplash();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int fps = 70;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long currentTime = 0;
		long lastTime = System.nanoTime();
		int ticks = 0;
		long timer = 0;
		
		while(running){
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime)/timePerTick;
			timer += currentTime - lastTime;
			lastTime = currentTime;
			
			if(delta > 1){
				tick();
				render(g);
				ticks++;
				delta--;
			}
			
			if(timer > 1000000000){
				System.out.println("FPS: " +ticks);
				timer = 0;
				ticks = 0;
			}
			
		}
		
		stop();
	}
	
	public void tick(){
		if(State.getState() != null){
			State.getState().tick();
		}
	}
	
	public void render(Graphics g){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		if(State.getState() != null){
			State.getState().render(g);
		}
		
//		g.drawImage(Assets.story[0],0, 0, null);
		
		bs.show();
		g.dispose();
	}

	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public KeyManager getKeyManager() {
		return km;
	}
	
	public MouseManager getMouseManager(){
		return mm;
	}

	public ViewPort getViewPort() {
		return vp;
	}
	
}
