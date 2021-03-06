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

	public static enum ContainerAlignment {VERTICAL, HORIZONTAL};
	protected ContainerAlignment align;
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
	@SuppressWarnings("unused")
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
		padding = new Vector2(0, 0);
		align = ContainerAlignment.HORIZONTAL;
	}
	
	public void setAlignment(ContainerAlignment containerAlign) {
		align = containerAlign;
	}
	
	public void addGuiElement(GuiElement element) {
		element.parentTo(this);
		guiElements.add(element);
		
		if (align.equals(ContainerAlignment.HORIZONTAL)) {
			freePosition.x = element.getPosition().x + element.getWidth() + padding.x;
			if (Math.abs(freePosition.x - position.x) >= width) {
				setWidth(Math.abs(freePosition.x - position.x) + padding.x);
			}
			float ly = Math.abs(element.getPosition().y + element.getHeight() + padding.y - position.y);
			if (ly >= height) {
				setHeight(ly);
			}
		} else if (align.equals(ContainerAlignment.VERTICAL)) {
			freePosition.y = element.getPosition().y + element.getHeight() + padding.y;
			if (Math.abs(freePosition.y - position.y) >= height) {
				setHeight(Math.abs(freePosition.y - position.y));
			}

			float lx = Math.abs(element.getPosition().x + element.getWidth() + padding.x - position.x);
			if (lx >= width) {
				setWidth(lx);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean isTouched(Rectangle obj) {
		boolean flag = interactionRect.overlaps(obj);
		
		if (flag) {
			for (GuiElement element : guiElements) {
				if (element instanceof Interactor<?>) {
					if (((Interactor<Rectangle>) element).isTouched(obj))
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
		GameRenderer.instance.shapeRenderer.setColor(Color.BLUE);
		GameRenderer.instance.shapeRenderer.rect(interactionRect.x, interactionRect.y, interactionRect.width, interactionRect.height);
		GameRenderer.instance.shapeRenderer.end();
		
		if (guiElements.size > 0) {
			for (GuiElement element : guiElements) {
				if (element.isVisible() && element instanceof Interactor<?>) {
					((Interactor<?>) element).drawInteractor();
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
	public void parentTo(Container parent) {
		this.parent = parent;
		position.set(parent.getFreePosition().add(localPosition));
		interactionRect.setPosition(position);
		freePosition.set(position.cpy().add(padding));
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
		freePosition.add(padding);
		
		for (GuiElement element : guiElements) {
			element.parentTo(this);
			
			if (align.equals(ContainerAlignment.HORIZONTAL)) {
				freePosition.x = element.getPosition().x + element.getWidth() + padding.x;
			} else if (align.equals(ContainerAlignment.VERTICAL)) {
				freePosition.y = element.getPosition().y + element.getHeight() + padding.y;
			}
		}
	}
	
	@Override
	public void setPadding(float x, float y) {
		freePosition.sub(padding);
		padding.set(x, y);
		freePosition.add(padding);
	}
	
	public void childChanged() {
		updateGuiChilds();
	}
	
	@Override
	public void notifyParent() {
		((Container) parent).childChanged();
	}
}

