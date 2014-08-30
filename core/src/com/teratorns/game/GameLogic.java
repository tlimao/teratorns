package com.teratorns.game;

public class GameLogic {
	
	private GameWorld gameWorld;
	
	public GameLogic(GameWorld world) {
		gameWorld = world;
	}
	
	public void update(float delta) {
		gameWorld.update(delta);
	}
}
