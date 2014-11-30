package com.teratorns.objects;

import com.badlogic.gdx.math.Vector2;
import com.teratorns.game.GameClock;

public class Ball extends GameObject {

	private Vector2 aimPoint;
	
	public Ball(float x, float y) {
		super(x, y);
	}

	@Override
	public void update() {
		if (position.dst(aimPoint) >= velocity.cpy().scl(GameClock.instance.getDelta()).len()) {
			position.set(aimPoint);
		} else {
			position.add(velocity.cpy().scl(GameClock.instance.getDelta()));
		}
	}

	@Override
	public void draw() {
		
	}

	public void setAimPoint(Vector2 point) {
		aimPoint.set(point);
	}
	
	public void setAimPoint(float x, float y) {
		aimPoint.set(x, y);
	}
} 
