package com.teratorns.utils;

import com.badlogic.gdx.Gdx;

public abstract class Constants {
	
	public static int windowWidth;
	public static int windowHeight;
	
	public static float aspectRatio = ((float) windowHeight) / windowWidth;
	// by default viewport is ... but you can adjust to your needs
	public static float viewportWidth = 10;
	public static float viewportHeight = viewportWidth * aspectRatio;
	
	public static void setScreenDimensions(int width, int height) {
		windowWidth = width;
		windowHeight = height;
		aspectRatio = ((float) windowHeight) / windowWidth;
		readjustViewport();
	}
	
	/** This method adjusts the window size in accordance with the actual size of the device screen */
	public static void recalculateParameters() {

		switch(Gdx.app.getType()) {
			// In Android
			case Android:
				windowWidth = Gdx.graphics.getWidth();
				windowHeight = Gdx.graphics.getHeight();
			
			// Other Devices (browser, desktop, ...)	
			default:
				windowWidth = (int) (Gdx.graphics.getWidth() * 0.75f);
				windowHeight = (int) (Gdx.graphics.getHeight() * 0.75f);
				break;
		}
		// The aspect ratio is function of real size of screen
		aspectRatio = ((float) windowHeight) / windowWidth;
		readjustViewport();
	}
	
	public static void setViewportWidth(float width) {
		viewportWidth = width;
		viewportHeight = viewportWidth * aspectRatio;
	}
	
	public static void setViewPortHeight(float height) {
		viewportHeight = height;
		viewportWidth = viewportHeight / aspectRatio;
	}
	
	public static void readjustViewport() {
		viewportHeight = viewportWidth * aspectRatio;
	}
}
