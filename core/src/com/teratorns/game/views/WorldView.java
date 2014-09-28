package com.teratorns.game.views;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.utils.Array;
import com.teratorns.game.GameRenderer3D;
import com.teratorns.game.GameWorld;
import com.teratorns.objects.GameObject3D;
import com.teratorns.view.Layer;
import com.teratorns.view.View;

public class WorldView extends View {
	private GameWorld gameWorld;
	
	public WorldView(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
		
		addLayer(new GameObjectsLayer());
	}
	
	private class GameObjectsLayer extends Layer {

		@Override
		public void draw() {
			GameRenderer3D.instance.modelBatch.begin(GameRenderer3D.instance.camera);
			
			Array<GameObject3D> objects = gameWorld.getWorldObjects();
			Environment environment = gameWorld.getEnvironment();
			
			for (GameObject3D obj : objects) {
				obj.draw(environment);
			}
	        
	        GameRenderer3D.instance.modelBatch.end();
		}
	}
}
