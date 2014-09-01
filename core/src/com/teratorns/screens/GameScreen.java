package com.teratorns.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.teratorns.game.GameClock;
import com.teratorns.game.GameLogic;
import com.teratorns.game.GameOptions;
import com.teratorns.game.GameRenderer;
import com.teratorns.game.GameWorld;
import com.teratorns.game.views.InteractionView;
import com.teratorns.game.views.WorldView;
import com.teratorns.helpers.InputHelper;
import com.teratorns.helpers.InteractionHelper;
import com.teratorns.helpers.PlayerHelper;
import com.teratorns.view.ViewManager;

public class GameScreen implements Screen {
	
	private GameWorld gameWorld;
	private GameLogic gameLogic;
	
	public GameScreen() {
		gameWorld = new GameWorld();
		gameLogic = new GameLogic(gameWorld);
		ViewManager.instance.addView(new WorldView(gameWorld));
		
		PlayerHelper playerHelper = new PlayerHelper();
		GameOptions gameOptions = new GameOptions();
		InteractionHelper interactionHelper = new InteractionHelper(gameWorld, playerHelper, gameOptions);
		ViewManager.instance.addView(new InteractionView(interactionHelper));
		InputHelper inputHelper = new InputHelper(interactionHelper);
		Gdx.input.setInputProcessor(inputHelper);
	}

	@Override
	public void render(float delta) {
		// Update GameClock
		GameClock.instance.incrementTime(delta);
		
		// Apply Logic to game world
		gameLogic.update();
		
		// Render game
		GameRenderer.instance.render();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
