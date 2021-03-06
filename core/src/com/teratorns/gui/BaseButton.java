package com.teratorns.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.game.GameRenderer;

public class BaseButton extends Button {

	private Color baseColor;
	
	public BaseButton(float x, float y, float w, float h) {
		super(x, y, w, h);
		baseColor = Color.WHITE;
	}

	@Override
	public void draw() {
		Vector2 pos = getPosition();
		GameRenderer.instance.spriteRenderer.setColor(baseColor);
		GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.baseColor, pos.x, pos.y, width, height);
		GameRenderer.instance.spriteRenderer.setColor(Color.WHITE);
	}
	
	public void setColor(float r, float g, float b, float a) {
		baseColor= new Color(r, g, b, a);
	}
	
	public void setColor(Color color) {
		baseColor = new Color(color);
	}
}
