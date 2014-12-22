package com.teratorns.game.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.game.GameClock;
import com.teratorns.game.GameRenderer;
import com.teratorns.interaction.Interactor;
import com.teratorns.objects.GameObject;

public class FireSkull extends GameObject implements Interactor<Rectangle> {

	private Rectangle interactionRect;
	private Vector2 aim;
	private boolean isAdjusted;
	
	public FireSkull(float x, float y) {
		super(x, y);
		interactionRect = new Rectangle(x, y, width, height);
		aim = position.cpy();
		isAdjusted = false;
	}

	@Override
	public void update() {
		velocity.set(aim.cpy().sub(position.cpy().add(width/2, height/2)));
		position.add(velocity.cpy().scl(GameClock.instance.getDelta()));
		interactionRect.setPosition(position);
	}
	
	public void setAim(float x, float y) {
		aim.set(x, y);
	}
	
	public void setAim(Vector2 a) {
		aim.set(a);
	}

	@Override
	public void draw() {
		TextureRegion tx;
		
		if (aim.x >= position.x + width / 2) {
			tx = AssetsLoader.instance.fire_skull_animation_right.getKeyFrame(GameClock.instance.getRunTime());
		} else {
			tx = AssetsLoader.instance.fire_skull_animation_left.getKeyFrame(GameClock.instance.getRunTime());
		}
		
		if (!isAdjusted) {
			height *= ((float) tx.getRegionHeight()) / tx.getRegionWidth();
		}
		
		GameRenderer.instance.spriteRenderer.setColor(1, 1, 0, 0.5f);
		
		GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.light_effect,
										   		  position.x , position.y,
										   		  width / 2  , height / 2,
										   		  width      , height    ,
										   		  scale      , scale     ,
										   		  rotation);
		
		GameRenderer.instance.spriteRenderer.setColor(1, 1, 1, 1);
		
		GameRenderer.instance.spriteRenderer.draw(tx					 ,
										   		  position.x , position.y,
										   		  width / 2  , height / 2,
										   		  width      , height    ,
										   		  scale      , scale     ,
										   		  rotation);
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
	public void setScale(float scl) {
		super.setScale(scl);
		
		interactionRect.setSize(width, height);
	}
}
