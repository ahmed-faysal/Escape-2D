package com.escape.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.escape.Game;
import com.escape.assets.Animation;
import com.escape.assets.Assets;
import com.escape.assets.Popup;
import com.escape.managers.KeyManager;
import com.escape.states.GameState;

public class Player {
	
	private Game game;
	public Popup pop;
	private int xPos, yPos, height = 40, width = 35;
	public static int speed = 2;
	private Animation anim;
	public Rectangle pBound;
	
	public Player(Game game, int xPos, int yPos){
		this.game = game;
		this.xPos = xPos;
		this.yPos = yPos;
		
		pBound = new Rectangle((int)(xPos - game.getViewPort().getxOffset() + 8),
				(int)(yPos - game.getViewPort().getyOffset() + 8), width - 16, height - 16);
		
		anim = new Animation(300);
		pop = new Popup();
	}
	
	public void move(){
		if(KeyManager.up){
			anim.Animate(Assets.player_up);	
			int txl = (int) (xPos + 2)/GameState.TILESIZE;
			int txr = (int) (xPos + width - 3)/GameState.TILESIZE;
			int ty = (int) (yPos - 1)/ GameState.TILESIZE;
			if(!collides(txl, ty) &&
					!collides(txr, ty)){
				yPos -= speed;
			}else{
				if(GameState.getTile((txl+txr)/2, ty) != 1){
					checkDoor((txl+txr)/2, ty);
				}
			}
			
		}else if(KeyManager.down){
			anim.Animate(Assets.player_down);
			int txl = (int) (xPos + 2)/GameState.TILESIZE;
			int txr = (int) (xPos + width - 3)/GameState.TILESIZE;
			int ty = (int) (yPos + height + 1)/GameState.TILESIZE;
			if(!collides(txl, ty) &&
					!collides(txr, ty)){
				yPos += speed;
			}else{
				if(GameState.getTile((txl+txr)/2, ty) != 1){
					checkDoor((txl+txr)/2, ty);
				}
			}
			
		}else if(KeyManager.left){
			anim.Animate(Assets.player_left);
			int tx = (int) (xPos)/ GameState.TILESIZE;
			int tyu = (int)(yPos)/GameState.TILESIZE;
			int tyd = (int) (yPos + height -1)/GameState.TILESIZE;
			if(!collides(tx, tyu) && !collides(tx, tyd)){
				xPos -= speed;
			}else{
				if(GameState.getTile(tx, tyu) != 1){
					checkDoor(tx, (tyu+tyd)/2);
				}
			}
		}else if(KeyManager.right){
			anim.Animate(Assets.player_right);
			int tx = (int) (xPos + width - 1)/GameState.TILESIZE;
			int tyu = (int)(yPos)/GameState.TILESIZE;
			int tyd = (int) (yPos + height -1)/GameState.TILESIZE;
			if(!collides(tx, tyu) && !collides(tx, tyd)){
				xPos += speed;
			}else{
				if(GameState.getTile(tx, tyu) != 1){
					checkDoor(tx, (tyu+tyd)/2);
				}
			}
		}
	}
	
	public void tick(){
		game.getViewPort().setPoint(this);

		pBound = new Rectangle((int)(xPos - game.getViewPort().getxOffset() + 8),
				(int)(yPos - game.getViewPort().getyOffset() + 8), width - 16, height - 16);

		move();
		pop.tick();
	}
	
	public void render(Graphics g){
		g.drawImage(getCurrentFrame(), (int)(xPos - game.getViewPort().getxOffset()),
				(int)(yPos - game.getViewPort().getyOffset()), width, height, null);
		
		pop.render(g);
	}
	
	private BufferedImage getCurrentFrame(){
		return anim.getCurrentFrame();
	}
	
	private boolean collides(int x, int y){
		if(Assets.tiles.get(GameState.currentMap[y][x]) == Assets.wall ||
				Assets.tiles.get(GameState.currentMap[y][x]) == Assets.bDoor ||
				Assets.tiles.get(GameState.currentMap[y][x]) == Assets.rdDoor){
			return true;
		}else
			return false;
	}
	
	private void checkDoor(int cx, int cy){
		if(KeyManager.space)
			if(GameState.getTile(cx, cy)== 2 && GameState.k1){
				GameState.setTile(cx, cy, 0);
				pop.think1 = true;
			}else if(GameState.getTile(cx, cy)== 3 && GameState.k2){
				GameState.setTile(cx, cy, 0);
			}else if(GameState.getTile(cx, cy)== 4 && GameState.k3){
				GameState.setTile(cx, cy, 0);
			}else if(GameState.getTile(cx, cy)== 5 && GameState.k4){
				GameState.setTile(cx, cy, 0);
			}else if(GameState.getTile(cx, cy)== 6 && GameState.k5){
				GameState.setTile(cx, cy, 0);
			}else if(GameState.getTile(cx, cy)== 7 && GameState.k6){
				GameState.setTile(cx, cy, 0);
			}else if(GameState.getTile(cx, cy)== 8 && GameState.k7){
				GameState.setTile(cx, cy, 0);
			}else if(GameState.getTile(cx, cy)== 9 && GameState.k8){
				GameState.setTile(cx, cy, 0);
			}else if(GameState.getTile(cx, cy)== 10 && GameState.k9){
				GameState.setTile(cx, cy, 0);
			}else if(GameState.getTile(cx, cy)== 12){
				if(!GameState.k9){
					pop.elocktip = true;
				}else{
					GameState.setTile(cx, cy, 15);
					GameState.reset();
				}
			}else{
				pop.locktip = true;
			}
	}
	
	public int getX(){
		return xPos;
	}

	public int getY() {
		return yPos;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
		
}
