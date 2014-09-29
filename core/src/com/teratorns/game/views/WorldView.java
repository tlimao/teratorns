package com.teratorns.game.views;

import com.badlogic.gdx.utils.Array;
import com.teratorns.assets.AssestsLoader;
import com.teratorns.game.GameRenderer;
import com.teratorns.game.GameWorld;
import com.teratorns.objects.GameObject;
import com.teratorns.utils.Constants;
import com.teratorns.view.Layer;
import com.teratorns.view.View;

public class WorldView extends View {

	private GameWorld gameWorld;
	
	public WorldView(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
		this.addLayer(new BackgroundLayer());
		this.addLayer(new ObjectsLayer());
	}
	
	private class ObjectsLayer extends Layer {

		@Override
		public void draw() {
			Array<GameObject> objects = gameWorld.getWorldObjects();
			
			GameRenderer.instance.spriteRenderer.setProjectionMatrix(GameRenderer.instance.camera.combined);
			GameRenderer.instance.spriteRenderer.begin();
			
			for (GameObject obj : objects) {
				obj.draw();
			}
			
			GameRenderer.instance.spriteRenderer.end();
		}
	}
	
	private class BackgroundLayer extends Layer {

		@Override
		public void draw() {
			GameRenderer.instance.spriteRenderer.setProjectionMatrix(GameRenderer.instance.camera.combined);
			GameRenderer.instance.spriteRenderer.begin();
			
			for (int i = 0; i < Constants.viewportWidth; i++) {
				for (int j = 0; j < Constants.viewportHeight; j++) {
					GameRenderer.instance.spriteRenderer.draw(AssestsLoader.instance.grass,
							  i, j,
							  0, 0,
							  1, 1,
							  1, 1,
							  0);
				}
			}
			
			GameRenderer.instance.spriteRenderer.end();
		}
	}
}
