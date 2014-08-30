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
		
		interactor = new Interactor(this, width, height);
	}
	
	public class Interactor {
		
		private Rectangle interactionRect;
		private Vector2 offset;
		private GameObject parent;
		
		public Interactor(GameObject gameObject, float width, float height) {
			parent = gameObject;
			offset = new Vector2(0, 0);
			interactionRect = new Rectangle(position.x, position.y, width, height);
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
			
			offset.set(parent.width - width, parent.height - height);
			
			interactionRect.setPosition(position.cpy().add(offset));
		}
		
		public void updatePosition() {
			interactionRect.setPosition(position.cpy().add(offset));
		}
	}
	
	public Vector2 getPosition() {
		return position.cpy();
	}
	
	public void setPosition(float x, float y) {
		position.set(x, y);
		interactor.updatePosition();
	}
	
	public void setPosition(Vector2 pos) {
		position.set(pos);
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
