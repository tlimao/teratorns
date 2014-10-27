package com.teratorns.objects;

import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {
	
	protected Vector2 position;
	protected Vector2 velocity;
	protected Vector2 acceleration;
	protected float width;
	protected float height;
	protected float rotation;
	
	public GameObject(float x, float y) {
		width = .3f;
		height = .3f;
		rotation = 0;
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 0);
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

	public abstract void update();
	
	public abstract void draw();
}
