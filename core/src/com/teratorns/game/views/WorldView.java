package com.teratorns.game.views;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.game.GameRenderer;
import com.teratorns.game.GameWorld;
import com.teratorns.game.logic.ColonyVariables;
import com.teratorns.game.logic.PheromoneLogic;
import com.teratorns.objects.GameObject;
import com.teratorns.utils.Constants;
import com.teratorns.view.Layer;
import com.teratorns.view.View;

public class WorldView extends View {

	private GameWorld gameWorld;
	
	public WorldView(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
		this.addLayer(new BackgroundLayer());
		this.addLayer(new PheromoneLayer());
		//this.addLayer(new DebugLayer());
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
			GameRenderer.instance.spriteRenderer.setColor(1, 1, 1, 1);
			GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.baseColor,
													  0, 0, 
													  Constants.viewportWidth, Constants.viewportHeight);
			GameRenderer.instance.spriteRenderer.end();
			
		}
	}
	
	private class PheromoneLayer extends Layer{

		@Override
		public void draw() {
			GameRenderer.instance.spriteRenderer.setProjectionMatrix(GameRenderer.instance.camera.combined);
			GameRenderer.instance.spriteRenderer.begin();
			for(int i = 0; i < ColonyVariables.instance.splitFactor; i++){
				for(int j = 0; j < ColonyVariables.instance.splitFactor; j++){
					float pheromone = PheromoneLogic.instance.pheromoneMap.get(new Vector2(i,j).cpy());
					GameRenderer.instance.spriteRenderer.setColor(0.5f,0,1, pheromone/ColonyVariables.instance.maxPheromone);
					GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.baseColor,
							i*Constants.viewportWidth/ColonyVariables.instance.splitFactor, j*Constants.viewportHeight/ColonyVariables.instance.splitFactor, 
							ColonyVariables.instance.gridWidthSize, ColonyVariables.instance.gridHeightSize);
				}
			}
			
			GameRenderer.instance.spriteRenderer.end();
		}
	}
	
	private class DebugLayer extends Layer{
		@Override
		public void draw() {
			GameRenderer.instance.shapeRenderer.setProjectionMatrix(GameRenderer.instance.camera.combined);
			GameRenderer.instance.shapeRenderer.begin(ShapeType.Line);
			GameRenderer.instance.shapeRenderer.setColor(Color.GREEN);
			float splitFactor = ColonyVariables.instance.splitFactor;
			float x = ColonyVariables.instance.gridWidthSize;
			float y = ColonyVariables.instance.gridHeightSize;
			for(int i = 0; i <= splitFactor; i++){
				
				GameRenderer.instance.shapeRenderer.line(new Vector2(i*x, 0), new Vector2(i*x, Constants.viewportHeight));
				GameRenderer.instance.shapeRenderer.line(new Vector2(0, i*y), new Vector2(Constants.viewportWidth, i*y));
			}
			GameRenderer.instance.shapeRenderer.end();
			GameRenderer.instance.shapeRenderer.begin(ShapeType.Filled);
			for(int i = 0; i <= splitFactor; i++){
				for(int j = 0; j <= splitFactor; j++){
					GameRenderer.instance.shapeRenderer.circle((i+ .5f)*x, (j + .5f)*y, 0.005f, 100);
				}
			}
			GameRenderer.instance.shapeRenderer.end();
			GameRenderer.instance.shapeRenderer.begin(ShapeType.Line);
			for(int i = 0; i <= splitFactor; i++){
				for(int j = 0; j <= splitFactor; j++){
					GameRenderer.instance.shapeRenderer.circle((i+ .5f)*x, (j + .5f)*y, 0.05f, 100);
				}
			}
			GameRenderer.instance.shapeRenderer.end();
		}
	}
}
