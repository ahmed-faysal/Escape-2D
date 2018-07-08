package com.escape.managers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	public static boolean up, down, left, right, space, esc, t;
	
	@Override
	public void keyPressed(KeyEvent k) {
		if (k.getKeyCode() == KeyEvent.VK_UP) {
			up = true;
		}else if (k.getKeyCode() == KeyEvent.VK_DOWN) {
			down = true;
		}else if (k.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true;
		}else if (k.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = true;
		}else if(k.getKeyCode() == KeyEvent.VK_SPACE){
			space = true;
		}else if (k.getKeyCode() == KeyEvent.VK_ESCAPE){
			esc = true;
		}else if (k.getKeyCode() == KeyEvent.VK_T){
			t = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent k) {
		if (k.getKeyCode() == KeyEvent.VK_UP) {
			up = false;
		}else if (k.getKeyCode() == KeyEvent.VK_DOWN) {
			down = false;
		}else if (k.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false;
		}else if (k.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;
		}else if(k.getKeyCode() == KeyEvent.VK_SPACE){
			space = false;
		}else if (k.getKeyCode() == KeyEvent.VK_ESCAPE){
			esc = false;
		}else if (k.getKeyCode() == KeyEvent.VK_T){
			t = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent k) {
		
	}

}
