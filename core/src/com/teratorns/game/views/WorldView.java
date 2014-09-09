package com.teratorns.game.views;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Array;
import com.teratorns.game.GameRenderer;
import com.teratorns.game.GameWorld;
import com.teratorns.objects.ConcreteObject;
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
			GameRenderer.instance.shapeRenderer.setProjectionMatrix(GameRenderer.instance.camera.combined);
			GameRenderer.instance.shapeRenderer.begin(ShapeType.Filled);
			GameRenderer.instance.shapeRenderer.setColor(Color.GREEN);
			GameRenderer.instance.shapeRenderer.rect(0, 0, Constants.windowWidth, Constants.windowHeight);
			GameRenderer.instance.shapeRenderer.setColor(Color.DARK_GRAY);
			GameRenderer.instance.shapeRenderer.circle(ConcreteObject.meta.x, ConcreteObject.meta.y, 0.05f, 15);
			GameRenderer.instance.shapeRenderer.end();
		}
	}
}
