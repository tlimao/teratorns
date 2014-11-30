package com.teratorns.utils;

import com.badlogic.gdx.math.Vector2;
import com.teratorns.helpers.CameraHelper;

public abstract class Transformations {

	private static float factor_X_screenToViewport = Constants.viewportWidth / Constants.windowWidth;
	private static float factor_Y_screenToViewport = Constants.viewportHeight / Constants.windowHeight;
	private static Vector2 viewport_half = new Vector2(Constants.viewportWidth / 2, Constants.viewportHeight / 2);
	
	public static Vector2 screenToViewport(float sX, float sY) {
		return new Vector2(sX * factor_X_screenToViewport, sY * factor_Y_screenToViewport);
	}
	
	public static Vector2 screenToViewport(Vector2 sP) {
		return sP.cpy().scl(factor_X_screenToViewport, factor_Y_screenToViewport);
	}
	
	public static Vector2 viewportToWorld(float vX, float vY) {
		return CameraHelper.instance.getPosition().add(vX, vY).sub(viewport_half);
	}
	
	public static Vector2 viewportToWorld(Vector2 vP) {
		return CameraHelper.instance.getPosition().add(vP).sub(viewport_half);
	}
	
	public static Vector2 screenToWorld(float sX, float sY) {
		return viewportToWorld(screenToViewport(sX, sY));
	}
	
	public static Vector2 screenToWorld(Vector2 sP) {
		return viewportToWorld(screenToViewport(sP));
	}
	
	public static void refactor() {
		factor_X_screenToViewport = Constants.viewportWidth / Constants.windowWidth;
		factor_Y_screenToViewport = Constants.viewportHeight / Constants.windowHeight;
		viewport_half = new Vector2(Constants.viewportWidth / 2, Constants.viewportHeight / 2);
	}
}
