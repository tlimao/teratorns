package com.teratorns.game;


public class GameClock {
	
	public static GameClock instance = new GameClock();
	
	private float runTime;
	private float delta;
	
	private float gameTime;
	
	private GameClock() {
		runTime = 0;
		gameTime = 0;
	}
	
	public void incrementRunTime(float delta) {
		runTime += delta;
		this.delta = delta;
	}
	
	public void incrementGameTime(float delta) {
		gameTime += delta;
	}
	
	public float getRunTime() {
		return runTime;
	}
	
	public float getGameTime() {
		return gameTime;
	}
	
	public float getDelta() {
		return delta;
	}
	
	public void reset() {
		runTime = 0;
		gameTime = 0;
	}
}
