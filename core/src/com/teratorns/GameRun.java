package com.teratorns;

import com.badlogic.gdx.Game;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.screens.GameScreen;
import com.teratorns.utils.Constants;

public class GameRun extends Game {
	
	@Override
	public void create() {
		// This method is called to adjust game screen parameters to device screen dimensions
		Constants.recalculateParameters();
		// Load assets
		System.out.println("Loading assets ...");
		AssetsLoader.instance.loadAssets();
		setScreen(new GameScreen());
	}
}
