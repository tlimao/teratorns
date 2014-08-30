package com.teratorns.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import com.teratorns.game.GameRenderer;

public abstract class GameObject {
	
	protected Vector2 position;
	protected Vector2 velocity;
	protected Vector2 acceleration;
	protected Vector2 center;
	protected float width;
	protected float height;
	protected float rotation;
	protected Interactor interactor;
	
	public GameObject(float x, float y) {
		width = 1;
		height = 1;
		rotation = 0;
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 0);
		center = new Vector2(x + width / 2, y + height / 2);
		
		interactor = new Interactor(this, width, height);
	}
	
	public class Interactor {
		
		private Rectangle interactionRect;
		private GameObject parent;
		
		public Interactor(GameObject gameObject, float width, float height) {
			parent = gameObject;
			interactionRect = new Rectangle();
			interactionRect.setCenter(center);
			interactionRect.width = width;
			interactionRect.height = height;
		}
		
		public GameObject getParent() {
			return parent;
		}
		
		public boolean isTouched(Rectangle rectangle) {
			return rectangle.overlaps(interactor.interactionRect);
		}
		
		public void setSize(float width, float height) {
			interactionRect.width = width;
			interactionRect.height = height;
		}
		
		public void updatePosition() {
			interactionRect.setCenter(center);
		}
	}
	
	public Vector2 getPosition() {
		return position.cpy();
	}
	
	public void setPosition(float x, float y) {
		position.set(x, y);
		center.set(x + width / 2, y + height / 2);
		interactor.updatePosition();
	}
	
	public void setPosition(Vector2 pos) {
		position.set(pos);
		center.set(pos.x + width / 2, pos.y + height / 2);
		interactor.updatePosition();
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
	
	public Vector2 getCenter() {
		return center.cpy();
	}
	
	public void setCenter(float x, float y) {
		center.set(x, y);
		position.set(x - width / 2, y - height / 2);
		interactor.updatePosition();
	}
	
	public void setCenter(Vector2 pos) {
		center.set(pos);
		position.set(pos.x - width / 2, pos.y - height / 2);
		interactor.updatePosition();
	}
	
	public float getRotation() {
		return rotation;
	}
	
	public void setRotation(float rot) {
		rotation = rot;
	}
	
	public Interactor getInteractor() {
		return interactor;
	}

	public abstract void update(float delta);
	
	public abstract void draw(float runtime);
	
	public void drawInteractor() {
		GameRenderer.instance.shapeRenderer.begin(ShapeType.Line);
		GameRenderer.instance.shapeRenderer.setColor(Color.RED);
		GameRenderer.instance.shapeRenderer.rect(interactor.interactionRect.x, 
												 interactor.interactionRect.y, 
												 interactor.interactionRect.width, 
												 interactor.interactionRect.height);
		GameRenderer.instance.shapeRenderer.end();
	}
}
