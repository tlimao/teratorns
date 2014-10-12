package com.teratorns.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.teratorns.assets.AssestsLoader;
import com.teratorns.game.GameRenderer;
import com.teratorns.interaction.ActionListener;

public class TextArea implements GuiElement {

	private Container parent;
	private String tag;
	private String text;
	private boolean isVisible;
	private Color textColor;
	private float textScale;
	private Vector2 textPadding;
	protected Vector2 position;
	protected Vector2 localPosition;
	private float width;
	private float height;
	
	public TextArea() {
		position = new Vector2(0, 0);
		localPosition = new Vector2(0, 0);
		width = 0;
		height = 0;
		isVisible = true;
		textPadding = new Vector2(0, 0);
		textColor = new Color(Color.WHITE);
		textScale = 0.25f;
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
		AssestsLoader.instance.kenneyFont.setColor(textColor);
		AssestsLoader.instance.kenneyFont.setScale(textScale);
		Vector2 pos = getPosition().add(textPadding);
		AssestsLoader.instance.kenneyFont.draw(GameRenderer.instance.spriteRenderer, text, pos.x, pos.y);
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
		notifyParent();
	}
	
	@Override
	public void setWidth(float width) {
		this.width = width;
		notifyParent();
	}
	
	@Override
	public void setHeight(float height) {
		this.height = height;
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
		textPadding.set(x, y);
		notifyParent();
	}

	@Override
	public void notifyParent() {
		if (parent != null) {
			((Container) parent).childChanged();
		}
	}

	@Override
	public void setActionListener(ActionListener listener) {
		// TODO Auto-generated method stub
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public Vector2 getPosition() {
		return position.cpy();
	}
}
