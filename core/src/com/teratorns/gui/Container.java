package com.teratorns.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.teratorns.game.GameRenderer;
import com.teratorns.interaction.ActionListener;
import com.teratorns.interaction.Interactor;

public abstract class Container implements GuiElement, Interactor<Rectangle> {
	
	protected GuiElement parent;
	protected Vector2 padding;
	protected String tag;
	protected boolean isVisible;
	protected Rectangle interactionRect;
	protected Vector2 position;
	protected Vector2 localPosition;
	protected float width;
	protected float height;
	protected Vector2 freePosition;
	private ActionListener actionListener;
	
	private Array<GuiElement> guiElements;
	
	public Container(float x, float y, float w, float h) {
		isVisible = true;
		position = new Vector2(x, y);
		localPosition = new Vector2(x, y);
		width = w;
		height = h;
		guiElements = new Array<GuiElement>();
		interactionRect = new Rectangle(x, y, w, h);
		freePosition = new Vector2(x, y);
		padding = new Vector2(10, 10);
	}
	
	public void addGuiElement(GuiElement element) {
		element.parrentTo(this);
		guiElements.add(element);
		freePosition.set(freePosition.add(element.getWidth() + padding.x, 0));
	}
	
	@Override
	public boolean isTouched(Rectangle obj) {
		boolean flag = interactionRect.overlaps(obj);
		
		if (flag) {
			for (GuiElement element : guiElements) {
				if (element instanceof Interactor<?>) {
					if (((Interactor) element).isTouched(obj))
					{
						break;
					}
				}
			}
		}
			
		return flag;
	}
	
	@Override
	public void setActionListener(ActionListener listener) {
		actionListener = listener;
	}
	
	@Override
	public void draw() {
		for (GuiElement element : guiElements) {
			if (element.isVisible()) {
				element.draw();
			}
		}
	}
	
	@Override
	public void drawInteractor() {
		GameRenderer.instance.shapeRenderer.begin(ShapeType.Line);
		GameRenderer.instance.shapeRenderer.setColor(Color.RED);
		GameRenderer.instance.shapeRenderer.rect(interactionRect.x, interactionRect.y, interactionRect.width, interactionRect.height);
		GameRenderer.instance.shapeRenderer.end();
		
		if (guiElements.size > 0) {
			for (GuiElement element : guiElements) {
				if (element.isVisible() && element instanceof Interactor<?>) {
					((Interactor<Rectangle>) element).drawInteractor();
				}
			}
		}
	}
	
	@Override
	public boolean isVisible() {
		return isVisible;
	}
	
	@Override
	public void setVisible(boolean value) {
		isVisible = value;
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
		
		position.set(parent.getFreePosition().cpy().add(localPosition));
		interactionRect.setPosition(position);
		
		freePosition.set(position.cpy().add(padding.x, 0));
		
		updateGuiChilds();
	}
	
	@Override
	public Vector2 getPosition() {
		return position.cpy();
	}
	
	@Override
	public void setPosition(float x, float y) {
		position.set(x, y);
		if (parent != null) {
			this.position.add(localPosition);
		}
		interactionRect.setPosition(position);
		updateGuiChilds();
	}
	
	@Override
	public void setPosition(Vector2 position) {
		this.position.set(position);
		if (parent != null) {
			this.position.add(localPosition);
		}
		interactionRect.setPosition(this.position);
		updateGuiChilds();
	}
	
	public Vector2 getFreePosition() {
		return freePosition.cpy();
	}
	
	@Override
	public void setDimensions(float width, float height) {
		this.width = width;
		this.height = height;
		interactionRect.setSize(width, height);
	}
	
	@Override
	public void setWidth(float width) {
		this.width = width;
		interactionRect.setWidth(width);
	}
	
	@Override
	public void setHeight(float height) {
		this.height = height;
		interactionRect.setHeight(height);
	}
	
	@Override
	public float getWidth() {
		return width;
	}
	
	@Override
	public float getHeight() {
		return height;
	}
	
	private void updateGuiChilds() {
		freePosition = getPosition();
		
		for (GuiElement element : guiElements) {
			element.parrentTo(this);
			freePosition.set(freePosition.set(element.getPosition().x + element.getWidth() + padding.x, freePosition.y));
		}
	}
	
	@Override
	public void setPadding(float x, float y) {
		padding.set(x, y);
	}
	
	public void childChanged() {
		updateGuiChilds();
	}
	
	@Override
	public void notifyParent() {
		((Container) parent).childChanged();
	}
}
