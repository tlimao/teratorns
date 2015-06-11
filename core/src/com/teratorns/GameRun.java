package com.teratorns;

import com.badlogic.gdx.Game;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.screens.GameScreen;

public class GameRun extends Game {

	@Override
	public void create() {
		// Load assets
		System.out.println("Loading assets ...");
		AssetsLoader.instance.loadAssets();
		setScreen(new GameScreen());
	}
	
	@Override
	public void dispose() {
		super.dispose();
		// Dispose assets
		System.out.println("Dispose loaded assets ...");
		AssetsLoader.instance.disposeAssests();
	}
}
