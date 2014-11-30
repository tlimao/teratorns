package com.teratorns.utils;

public class Constants {
	
	public static int windowWidth = 720;
	public static int windowHeight = 1280;
	
	public static float aspectRatio = ((float) windowHeight) / windowWidth;
	
	public static float viewportWidth = 60;
	public static float viewportHeight = viewportWidth * aspectRatio;
	
	public static String BASE_COLOR = "gui/base/base_color.png";
	
	public static String TX_ICONS_MAP = "gui/minimalisticons.pack";
	
	public static String TX_BOID = "gfx/boid/boid.png";
	public static String TX_CIRCLE = "gfx/boid/circle.png";
	
	public static String KENNEY_BASE_FONT = "fnt/kenney.fnt";
	public static String KENNEY_BASE_TX = "fnt/kenney.png";
	
	public static float INTERACTION_TIME = 0.1f;
}
