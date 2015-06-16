package com.teratorns.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.game.GameRenderer;

public class BaseContainer extends Container {
	private Color baseColor;
	
	public BaseContainer(float x, float y) {
		super(x, y, 0, 0);
		baseColor = new Color(Color.LIGHT_GRAY);
	}
	
	public BaseContainer(float x, float y, float w, float h) {
		super(x, y, w, h);
		baseColor = new Color(Color.LIGHT_GRAY);
	}
	
	@Override
	public void draw() {
		Vector2 pos = getPosition();
		GameRenderer.instance.spriteRenderer.setColor(baseColor);
		GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.baseColor, pos.x, pos.y, width, height);
		GameRenderer.instance.spriteRenderer.setColor(Color.WHITE);
		super.draw();
	}

	public void setColor(float r, float g, float b, float a) {
		baseColor = new Color(r, g, b, a);
	}
	
	public void setColor(Color color) {
		baseColor = new Color(color);
	}
}
