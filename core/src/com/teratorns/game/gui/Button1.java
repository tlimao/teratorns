package com.teratorns.game.gui;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.teratorns.game.GameRenderer;
import com.teratorns.gui.Button;

public class Button1 extends Button {

	public Button1(float x, float y, float w, float h) {
		super(x, y, w, h);
	}

	@Override
	public void doAction() {
		System.out.println(tag + " Clicked!!");
	}

	@Override
	public void draw() {
		GameRenderer.instance.shapeRenderer.begin(ShapeType.Filled);
		GameRenderer.instance.shapeRenderer.setColor(0, 1, 0, 1);
		GameRenderer.instance.shapeRenderer.rect(position.x, position.y, width, height);
		GameRenderer.instance.shapeRenderer.end();
	}
}
