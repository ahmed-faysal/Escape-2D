package com.escape.states;

import java.awt.Graphics;
import java.util.Iterator;

import com.escape.Game;
import com.escape.assets.Assets;
import com.escape.entities.Items;
import com.escape.entities.Player;
import com.escape.managers.KeyManager;
import com.escape.utils.MapLoader;

public class GameState extends State{
	
	private static int level = 2;
	private int currentlevel = level;
	public static int [][] currentMap;
	public static final int TILESIZE = 50;
	
	private Player p1;

	private Iterator<Items> it;
	public static boolean k1, k2, k3, k4, k5, k6, k7, k8, k9, ks;

	public GameState(Game game) {
		super(game);

		setLevel(currentlevel);
		
		p1 = new Player(game, MapLoader.startX * TILESIZE , MapLoader.startY * TILESIZE);
	}

	private void setLevel(int level){
		currentlevel = level;
		currentMap = MapLoader.loadMap("resources/maps/mapL"+currentlevel+".txt");
		int i;
		for(i = 0;i<MapLoader.keys.size() - 3; i+=2){
			new Items(game, MapLoader.keys.get(i) * TILESIZE, MapLoader.keys.get(i+1) * TILESIZE, Assets.keycard);
		}
		for(i = MapLoader.keys.size() - 3 ; i< MapLoader.keys.size() - 1; i+= 2){
			new Items(game, MapLoader.keys.get(i) * TILESIZE, MapLoader.keys.get(i+1) * TILESIZE, Assets.hkeycard);
		}
		Items.it = new Items[MapLoader.keys.size()/2 + 1];
		Items.it = Items.items.toArray(Items.it);
	}
	
	@Override
	public void tick() {
		if(currentlevel != level){
			setLevel(level);
			System.out.println("level changed");
			p1.setxPos(MapLoader.startX * TILESIZE);
			p1.setyPos(MapLoader.startY * TILESIZE);
		}
		
		p1.tick();
		
		Iterator<Items> it = Items.items.iterator();
		while(it.hasNext()){
			it.next().tick();
		}
		
		if(KeyManager.esc){
			State.setState(game.menustate);
		}
	}

	@Override
	public void render(Graphics g) {
		
		for( int y = 0; y < MapLoader.getWidth(); y++ ){
			for ( int x = 0; x < MapLoader.getHeight(); x++ ){
				g.drawImage(Assets.tiles.get(currentMap[y][x]), (int)(x * TILESIZE - game.getViewPort().xOffset),
						(int)(y * TILESIZE - game.getViewPort().yOffset), TILESIZE, TILESIZE, null);
			}
		}
		
		g.drawImage(Assets.statBar, 5, 5, 590, 60, null);
		
		it = Items.items.iterator();
		while(it.hasNext()){
			Items i = it.next();
			if(p1.pBound.intersects(i.bound)){
				checkKey(i);
			}else{
				i.render(g);
			}						
		}
		
		p1.render(g);
		
		showStat(g);
	}
	
	private void checkKey(Items i){
		if(KeyManager.space){
			if (i == Items.it[0]) {
				k1 = true;
				p1.pop.doortip = true;
				it.remove();
			} else if (i == Items.it[1]) {
				k2 = true;
				it.remove();
			} else if (i == Items.it[2]) {
				k3 = true;
				it.remove();
			} else if (i == Items.it[3]) {
				k4 = true;
				it.remove();
			} else if (i == Items.it[4]) {
				k5 = true;
				it.remove();
			} else if (i == Items.it[5]) {
				k6 = true;
				it.remove();
			} else if (i == Items.it[6]) {
				k7 = true;
				it.remove();
			} else if (i == Items.it[7]) {
				k8 = true;
				it.remove();
			} else if (i == Items.it[8]) {
				k9 = true;
				it.remove();
			} else if (i == Items.it[9]) {
				ks = true;
				it.remove();
			}
		}
	}
	
	private void showStat(Graphics g){
			g.drawImage(Assets.face, 20, 13, 40, 40, null);
		if(k1)
			g.drawImage(Assets.keycard, 70, 13, 40, 40, null);
		if(k2)
			g.drawImage(Assets.keycard, 120, 13, 40, 40, null);
		if(k3)
			g.drawImage(Assets.keycard, 170, 13, 40, 40, null);
		if(k4)
			g.drawImage(Assets.keycard, 220, 13, 40, 40, null);
		if(k5)
			g.drawImage(Assets.keycard, 270, 13, 40, 40, null);
		if(k6)
			g.drawImage(Assets.keycard, 320, 13, 40, 40, null);
		if(k7)
			g.drawImage(Assets.keycard, 370, 13, 40, 40, null);
		if(k8)
			g.drawImage(Assets.keycard, 420, 13, 40, 40, null);
		if(k9)
			g.drawImage(Assets.keycard, 470, 13, 40, 40, null);
		if(ks)
			g.drawImage(Assets.hkeycard, 520, 13, 40, 40, null);
	}
	
	public static int getTile(int x, int y){
		return currentMap[y][x];
	}
	
	public static void setTile(int x, int y, int t){
		currentMap[y][x] = t;
	}
	
	public static void reset(){
		MapLoader.keys.clear();
		Items.items.clear();
		level = 1;
		k1 = false; k2 = false; k3 = false; k4 = false; k5 = false;
		k6 = false; k7 = false; k8 = false; k9 = false; ks = false;
	}
}
