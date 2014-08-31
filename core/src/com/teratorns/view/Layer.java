package com.teratorns.view;

public abstract class Layer {
	
	private boolean isVisible;
	
	public Layer() {
		isVisible = true;
	}
	
	public void setVisibility(boolean value) {
		isVisible = value;
	}
	
	public boolean isVisible() {
		return isVisible;
	}
	
	public abstract void draw();
}
