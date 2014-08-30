package com.teratorns.helpers;

import com.badlogic.gdx.math.Vector2;
import com.teratorns.game.GameRenderer;
import com.teratorns.utils.Constants;

public class CameraHelper {

	public static CameraHelper instance = new CameraHelper();
	
	private Vector2 position;
	private float zoom;
	private float zoomMax;
	private float zoomMin;
	private float zoomInc;
	
	private CameraHelper() {
		position.set(Constants.viewportWidth / 2, Constants.viewportHeight / 2);
		
		zoom = 1;
		zoomMax = 1.5f;
		zoomMin = 0.5f;
		zoomInc = 0.2f;
	}
	
	public void setPosition(float x, float y) {
		position.set(x, y);
	}
	
	public void setPosition(Vector2 pos) {
		position.set(pos);
	}
	
	public void incrementZoom() {
		zoom += zoomInc;
		
		if (zoom > zoomMax) {
			zoom = zoomMax;
		}
	}
	
	public void decrementZoom() {
		zoom -= zoomInc;
		
		if (zoom < zoomMin) {
			zoom = zoomMin;
		}
	}
	
	public void updateCamera() {	
		GameRenderer.instance.camera.position.set(position.y, position.x, 0);
		GameRenderer.instance.camera.zoom = zoom;
	}
}
