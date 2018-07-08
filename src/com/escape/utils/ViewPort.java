package com.escape.utils;

import com.escape.Game;
import com.escape.entities.Player;
import com.escape.states.GameState;

public class ViewPort {

	private Game game;
	public float xOffset, yOffset;
	
	public ViewPort(Game game, float xOffset, float yOffset){
		this.game = game;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void setPoint(Player p){
		xOffset = p.getX() - game.getWidth()/2  + p.getWidth()/2;
		yOffset = p.getY() - game.getHeight()/2 + p.getHeight()/2;
		BoundaryCheck();
	}
	
	public void BoundaryCheck(){
		if(xOffset < 0){
			xOffset = 0;
		}else if(xOffset > MapLoader.getWidth() * GameState.TILESIZE - game.getWidth()){
			xOffset = MapLoader.getWidth() * GameState.TILESIZE - game.getWidth();
		}
			
		if(yOffset < 0){
			yOffset = 0;
		}else if(yOffset > MapLoader.getHeight() * GameState.TILESIZE - game.getHeight()){
			yOffset = MapLoader.getHeight() * GameState.TILESIZE - game.getHeight();
		}
	}

	public float getxOffset() {
		return xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}
	
}
