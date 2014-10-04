package com.teratorns.game.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.teratorns.game.GameRenderer;
import com.teratorns.gui.Container;

public class PrimaryContainer extends Container {

	public PrimaryContainer(float x, float y, float w, float h) {
		super(x, y, w, h);
	}

	@Override
	public void doAction() {
		System.out.println(tag + " clicked!");
	}
	
	@Override
	public void draw() {
		Gdx.gl.glEnable(GL20.GL_BLEND);
		GameRenderer.instance.shapeRenderer.begin(ShapeType.Filled);
		GameRenderer.instance.shapeRenderer.setColor(0, 0, 1, 0.25f);
		GameRenderer.instance.shapeRenderer.rect(position.x, position.y, width, height);
		GameRenderer.instance.shapeRenderer.end();
		Gdx.gl.glDisable(GL20.GL_BLEND);
		
		super.draw();
	}
}
