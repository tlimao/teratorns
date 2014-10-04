package com.teratorns.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.teratorns.game.GameRenderer;
import com.teratorns.interaction.Interactor;

public abstract class Button implements GuiElement, Interactor<Rectangle> {
	
	protected GuiElement parent;
	protected String tag;
	protected Rectangle interactionRect;
	protected boolean isVisible;
	protected Vector2 position;
	protected float width;
	protected float height;
	
	public Button(float x, float y, float w, float h) {
		position = new Vector2(x, y);
		width = w;
		height = h;
		isVisible = true;
		interactionRect = new Rectangle(x, y, w, h);
	}
	
	@Override
	public void setVisible(boolean value) {
		isVisible = value;
	}
	
	@Override
	public boolean isVisible() {
		return isVisible;
	}
	
	@Override
	public boolean isTouched(Rectangle obj) {
		return interactionRect.overlaps(obj);
	}
	
	@Override
	public void drawInteractor() {
		GameRenderer.instance.shapeRenderer.begin(ShapeType.Line);
		GameRenderer.instance.shapeRenderer.setColor(Color.RED);
		GameRenderer.instance.shapeRenderer.rect(interactionRect.x, interactionRect.y, interactionRect.width, interactionRect.height);
		GameRenderer.instance.shapeRenderer.end();
	}
	
	@Override
	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String getTag() {
		return tag;
	}
	
	@Override
	public void parrentTo(Container parent) {
		this.parent = parent;
		
		position.set(parent.getFreePosition().cpy().add(position));
		interactionRect.setPosition(position);
	}
	
	@Override
	public Vector2 getPosition() {
		return position;
	}
	
	@Override
	public void setPosition(float x, float y) {
		position.set(x, y);
	}
	
	@Override
	public void setPosition(Vector2 position) {
		this.position.set(position);
	}
	
	@Override
	public void setDimensions(float width, float height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void setWidth(float width) {
		this.width = width;
	}
	
	@Override
	public void setHeight(float height) {
		this.height = height;
	}
	
	@Override
	public float getWidth() {
		return width;
	}
	
	@Override
	public float getHeight() {
		return height;
	}
}
