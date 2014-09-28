package com.teratorns.objects;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.math.Vector3;

public abstract class GameObject3D {
	protected Vector3 position;
	protected Vector3 velocity;
	protected Vector3 acceleration;
	protected float width;
	protected float height;
	protected float rotation;
	
	public GameObject3D(float x, float y, float z) {
		width = 1;
		height = 1;
		rotation = 0;
		position = new Vector3(x, y, z);
		velocity = new Vector3(0, 0, 0);
		acceleration = new Vector3(0, 0, 0);
	}
	
	public Vector3 getPosition() {
		return position.cpy();
	}
	
	public void setPosition(float x, float y, float z) {
		position.set(x, y, z);
	}
	
	public void setPosition(Vector3 pos) {
		position.set(pos);
	}
	
	public Vector3 getVelocity() {
		return velocity.cpy();
	}
	
	public void setVelocity(float x, float y, float z) {
		velocity.set(x, y, z);
	}
	
	public void setVelocity(Vector3 vel) {
		velocity.set(vel);
	}
	
	public Vector3 getAcceleration() {
		return acceleration.cpy();
	}
	
	public void setAcceleration(float x, float y, float z) {
		acceleration.set(x, y, z);
	}
	
	public void setAcceleration(Vector3 acc) {
		acceleration.set(acc);
	}
	
	public float getRotation() {
		return rotation;
	}
	
	public void setRotation(float rot) {
		rotation = rot;
	}

	public abstract void update();
	
	public abstract void draw();
	
	public abstract void draw(Environment environment);
	
	public abstract void dispose();
}
