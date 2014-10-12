package com.teratorns.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.teratorns.game.GameRenderer;
import com.teratorns.interaction.ActionListener;
import com.teratorns.interaction.Interactor;

public abstract class Button implements GuiElement, Interactor<Rectangle> {
	
	protected GuiElement parent;
	protected String tag;
	protected Rectangle interactionRect;
	protected boolean isVisible;
	protected Vector2 position;
	protected Vector2 localPosition;
	protected float width;
	protected float height;
	protected Vector2 padding;
	protected ActionListener actionListener;
	
	public Button(float x, float y, float w, float h) {
		position = new Vector2(x, y);
		localPosition = new Vector2(x, y);
		width = w;
		height = h;
		isVisible = true;
		interactionRect = new Rectangle(x, y, w, h);
		padding = new Vector2(0, 0);
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
		boolean flag = interactionRect.overlaps(obj);
		
		if (flag && actionListener != null) {
			actionListener.doAction();
		}
		
		return flag;
	}
	
	@Override
	public void setActionListener(ActionListener listener) {
		actionListener = listener;
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
	public void parentTo(Container parent) {
		this.parent = parent;
		updatePosition(parent.getFreePosition());
	}
	
	public void updatePosition(Vector2 position) {
		this.position.set(position);
		this.position.add(localPosition);
		interactionRect.setPosition(this.position);
	}
	
	@Override
	public Vector2 getPosition() {
		return position.cpy();
	}
	
	@Override
	public void setPosition(float x, float y) {
		position.sub(localPosition);
		localPosition.set(x, y);
		position.add(localPosition);
		interactionRect.setPosition(position);
		notifyParent();
	}
	
	@Override
	public void setPosition(Vector2 position) {
		this.position.sub(localPosition);
		localPosition.set(position);
		this.position.add(localPosition);
		interactionRect.setPosition(this.position);
		notifyParent();
	}
	
	@Override
	public void setDimensions(float width, float height) {
		this.width = width;
		this.height = height;
		interactionRect.setSize(width, height);
		notifyParent();
	}
	
	@Override
	public void setWidth(float width) {
		this.width = width;
		interactionRect.setWidth(width);
		notifyParent();
	}
	
	@Override
	public void setHeight(float height) {
		this.height = height;
		interactionRect.setHeight(height);
		notifyParent();
	}
	
	@Override
	public float getWidth() {
		return width;
	}
	
	@Override
	public float getHeight() {
		return height;
	}
	
	@Override
	public void setPadding(float x, float y) {
		padding.set(x, y);
		notifyParent();
	}
	
	@Override
	public void notifyParent() {
		if (parent != null) {
			((Container) parent).childChanged();
		}
	}
}
