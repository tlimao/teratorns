package com.teratorns.game;

public class GameOptions {
	private boolean pause;
	
	public static GameOptions instance = new GameOptions();
	
	private GameOptions() {
		pause = true;
	}
	
	public void pause() {
		pause = true;
	}
	
	public void resume() {
		pause = false;
	}
	
	public boolean isPaused() {
		return pause;
	}
}
