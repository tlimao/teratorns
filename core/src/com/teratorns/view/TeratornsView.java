package com.teratorns.view;

import com.badlogic.gdx.utils.Array;
import com.teratorns.game.GameRenderer;
import com.teratorns.game.GameWorld;
import com.teratorns.interaction.Interactor;
import com.teratorns.objects.GameObject;

/** This a example */
public class TeratornsView extends View {
	
	private GameWorld gameWorld;
	
	public TeratornsView(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
		
		addLayer(new TeratornsLogoLayer());
	}
	
	private class TeratornsLogoLayer extends Layer {

		@Override
		public void draw() {
			// Initialize Sprite Renderer
			GameRenderer.instance.spriteRenderer.setProjectionMatrix(GameRenderer.instance.camera.combined);
			GameRenderer.instance.spriteRenderer.begin();
						
			Array<GameObject> gameObjects = gameWorld.getWorldObjects();
			
			for (GameObject obj : gameObjects) {
				obj.draw();
			}
			
			GameRenderer.instance.spriteRenderer.end();
		}
	}
	
	/*private class TeratornsinteractionLayer extends Layer {

		@Override
		public void draw() {
			Array<GameObject> gameObjects = gameWorld.getWorldObjects();
			
			for (GameObject obj : gameObjects) {
				((Interactor<?>) obj).drawInteractor();
			}
		}
	}*/
}
