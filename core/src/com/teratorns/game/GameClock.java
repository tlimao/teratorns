package com.teratorns.game;

public class GameClock {
	
	public static GameClock instance = new GameClock();
	
	private float runtime;
	
	private GameClock() {
		runtime = 0;
	}
	
	public void incrementTime(float delta) {
		runtime += delta;
	}
	
	public float getRunTime() {
		return runtime;
	}
	
	public void reset() {
		runtime = 0;
	}
}
