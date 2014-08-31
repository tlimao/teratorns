package com.teratorns.game;

public class GameClock {
	
	public static GameClock instance = new GameClock();
	
	private float runtime;
	private float delta;
	
	private GameClock() {
		runtime = 0;
	}
	
	public void incrementTime(float delta) {
		runtime += delta;
		this.delta = delta;
	}
	
	public float getRunTime() {
		return runtime;
	}
	
	public float getDelta() {
		return delta;
	}
	
	public void reset() {
		runtime = 0;
	}
}
