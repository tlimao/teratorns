package com.teratorns.utils;

import com.badlogic.gdx.Gdx;

public abstract class Constants {
	
	public static int windowWidth = 800;
	public static int windowHeight = 500;
	
	public static float aspectRatio = ((float) windowHeight) / windowWidth;
	
	public static float viewportWidth = 10;
	public static float viewportHeight = viewportWidth * aspectRatio;
	
	public static void setScreenDimensions(int width, int height) {
		windowWidth = width;
		windowHeight = height;
		aspectRatio = ((float) windowHeight) / windowWidth;
		readjustViewport();
	}
	
	public static void recalculateParameters() {

		switch(Gdx.app.getType()) {
			case Android:
				windowWidth = Gdx.graphics.getWidth();
				windowHeight = Gdx.graphics.getHeight();
				
			default:
				windowWidth = (int) (Gdx.graphics.getWidth() * 0.75f);
				windowHeight = (int) (Gdx.graphics.getHeight() * 0.75f);
				break;
		}
		
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
