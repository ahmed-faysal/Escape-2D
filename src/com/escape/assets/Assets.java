package com.escape.assets;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.escape.utils.ImageLoader;

public class Assets {
	
	private static BufferedImage data, tip1;
	
	public static BufferedImage face, floor, wall, floor2, rdDoor, gDoor, bDoor, keycard, hkeycard, statBar, menu;
	public static BufferedImage lockTip, elockTip, moveTip, doorTip;
	public static BufferedImage think1;

	public static BufferedImage[] player_up, player_down, player_left, player_right, story;
	
	public static ArrayList <BufferedImage> tiles = new ArrayList <BufferedImage> ();
	
	public static void init(){
		data = ImageLoader.load("/GameSprite.png");
		menu = ImageLoader.load("/GameMenu.png");
		tip1 = ImageLoader.load("/popups/tipSet 1.png");
		
		player_up = new BufferedImage[3];
		player_down = new BufferedImage[3];
		player_left = new BufferedImage[3];
		player_right = new BufferedImage[3];
		story = new BufferedImage[4];
		
		player_down[0] = data.getSubimage(305, 270, 32, 32);
		player_down[1] = data.getSubimage(337, 270, 32, 32);
		player_down[2] = data.getSubimage(368, 270, 32, 32);
		
		player_left[0] = data.getSubimage(305, 303, 32, 32);
		player_left[1] = data.getSubimage(337, 302, 32, 32);
		player_left[2] = data.getSubimage(368, 303, 32, 32);
		
		player_right[0] = data.getSubimage(305, 335, 32, 32);
		player_right[1] = data.getSubimage(337, 334, 32, 32);
		player_right[2] = data.getSubimage(368, 335, 32, 32);
		
		player_up[0] = data.getSubimage(305, 367, 32, 32);
		player_up[1] = data.getSubimage(337, 365, 32, 32);
		player_up[2] = data.getSubimage(368, 367, 32, 32);
		
		story[0] = ImageLoader.load("/story/story 1.png");
		story[1] = ImageLoader.load("/story/story 2.png");
		story[2] = ImageLoader.load("/story/story 3.png");
		story[3] = ImageLoader.load("/story/story 4.png");
		
		face = data.getSubimage(305, 170, 95, 96);
		floor = data.getSubimage(96, 64, 32, 32);
		floor2 = data.getSubimage(32, 32, 32, 32);
		wall = data.getSubimage(64, 0, 32, 32);
		rdDoor = data.getSubimage(163, 195, 32, 27);
		gDoor = data.getSubimage(201, 195, 32, 27);
		bDoor = data.getSubimage(239, 195, 32, 27);		
		keycard = data.getSubimage(70, 130, 60, 60);
		hkeycard = data.getSubimage(65, 192, 60, 60);
		
		statBar = data.getSubimage(0, 360, 300, 34);
		
		moveTip = tip1.getSubimage(0, 0, 380, 170);
		lockTip = tip1.getSubimage(0, 185, 380, 170);
		elockTip = tip1.getSubimage(5, 360, 380, 170);
		doorTip = tip1.getSubimage(430, 135, 370, 190);
		
		think1 = tip1.getSubimage(440, 330, 360, 200);
		
		add();
	}
	
	public static void add(){
		
		tiles.add(0, floor);
		tiles.add(1, wall);	
		
		tiles.add(2, bDoor);
		tiles.add(3, bDoor);
		tiles.add(4, bDoor);
		tiles.add(5, bDoor);
		tiles.add(6, bDoor);
		tiles.add(7, bDoor);
		tiles.add(8, bDoor);
		tiles.add(9, bDoor);
		tiles.add(10, bDoor);
		tiles.add(11, bDoor);
		tiles.add(12, rdDoor);
		tiles.add(13, bDoor);
		tiles.add(14, bDoor);
	
		tiles.add(15, floor2);
	}
}