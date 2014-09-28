package com.teratorns.helpers;

import com.badlogic.gdx.math.Vector3;
import com.teratorns.game.GameRenderer3D;

public class CameraHelper3D {
	public static CameraHelper3D instance = new CameraHelper3D();
	
	private Vector3 position;
	private Vector3 lookAt;
	private float near;
	private float far;
	
	private CameraHelper3D() {
		position = new Vector3(1, 1, 1);
		lookAt = new Vector3(0, 0, 0);
		near = 1.0f;
		far = 300.0f;
	}
	
	public void setPosition(float x, float y, float z) {
		position.set(x, y, z);
	}
	
	public void setPosition(Vector3 pos) {
		position.set(pos);
	}
	
	public void incrementZoom() {
		
	}
	
	public void decrementZoom() {
		
	}
	
	public void updateCamera() {	
		//GameRenderer3D.instance.camera.position.set(position.cpy());
		GameRenderer3D.instance.camera.lookAt(lookAt);
		GameRenderer3D.instance.camera.near = near;
		GameRenderer3D.instance.camera.far = far;
		GameRenderer3D.instance.camera.rotateAround(Vector3.Zero, new Vector3(0,1,0), 1f);
		GameRenderer3D.instance.camera.update();
	}
}
