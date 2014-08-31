package com.teratorns.view;

import com.badlogic.gdx.utils.Array;

public abstract class View {
	
	protected Array<Layer> layers;
	
	protected View() {
		layers = new Array<Layer>();
	}
	
	public void draw() {
		for (Layer l : layers) {
			if (l.isVisible()) {
				l.draw();
			}
		}
	}
	
	public void addLayer(Layer layer) {
		layers.add(layer);
	}
}
