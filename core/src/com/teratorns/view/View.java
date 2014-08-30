package com.teratorns.view;

import com.badlogic.gdx.utils.Array;

public abstract class View {
	
	protected String tag;
	
	protected Array<Layer> layers;
	
	protected View() {
		tag = "";
		layers = new Array<Layer>();
	}
	
	public void draw(float runtime) {
		for (Layer l : layers) {
			l.draw(runtime);
		}
	}
	
	public void addLayer(Layer layer) {
		layers.add(layer);
	}
}
