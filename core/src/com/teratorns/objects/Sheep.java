package com.teratorns.objects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.teratorns.assets.AssestsLoader;
import com.teratorns.game.GameClock;
import com.teratorns.game.GameRenderer;
import com.teratorns.interaction.Interactor;

public class Sheep extends GameObject implements Interactor<Rectangle> {

	private Rectangle interactionRect;
	
	public Sheep(float x, float y) {
		super(x, y);
		interactionRect = new Rectangle(x, y, width, height);
		rotation = 0;
	}

	@Override
	public boolean isTouched(Rectangle rect) {
		if (interactionRect.overlaps(rect)) {
			AssestsLoader.instance.sheepFx.stop();
			AssestsLoader.instance.sheepFx.play(0.15f);
			return true;
		}
		
		return false;
	}

	@Override
	public void drawInteractor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		interactionRect.setPosition(position);
		rotation += 0.5f;
		
		if (rotation > 180) rotation = 0;
	}

	@Override
	public void draw() {
		TextureRegion sheepTx = (rotation < 90) ? 
								AssestsLoader.instance.sheepWalkingR.getKeyFrame(GameClock.instance.getRunTime()) :
								AssestsLoader.instance.sheepWalkingL.getKeyFrame(GameClock.instance.getRunTime());
		
		GameRenderer.instance.spriteRenderer.draw(sheepTx,
										   		  position.x  , position.y   ,
										   		  width / 2   , height / 2   ,
										   		  (int) width , (int) height ,
										   		  1           , 1            ,
										   		  0);
	}

}
