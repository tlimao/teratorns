package com.teratorns.gui;

import com.badlogic.gdx.math.Vector2;
import com.teratorns.interaction.ActionListener;

public interface GuiElement {
	public static enum alignment {LEFT, RIGHT, TOP, BOTTOM, CENTER};
	
	public void setTag(String tag);
	public String getTag();
	public void setVisible(boolean value);
	public boolean isVisible();
	public void draw();
	public void parentTo(Container parent);
	public void setPosition(float x, float y);
	public void setPosition(Vector2 position);
	public Vector2 getPosition();
	public void setDimensions(float width, float height);
	public void setWidth(float width);
	public void setHeight(float height);
	public float getWidth();
	public float getHeight();
	public void setPadding(float x, float y);
	public void notifyParent();
	public void setActionListener(ActionListener listener);
}
