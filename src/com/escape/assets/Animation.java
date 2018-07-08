package com.escape.assets;

import java.awt.image.BufferedImage;

public class Animation {

	private int speed, id;
	private long lastTime, timePassed;
	private BufferedImage CurrentImg = null;
	
	public Animation(int speed){
		this.speed = speed;
		id = 0;
		timePassed = 0;
		lastTime = System.currentTimeMillis();
	}
	
	public void Animate(BufferedImage [] img){
		timePassed += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timePassed > speed){
			id++;
			timePassed = 0;
			if(id >= img.length){
				id = 0;
			}
			CurrentImg = img[id];
		}
	}
	
	public BufferedImage getCurrentFrame(){
		if(CurrentImg == null)
			return Assets.player_down[1];
		return CurrentImg;
	}
}
