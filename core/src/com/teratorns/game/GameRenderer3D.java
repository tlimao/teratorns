package com.teratorns.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.teratorns.helpers.CameraHelper3D;
import com.teratorns.view.View;
import com.teratorns.view.ViewManager;

public class GameRenderer3D {
	public static GameRenderer3D instance = new GameRenderer3D();
	
	public ModelBatch modelBatch;
	
	public PerspectiveCamera camera;
	//public OrthographicCamera guiCamera;
	
	private GameRenderer3D() {
		camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(2f, 2f, 2f);
		camera.lookAt(0,0,0);
		camera.near = 1f;
		camera.far = 300f;
		camera.update();
		
		modelBatch = new ModelBatch();
	}
	
	public void render() {
		CameraHelper3D.instance.updateCamera();
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        for (View v : ViewManager.instance.views) {
			v.draw();
		}
	}
	
	public void dispose() {
		modelBatch.dispose();
	}
}
