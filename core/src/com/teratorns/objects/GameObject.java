package com.teratorns.objects;

import com.badlogic.gdx.math.Vector2;
import com.teratorns.utils.Constants;

public abstract class GameObject {
	
	protected Vector2 position;
	protected Vector2 velocity;
	protected Vector2 acceleration;
	protected float width;
	protected float height;
	protected float rotation;
	protected float scale;
	
	public GameObject(float x, float y) {
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 0);
		width = 1;
		height = width * Constants.aspectRatio;
		rotation = 0.0f;
		scale = 1.0f;
	}
	
	public GameObject(float x, float y, float s) {
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 0);
		width = s;
		height = s * Constants.aspectRatio;
		rotation = 0.0f;
		scale = 1.0f;
	}
	
	public Vector2 getPosition() {
		return position.cpy();
	}
	
	public void setPosition(float x, float y) {
		position.set(x, y);
	}
	
	public void setPosition(Vector2 pos) {
		position.set(pos);
	}
	
	public Vector2 getVelocity() {
		return velocity.cpy();
	}
	
	public void setVelocity(float x, float y) {
		velocity.set(x, y);
	}
	
	public void setVelocity(Vector2 vel) {
		velocity.set(vel);
	}
	
	public Vector2 getAcceleration() {
		return acceleration.cpy();
	}
	
	public void setAcceleration(float x, float y) {
		acceleration.set(x, y);
	}
	
	public void setAcceleration(Vector2 acc) {
		acceleration.set(acc);
	}
	
	public float getRotation() {
		return rotation;
	}
	
	public void setRotation(float rot) {
		rotation = rot;
	}
	
	public float getScale() {
		return scale;
	}
	
	public void setScale(float scl) {
		scale = scl;
		width *= scale;
		height *= scale;
	}

	public abstract void update();
	
	public abstract void draw();
}
