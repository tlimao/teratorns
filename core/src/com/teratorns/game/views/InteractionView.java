package com.teratorns.game.views;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.teratorns.assets.AssetsLoader;
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
			
			/*GameRenderer.instance.shapeRenderer.setProjectionMatrix(GameRenderer.instance.camera.combined);
			GameRenderer.instance.shapeRenderer.begin(ShapeType.Line);
			GameRenderer.instance.shapeRenderer.setColor(Color.GRAY);
			GameRenderer.instance.shapeRenderer.rect(lastClick.x - lastClick.width/2, lastClick.y - lastClick.height/2, lastClick.width, lastClick.height);
			GameRenderer.instance.shapeRenderer.end();
			GameRenderer.instance.shapeRenderer.begin(ShapeType.Filled);
			GameRenderer.instance.shapeRenderer.setColor(Color.RED);
			GameRenderer.instance.shapeRenderer.circle(lastClick.x, lastClick.y, 0.05f, 9);
			GameRenderer.instance.shapeRenderer.end();*/
			
			GameRenderer.instance.spriteRenderer.setProjectionMatrix(GameRenderer.instance.camera.combined);
			GameRenderer.instance.spriteRenderer.begin();
			GameRenderer.instance.spriteRenderer.setColor(0, 0, 0, 0.3f);
			GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.objectiveIcon,
													  lastClick.x - 0.25f, lastClick.y - 0.35f, 
													  0, 0,
													  1, 1,
													  0.5f, 0.5f,
													  0);
			GameRenderer.instance.spriteRenderer.setColor(Color.WHITE);
			GameRenderer.instance.spriteRenderer.end();
		}
	}
}
