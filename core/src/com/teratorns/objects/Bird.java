package com.teratorns.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.teratorns.game.GameRenderer;
import com.teratorns.interaction.Interactor;

public class Bird extends GameObject implements Interactor<Rectangle> {
	private Vector2 pBest;
	private Rectangle interactionRect;
	private Color color;
	private boolean flag;
	private Array<Vector2> path;
	private static float maxForce = 0.05f;
	private static Vector2 maxVelocity = new Vector2(3f, 3f);
	
	public Bird(float x, float y) {
		super(x, y);
		interactionRect = new Rectangle(x, y, width, height);
		color = Color.RED;
		flag = false;
		path = new Array<Vector2>();
		pBest = position.cpy();
	}

	@Override
	public boolean isTouched(Rectangle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	private float fitness() {
		return 0;
	}

	@Override
	public void drawInteractor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		GameRenderer.instance.shapeRenderer.begin(ShapeType.Filled);
		GameRenderer.instance.shapeRenderer.setColor(color);
		GameRenderer.instance.shapeRenderer.circle(position.x, position.y, 0.1f, 12);
		GameRenderer.instance.shapeRenderer.end();
		GameRenderer.instance.shapeRenderer.begin(ShapeType.Line);
		GameRenderer.instance.shapeRenderer.line(position, position.cpy().add(velocity.cpy().nor().scl(0.25f)));
		GameRenderer.instance.shapeRenderer.end();
		
		if (flag) {
			GameRenderer.instance.shapeRenderer.begin(ShapeType.Line);
			GameRenderer.instance.shapeRenderer.setColor(color);
			for (int i = 0 ; i < path.size - 1 ; i++) {
				GameRenderer.instance.shapeRenderer.line(path.get(i), path.get(i+1));
			}
			
			GameRenderer.instance.shapeRenderer.end();
		}
	}

}
