package com.teratorns.objects;

import com.badlogic.gdx.math.Rectangle;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.game.GameRenderer;
import com.teratorns.interaction.Interactor;

/** This a example */
public class TeratornsLogoObject extends GameObject implements Interactor<Rectangle> {

	public TeratornsLogoObject(float x, float y) {
		super(x, y);
		scale = 6f;
	}

	@Override
	public boolean isTouched(Rectangle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void drawInteractor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.teratorns,
												  position.x , position.y,
												  width / 2  , height / 2,
												  width      , height    ,
												  scale      , scale     ,
												  0);
	}
}
