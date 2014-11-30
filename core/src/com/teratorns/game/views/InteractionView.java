package com.teratorns.game.views;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.teratorns.game.GameRenderer;
import com.teratorns.helpers.InteractionHelper;
import com.teratorns.objects.FoodSource;
import com.teratorns.view.Layer;
import com.teratorns.view.View;

public class InteractionView extends View {
	
	private InteractionHelper interactionHelper;
	
	public InteractionView(InteractionHelper interactionHelper) {
		this.interactionHelper = interactionHelper;
		//addLayer(new InteractionLayer());
	}
	
	private class InteractionLayer extends Layer {

		@Override
		public void draw() {
			GameRenderer.instance.shapeRenderer.setProjectionMatrix(GameRenderer.instance.camera.combined);
			GameRenderer.instance.shapeRenderer.begin(ShapeType.Filled);
			GameRenderer.instance.shapeRenderer.setColor(Color.RED);
			GameRenderer.instance.shapeRenderer.circle(FoodSource.food.x, FoodSource.food.y, 0.1f, 20);
			GameRenderer.instance.shapeRenderer.end();
		}
	}
}
