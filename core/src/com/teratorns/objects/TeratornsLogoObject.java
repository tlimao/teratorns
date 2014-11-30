package com.teratorns.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.game.GameRenderer;
import com.teratorns.interaction.Interactor;

/** This a example */
public class TeratornsLogoObject extends GameObject implements Interactor<Rectangle> {

	private Rectangle interactionRect;
	
	public TeratornsLogoObject(float x, float y) {
		super(x, y);
		interactionRect = new Rectangle(x, y, width, height);
	}
	
	public TeratornsLogoObject(float x, float y, float s) {
		super(x, y, s);
		interactionRect = new Rectangle(x, y, width, height);
	}

	@Override
	public boolean isTouched(Rectangle obj) {
		if (interactionRect.overlaps(obj)) {
			AssetsLoader.instance.click.play(5f);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void drawInteractor() {
		GameRenderer.instance.shapeRenderer.begin(ShapeType.Line);
		GameRenderer.instance.shapeRenderer.setColor(Color.CYAN);
		GameRenderer.instance.shapeRenderer.rect(interactionRect.x, interactionRect.y, 
												 interactionRect.width, interactionRect.height);
		GameRenderer.instance.shapeRenderer.end();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.teratorns, 
												  position.x, position.y, 
												  width, height);
	}
	
	@Override
	public void setScale(float scl) {
		super.setScale(scl);
		
		interactionRect.setSize(width, height);
	}
}
