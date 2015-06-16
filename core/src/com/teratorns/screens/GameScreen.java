package com.teratorns.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.game.GameClock;
import com.teratorns.game.GameGui;
import com.teratorns.game.GameLogic;
import com.teratorns.game.GameOptions;
import com.teratorns.game.GameRenderer;
import com.teratorns.game.GameWorld;
import com.teratorns.helpers.CameraHelper;
import com.teratorns.helpers.InputHelper;
import com.teratorns.helpers.InteractionHelper;
import com.teratorns.helpers.PlayerHelper;
import com.teratorns.utils.Constants;
import com.teratorns.utils.Transformations;
import com.teratorns.view.GuiView;
import com.teratorns.view.InteractionView;
import com.teratorns.view.TeratornsView;
import com.teratorns.view.ViewManager;

public class GameScreen implements Screen {
	
	private GameWorld gameWorld;
	private GameLogic gameLogic;
	private GameGui gameGui;
	
	@Override
	public void show() {
		gameWorld = new GameWorld();
		gameLogic = new GameLogic(gameWorld);
		
		gameGui = new GameGui();
		
		PlayerHelper playerHelper = new PlayerHelper();
		GameOptions gameOptions = new GameOptions();
		InteractionHelper interactionHelper = new InteractionHelper(gameWorld, gameGui, playerHelper, gameOptions);
		InputHelper inputHelper = new InputHelper(interactionHelper);
		Gdx.input.setInputProcessor(inputHelper);
		
		ViewManager.instance.addView(new GuiView(gameGui));
		ViewManager.instance.addView(new TeratornsView(gameWorld));
		ViewManager.instance.addView(new InteractionView(interactionHelper));
	}

	@Override
	public void render(float delta) {
		// Update GameClock
		GameClock.instance.incrementTime(delta);
		
		// Apply Logic to game world
		gameLogic.update();
		
		// Render game elements
		GameRenderer.instance.render();
	}

	@Override
	public void resize(int width, int height) {
		Constants.setScreenDimensions(width, height);
		CameraHelper.instance.setPosition(Constants.viewportWidth / 2, Constants.viewportHeight / 2);
		Transformations.refactor();
		GameRenderer.instance.adjustCameraParameters();
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
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
		AssetsLoader.instance.disposeAssests();
		GameRenderer.instance.dispose();
		Gdx.input.setInputProcessor(null);
	}
}
