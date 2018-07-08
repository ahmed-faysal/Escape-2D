package com.escape.assets;

import java.awt.Graphics;

import com.escape.managers.KeyManager;

public class Popup {

	public boolean movetip, locktip, elocktip, doortip, think1;
	
	public Popup(){

	}	
	
	public void tick(){
		if(KeyManager.t){
			movetip = false;
			locktip = false;
			elocktip = false;
			doortip = false;
			think1 = false;
		}
	}
	
	public void render(Graphics g){
		if(locktip)
			g.drawImage(Assets.lockTip, 100, 200, 400, 200, null);
		if(movetip)
			g.drawImage(Assets.moveTip, 100, 200, 400, 200, null);
		if(elocktip)
			g.drawImage(Assets.elockTip, 100, 200, 400, 200, null);
		if(doortip)
			g.drawImage(Assets.doorTip, 100, 200, 400, 200, null);
		if(think1)
			g.drawImage(Assets.think1, 100, 200, 400, 200, null);
		
	}
	
}
