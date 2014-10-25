package com.teratorns.game.views;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.game.GameRenderer;
import com.teratorns.game.GameWorld;
import com.teratorns.objects.Bird;
import com.teratorns.objects.FoodSource;
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
			// Initialize Sprite Renderer
			GameRenderer.instance.spriteRenderer.setProjectionMatrix(GameRenderer.instance.camera.combined);
			GameRenderer.instance.spriteRenderer.begin();
			// Draw Food Source Flag
			GameRenderer.instance.spriteRenderer.setColor(0, 0, 0, 0.3f);
			GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.objectiveIcon,
													  FoodSource.food.x - 0.25f, FoodSource.food.y - 0.35f, 
													  0, 0,
													  0.5f, 0.5f,
													  1, 1,
													  0);
			GameRenderer.instance.spriteRenderer.setColor(Color.WHITE);
			// Draw Boids
			Array<Bird> objects = gameWorld.getSwarm().getParticles();
			
			for (GameObject obj : objects) {
				obj.draw();
			}
			// Finalize Sprite Renderer
			GameRenderer.instance.spriteRenderer.end();
		}
	}
	
	private class BackgroundLayer extends Layer {

		@Override
		public void draw() {
			GameRenderer.instance.spriteRenderer.setProjectionMatrix(GameRenderer.instance.camera.combined);
			GameRenderer.instance.spriteRenderer.begin();
			GameRenderer.instance.spriteRenderer.setColor(1, 1, 1, 1);
			GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.baseColor,
													  0, 0, 
													  Constants.viewportWidth, Constants.viewportHeight);
			GameRenderer.instance.spriteRenderer.setColor(Color.WHITE);
			GameRenderer.instance.spriteRenderer.end();
		}
	}
}
