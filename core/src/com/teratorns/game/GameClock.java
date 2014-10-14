package com.teratorns.game;

import com.teratorns.assets.AssetsLoader;

public class GameClock {
	
	public static GameClock instance = new GameClock();
	
	private float runtime;
	private float delta;
	private float musicTimeStart = 10;
	private boolean musicFlag = false;
	
	private GameClock() {
		runtime = 0;
	}
	
	public void incrementTime(float delta) {
		runtime += delta;
		this.delta = delta;
		
		if (runtime > musicTimeStart && !musicFlag) {
			startMusic();
			musicFlag = true;
		}
	}
	
	private void startMusic() {
		AssetsLoader.instance.horrorAmbientMusic.play();
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
