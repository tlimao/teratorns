package com.teratorns.objects;

import com.badlogic.gdx.math.Vector2;

public class ConcreteObject extends GameObject {

	public ConcreteObject(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		rotation = 0.01f;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		Vector2 aux = new Vector2((float) (position.x * Math.cos(rotation) - position.y * Math.sin(rotation)),
								  (float) (position.x * Math.sin(rotation) + position.y * Math.cos(rotation)));
		setPosition(aux);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

}
