package com.escape.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class MapLoader {
	
	public static int mapHeight, mapWidth, startX, startY;
	
	public static ArrayList<Integer> keys = new ArrayList<Integer>();
	
	private static int [][] map;
	
	public static int[][] loadMap(String path){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			mapHeight = Integer.parseInt(br.readLine());
			mapWidth = Integer.parseInt(br.readLine());
			
			startX = Integer.parseInt(br.readLine());
			startY = Integer.parseInt(br.readLine());
			
			map = new int [mapHeight][mapWidth];
			
			for (int row=0; row<mapHeight; row++){
				String line = br.readLine();
				String [] rows = line.split(" ");
				for (int col=0; col<mapWidth; col++){
					map[row][col] = Integer.parseInt(rows[col]);
				}
			}
			
			String s;
			while((s = br.readLine())!= null){
				keys.add(Integer.parseInt(s));
			}
			
			br.close();
			return map;
			
		}catch(Exception e){
			e.printStackTrace();
			System.exit(1);
			System.out.println("Could not load map!");
		}
		return null;
	}
	
	public static int getHeight(){
		return mapHeight;
	}
	
	public static int getWidth(){
		return mapWidth;
	}
}