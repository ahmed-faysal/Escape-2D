package com.escape.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.escape.Game;
import com.escape.assets.Assets;
import com.escape.managers.KeyManager;
import com.escape.managers.MouseManager;

public class MenuState extends State{

	private int id;
	private long lastTime, timePassed = 0;
	private boolean story;
	private BufferedImage currentImg;
	private Rectangle play, settings, quit;
	
	public MenuState(Game game) {
		super(game);
		init();
	}

	private void init(){
		play = new Rectangle(380, 280, 150, 40);
		settings = new Rectangle(380, 352, 150, 40);
		quit = new Rectangle(380, 425, 150, 40);
		
		id = 0;
		currentImg = Assets.story[id];
	}
	
	@Override
	public void tick() {
		select();
		if(story){
			showStory();
		}
	}

	@Override
	public void render(Graphics g) {
		if(!story){
			g.drawImage(Assets.menu, 0, 0, game.getWidth(), game.getHeight(), null);

			g.setColor(Color.GRAY);
			g.drawRect(play.x, play.y, play.width, play.height);
			g.drawRect(settings.x, settings.y, settings.width, settings.height);
			g.drawRect(quit.x, quit.y, quit.width, quit.height);
		}else if(story)
			g.drawImage(currentImg, 0, 0, null);
	}
	
	private void select(){
		
		if(MouseManager.mouseX > play.x && MouseManager.mouseX < play.x+play.width &&
				MouseManager.mouseY > play.y && MouseManager.mouseY < play.y+play.height){
			if(MouseManager.leftButton){
				story = true;
				lastTime = System.currentTimeMillis();
				showStory();
			}
		}else if(MouseManager.mouseX > settings.x && MouseManager.mouseX < settings.x+settings.width &&
				MouseManager.mouseY > settings.y && MouseManager.mouseY < settings.y+settings.height){
			if(MouseManager.leftButton)
				State.setState(game.settingstate);
		}else if(MouseManager.mouseX > quit.x && MouseManager.mouseX < quit.x+quit.width &&
				MouseManager.mouseY > quit.y && MouseManager.mouseY < quit.y+quit.height){
			if(MouseManager.leftButton)
				System.exit(0);
		}
	}
	
	private void showStory(){
		
		timePassed += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timePassed > 7000){
			id++;
			timePassed = 0;
			if(id >= Assets.story.length){
				id = 0;
				State.setState(game.gamestate);
				story = false;
			}
			currentImg = Assets.story[id];
		}
		
		if(KeyManager.space){
			State.setState(game.gamestate);
			story = false;
		}
	}
}