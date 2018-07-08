package com.escape.states;

import java.awt.Graphics;
import com.escape.Game;
import com.escape.managers.MouseManager;

public class SettingsState extends State{

	public SettingsState(Game game) {
		super(game);

	}

	@Override
	public void tick() {
		if(MouseManager.rightButton){
			State.setState(game.menustate);
		}
	}

	@Override
	public void render(Graphics g) {
		
	}
}
