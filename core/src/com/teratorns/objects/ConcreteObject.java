package com.teratorns.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.teratorns.game.GameRenderer;
import com.teratorns.interaction.Interactor;

public class ConcreteObject extends GameObject implements Interactor<Rectangle> {

	private Rectangle interactionRect;
	private Color color;
	
	public ConcreteObject(float x, float y) {
		super(x, y);
		
		interactionRect = new Rectangle(x, y, width, height);
		color = Color.RED;
	}

	@Override
	public boolean isTouched(Rectangle rect) {
		
		if (interactionRect.overlaps(rect)) {
			color = Color.GREEN;
			System.out.println("FFF");
			return true;
		}
		
		color = Color.RED;
		
		return false;	
	}

	@Override
	public void drawInteractor() {
		GameRenderer.instance.shapeRenderer.begin(ShapeType.Line);
		GameRenderer.instance.shapeRenderer.setColor(color);
		GameRenderer.instance.shapeRenderer.rect(interactionRect.x, interactionRect.y, interactionRect.width, interactionRect.height);
		GameRenderer.instance.shapeRenderer.end();
	}

	@Override
	public void update() {
		interactionRect.setPosition(position);
	}

	@Override
	public void draw() {
		
	}

}
