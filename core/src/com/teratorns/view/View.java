package com.teratorns.view;

import com.badlogic.gdx.utils.Array;

public abstract class View {
	
	protected String tag;
	
	protected Array<Layer> layers;
	
	protected View() {
		tag = "";
		layers = new Array<Layer>();
	}
	
	public void draw() {
		for (Layer l : layers) {
			l.draw();
		}
	}
	
	public void addLayer(Layer layer) {
		layers.add(layer);
	}
}
