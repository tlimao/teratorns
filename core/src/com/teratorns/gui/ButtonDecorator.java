package com.teratorns.gui;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.teratorns.interaction.ActionListener;

public abstract class ButtonDecorator extends Button {

	protected Button decoratedButton;
	
	public ButtonDecorator(Button button) {
		super(button.getPosition().x, button.getPosition().y, button.getWidth(), button.getHeight());
		
		decoratedButton = button;
	}
	
	@Override
	public void setVisible(boolean value) {
		decoratedButton.setVisible(value);
	}
	
	@Override
	public boolean isVisible() {
		return decoratedButton.isVisible();
	}
	
	@Override
	public boolean isTouched(Rectangle obj) {
		return decoratedButton.isTouched(obj);
	}
	
	@Override
	public void setActionListener(ActionListener listener) {
		decoratedButton.setActionListener(listener);
	}
	
	@Override
	public void drawInteractor() {
		decoratedButton.drawInteractor();
	}
	
	@Override
	public void setTag(String tag) {
		decoratedButton.setTag(tag);
	}

	@Override
	public String getTag() {
		return decoratedButton.getTag();
	}
	
	@Override
	public void parentTo(Container parent) {
		decoratedButton.parentTo(parent);
	}
	
	public void updatePosition(Vector2 position) {
		decoratedButton.updatePosition(position);
	}
	
	@Override
	public Vector2 getPosition() {
		return decoratedButton.getPosition();
	}
	
	@Override
	public void setPosition(float x, float y) {
		decoratedButton.setPosition(x, y);
	}
	
	@Override
	public void setPosition(Vector2 position) {
		decoratedButton.setPosition(position);
	}
	
	@Override
	public void setDimensions(float width, float height) {
		decoratedButton.setDimensions(width, height);
	}
	
	@Override
	public void setWidth(float width) {
		decoratedButton.setWidth(width);
	}
	
	@Override
	public void setHeight(float height) {
		decoratedButton.setHeight(height);
	}
	
	@Override
	public float getWidth() {
		return decoratedButton.getWidth();
	}
	
	@Override
	public float getHeight() {
		return decoratedButton.getHeight();
	}
	
	@Override
	public void setPadding(float x, float y) {
		decoratedButton.setPadding(x, y);
		decoratedButton.notifyParent();
	}
	
	@Override
	public void notifyParent() {
		decoratedButton.notifyParent();
	}
}
