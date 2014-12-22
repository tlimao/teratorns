package com.teratorns.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.game.GameRenderer;
import com.teratorns.interaction.Interactor;

/** This a example */
public class TeratornsLogoObject extends GameObject implements Interactor<Rectangle> {

	private Rectangle interactionRect;
	
	public TeratornsLogoObject(float x, float y) {
		super(x, y);
		/* you need to adjust the dimensions (Width & Height) of the object 
		 * in proportion to the size of the corresponding sprite */
		height = ((float) AssetsLoader.instance.teratorns.getRegionHeight()) / AssetsLoader.instance.teratorns.getRegionWidth();
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
	public void setPosition(float x, float y) {
		/* Remember that by moving the the rectangle of interaction (interactRect) 
		 * should follow the movement */
		super.setPosition(x, y);
		interactionRect.setPosition(x, y);
	}
	
	@Override
	public void setPosition(Vector2 pos) {
		super.setPosition(pos);
		interactionRect.setPosition(pos);
	}

	@Override
	public void draw() {
		GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.teratorns, 
												  position.x , position.y , 
												  width /2   , height /2  ,
												  width      , height     ,
												  1          , 1          ,
												  rotation);
	}
	
	@Override
	public void setScale(float scl) {
		super.setScale(scl);
		interactionRect.setSize(width, height);
	}
}
