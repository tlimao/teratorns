package com.teratorns.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.teratorns.game.GameRenderer;
import com.teratorns.helpers.InteractionHelper;

public class InteractionView extends View {
	
	private InteractionHelper interactionHelper;
	
	public InteractionView (InteractionHelper interactionHelper) {
		this.interactionHelper = interactionHelper;
		
		addLayer(new ClickLayer());
	}
	
	private class ClickLayer extends Layer {

		@Override
		public void draw() {
			Vector2 pos = interactionHelper.getLastClickPosition();
			float range = interactionHelper.getInteractionRange();
			GameRenderer.instance.shapeRenderer.setProjectionMatrix(GameRenderer.instance.camera.combined);
			GameRenderer.instance.shapeRenderer.begin(ShapeType.Line);
			GameRenderer.instance.shapeRenderer.setColor(Color.GREEN);
			GameRenderer.instance.shapeRenderer.rect(pos.x, pos.y, range, range);
			GameRenderer.instance.shapeRenderer.end();
		}
	}
}
