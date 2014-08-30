package com.teratorns.player;

public class Player {
	private String name;
	private float lifeMax;
	private float life;
	private boolean win;
	private boolean isLive;
	
	public Player(String playerName) {
		name = playerName;
		lifeMax = 10;
		life = 10;
		win = false;
		isLive = true;
	}
	
	public void decrementLife(float value) {
		life -= value;
		
		if (life <= 0) {
			isLive = false;
		}
	}
	
	public void incrementLife(float value) {
		life += value;
		
		if (life >= lifeMax) {
			life = lifeMax;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isLive() {
		return isLive;
	}
	
	public void setWinner(boolean value) {
		win = value;
	}
	
	public boolean isWinner() {
		return win;
	}
}
