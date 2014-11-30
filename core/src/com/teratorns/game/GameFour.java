package com.teratorns.game;

import com.teratorns.assets.AssetsLoader;
import com.teratorns.objects.Table;
import com.teratorns.utils.Constants;

public class GameFour {
	private Table tableGame;
	
	public GameFour() {
		int size = (int) (Constants.viewportWidth * 0.8f);
		float x = (Constants.viewportWidth - size) / 2.0f;
		float y = (Constants.viewportHeight - size) / 2.0f;
		
		tableGame = new Table(x, y, size, 4, 0.5f);
		
		AssetsLoader.instance.kenneyFont.setScale(0.1f);
	}
	
	public void update() {
	}
	
	public Table getGameTable() {
		return tableGame;
	}
}
