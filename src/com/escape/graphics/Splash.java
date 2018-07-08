package com.escape.graphics;

import java.awt.Color;

import com.thehowtotutorial.splashscreen.JSplash;

public class Splash {
	
	public static void initSplash() throws InterruptedException{
		
		JSplash sp = new JSplash(Splash.class.getResource("/splash.png"), true, true, false, "Alpha 1.2", null, Color.WHITE, Color.BLACK);
		
		sp.splashOn();

		sp.setProgress(20, "Initializing...");

		Thread.sleep(250);

		sp.setProgress(50, "Loading components....");

		Thread.sleep(500);

		sp.setProgress(80, "Starting services.....");

		Thread.sleep(100);

		sp.setProgress(90, "Ready! Start now!");
		
		Thread.sleep(25);

		sp.splashOff();
		
		return;
	}
	
}
