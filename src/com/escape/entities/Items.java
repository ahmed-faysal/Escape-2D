package com.escape.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.escape.Game;

public class Items {

	private Game game;
	private int x, y;
	private BufferedImage img;
	public Rectangle bound;
	public static ArrayList<Items> items = new ArrayList<Items> ();
	public static Items[] it ;
	
	public Items(Game game ,int x, int y, BufferedImage img){
		this.game = game;
		this.x = x;
		this.y = y;
		this.img = img;
		
		initBounds();
		addItem(this);
	}
	
	public void initBounds(){
		bound = new Rectangle((int)(x - game.getViewPort().xOffset + 15), (int) (y - game.getViewPort().yOffset + 15), 20, 20);
	}
	
	public void addItem(Items i){
		items.add(i);
	}
	
	public void tick(){
		initBounds();
	}
	
	public void render(Graphics g){
		g.drawImage(img, (int) (x - game.getViewPort().xOffset + 15), (int) (y - game.getViewPort().yOffset + 15), 20, 20, null);
	}
	
}