package com.teratorns.game.views;

import com.badlogic.gdx.math.Rectangle;
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
			
		}
	}
}
