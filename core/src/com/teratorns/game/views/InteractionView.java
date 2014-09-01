package com.teratorns.game.views;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.teratorns.game.GameRenderer;
import com.teratorns.helpers.InteractionHelper;
import com.teratorns.view.Layer;
import com.teratorns.view.View;

public class InteractionView extends View {
	
	private InteractionHelper interactionHelper;
	private Rectangle lastClick;
	
	public InteractionView(InteractionHelper interactionHelper) {
		this.interactionHelper = interactionHelper;
		this.addLayer(new ClickLayer());
		
		lastClick = new Rectangle();
	}
	
	private class ClickLayer extends Layer {

		@Override
		public void draw() {
			lastClick.set(interactionHelper.getLastClick());
			
			GameRenderer.instance.shapeRenderer.setProjectionMatrix(GameRenderer.instance.camera.combined);
			GameRenderer.instance.shapeRenderer.begin(ShapeType.Line);
			GameRenderer.instance.shapeRenderer.setColor(Color.GRAY);
			GameRenderer.instance.shapeRenderer.rect(lastClick.x, lastClick.y, lastClick.width, lastClick.height);
			GameRenderer.instance.shapeRenderer.end();
		}
	}
}
