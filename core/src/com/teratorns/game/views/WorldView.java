package com.teratorns.game.views;

import com.badlogic.gdx.utils.Array;
import com.teratorns.game.GameRenderer;
import com.teratorns.game.GameWorld;
import com.teratorns.objects.GameObject;
import com.teratorns.view.Layer;
import com.teratorns.view.View;

public class WorldView extends View {
	
	private GameWorld gameWorld;
	
	public WorldView(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
		this.addLayer(new WorldObjectsLayer());
		this.addLayer(new WorldInteractionLayer());
	}
	
	private class WorldObjectsLayer extends Layer {

		@Override
		public void draw() {
			Array<GameObject> objects = gameWorld.getWorldObjects();
			
			GameRenderer.instance.spriteRenderer.setProjectionMatrix(GameRenderer.instance.camera.combined);
			
			for (GameObject obj : objects) {
				obj.draw();
			}
		}
	}
	
	private class WorldInteractionLayer extends Layer {

		@Override
		public void draw() {
			Array<GameObject> objects = gameWorld.getWorldObjects();
			
			GameRenderer.instance.shapeRenderer.setProjectionMatrix(GameRenderer.instance.camera.combined);
			
			for (GameObject obj : objects) {
				obj.drawInteractor();
			}
		}
	}
}
