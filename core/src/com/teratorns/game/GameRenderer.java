package com.teratorns.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.teratorns.helpers.CameraHelper;
import com.teratorns.utils.Constants;
import com.teratorns.view.View;
import com.teratorns.view.ViewManager;

public class GameRenderer {
	
	public static GameRenderer instance = new GameRenderer();
	
	public SpriteBatch spriteRenderer;
	public ShapeRenderer shapeRenderer;
	public Box2DDebugRenderer physicsRenderer;
	
	public OrthographicCamera camera;
	public OrthographicCamera guiCamera;
	
	private GameRenderer() {
		System.out.println("Renderer Created");
		
		camera = new OrthographicCamera();
		camera.setToOrtho(true, Constants.viewportWidth, Constants.viewportHeight);
		
		guiCamera = new OrthographicCamera();
		guiCamera.setToOrtho(true, Constants.windowWidth, Constants.windowHeight);
		
		spriteRenderer = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		physicsRenderer = new Box2DDebugRenderer();
	}

	public void render() {
		CameraHelper.instance.updateCamera();
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		for (View v : ViewManager.instance.views) {
			v.draw();
		}
	}
}
