package com.teratorns.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.teratorns.game.GameRenderer;
import com.teratorns.interaction.ActionListener;

public class Image implements GuiElement{

	private GuiElement parent;
	private String tag;
	private boolean isVisible;
	private Vector2 position;
	private float scale;
	private Vector2 localPosition;
	private float width;
	private float height;
	private Vector2 padding;
	private ActionListener actionListener;
	private TextureRegion texture;
	
	public Image(TextureRegion texture, float x, float y, float w, float h) {
		this.texture = texture;
		position = new Vector2(x, y);
		scale = 1.0f;
		localPosition = new Vector2(x, y);
		width = w;
		height = h;
		isVisible = true;
		padding = new Vector2(0, 0);
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
	public void setVisible(boolean value) {
		isVisible = value;
	}

	@Override
	public boolean isVisible() {
		return isVisible;
	}

	@Override
	public void draw() {
		Vector2 pos = getPosition();
		pos.add(padding);
		
		GameRenderer.instance.spriteRenderer.draw(texture,
												  pos.x, pos.y,
												  0, 0,
												  width, height,
												  scale, scale,
												  0);
		GameRenderer.instance.spriteRenderer.setColor(Color.WHITE);
	}
	
	@Override
	public void parentTo(Container parent) {
		this.parent = parent;
		updatePosition(parent.getFreePosition());
	}
	
	public void updatePosition(Vector2 position) {
		this.position.set(position);
		this.position.add(localPosition);
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
		notifyParent();
	}
	
	@Override
	public void setPosition(Vector2 position) {
		this.position.sub(localPosition);
		localPosition.set(position);
		this.position.add(localPosition);
		notifyParent();
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

	@Override
	public void setPadding(float x, float y) {
		padding.scl(x, y);
	}

	@Override
	public void notifyParent() {
		if (parent != null) {
			((Container) parent).childChanged();
		}
	}

	@Override
	public void setActionListener(ActionListener listener) {
		actionListener = listener;
	}
}
