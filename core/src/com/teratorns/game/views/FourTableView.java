package com.teratorns.game.views;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.teratorns.game.GameFour;
import com.teratorns.game.GameHud;
import com.teratorns.game.GameRenderer;
import com.teratorns.gui.GuiElement;
import com.teratorns.helpers.TableHelper;
import com.teratorns.utils.Constants;
import com.teratorns.view.Layer;
import com.teratorns.view.View;

public class FourTableView extends View {

	private GameFour game;
	private TableHelper tableHelper;
	private GameHud hud;
	
	public FourTableView(GameFour game, TableHelper tableHelper, GameHud hud) {
		this.game = game;
		this.tableHelper = tableHelper;
		this.hud = hud;
		addLayer(new BackgroundLayer());
		addLayer(new TableLayer());
		//addLayer(new TableLayerInteractors());
		//addLayer(new TableLayerContactFinger());
		
		addLayer(new TableHud());
	}
	
	private class BackgroundLayer extends Layer {

		@Override
		public void draw() {
			GameRenderer.instance.shapeRenderer.setProjectionMatrix(GameRenderer.instance.camera.combined);
			GameRenderer.instance.shapeRenderer.begin(ShapeType.Filled);
			GameRenderer.instance.shapeRenderer.setColor(Color.WHITE);
			GameRenderer.instance.shapeRenderer.rect(0, 0, Constants.viewportWidth, Constants.viewportHeight);
			GameRenderer.instance.shapeRenderer.end();
		}
	}
	
	private class TableLayer extends Layer {

		@Override
		public void draw() {
			GameRenderer.instance.spriteRenderer.setProjectionMatrix(GameRenderer.instance.camera.combined);
			GameRenderer.instance.spriteRenderer.begin();
			game.getGameTable().draw();
			GameRenderer.instance.spriteRenderer.end();
		}
	}
	
	private class TableLayerInteractors extends Layer {

		@Override
		public void draw() {
			GameRenderer.instance.shapeRenderer.setProjectionMatrix(GameRenderer.instance.camera.combined);
			game.getGameTable().drawInteractor();
		}
	}
	
	private class TableLayerContactFinger extends Layer {

		@Override
		public void draw() {
			Vector2 touchPos = tableHelper.getTouchPosition();
			GameRenderer.instance.shapeRenderer.setProjectionMatrix(GameRenderer.instance.camera.combined);
			GameRenderer.instance.shapeRenderer.begin(ShapeType.Filled);
			GameRenderer.instance.shapeRenderer.setColor(Color.RED);
			GameRenderer.instance.shapeRenderer.circle(touchPos.x, touchPos.y, 0.25f, 20);
			GameRenderer.instance.shapeRenderer.end();
		}
	}
	
	private class TableHud extends Layer {

		@Override
		public void draw() {
			Array<GuiElement> elements = hud.getGuiElements();

			GameRenderer.instance.spriteRenderer.begin();
			GameRenderer.instance.spriteRenderer.setProjectionMatrix(GameRenderer.instance.guiCamera.combined);
			
			for (GuiElement element : elements) {
				if (element.isVisible())
				{
					element.draw();
				}
			}
			
			GameRenderer.instance.spriteRenderer.end();
		}

	}
}
