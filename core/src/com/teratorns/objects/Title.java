package com.teratorns.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.game.GameRenderer;
import com.teratorns.interaction.Interactor;
import com.teratorns.utils.Constants;

public class Title extends GameObject implements Interactor<Rectangle> {
	private Color baseColor;
	private static Color c0 = new Color( 236/255f, 240/255f, 241/255f, 1);
	private static Color c1 = new Color( 46/255f, 204/255f, 113/255f, 1);
	private static Color c2 = new Color(241/255f, 196/255f,  15/255f, 1);
	private static Color c3 = new Color(230/255f, 126/255f,  34/255f, 1);
	private static Color c4 = new Color(231/255f,  76/255f,  60/255f, 1);
	private Rectangle interactionRect;
	int value;
	private Color textColor;
	private float textScale;
	private Vector2 textPadding;
	private Vector2 matrixIndex;
	
	public Title(float x, float y, int i, int j, float size, int value) {
		super(x, y);
		interactionRect = new Rectangle(x, y, size, size);
		width = size;
		height = size;
		baseColor = new Color(52/255f, 73/255f, 94/255f, 1);
		this.value = value;
		textPadding = new Vector2(size / 3, size / 3);
		textColor = Color.BLACK;
		textScale = 0.1f;
		matrixIndex = new Vector2(i, j);
	}
	
	public void setValue(int value) {
		this.value = value;
	}	

	@Override
	public boolean isTouched(Rectangle obj) {
		if (obj.overlaps(interactionRect)) {
			value += 1;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void drawInteractor() {
		GameRenderer.instance.shapeRenderer.begin(ShapeType.Line);
		GameRenderer.instance.shapeRenderer.setColor(Color.BLUE);
		GameRenderer.instance.shapeRenderer.rect(interactionRect.x, interactionRect.y, interactionRect.width, interactionRect.height);
		GameRenderer.instance.shapeRenderer.end();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		switch (value) {
			case 0:
				baseColor = c0;
				break;
				
			case 1:
				baseColor = c1;
				break;
							
			case 2:
				baseColor = c2;
				break;
				
			case 3:
				baseColor = c3;
				break;
				
			case 4:
				baseColor = c4;
				break;
		}
		
		Vector2 pos = getPosition();
		GameRenderer.instance.spriteRenderer.setColor(baseColor);
		GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.baseColor, pos.x, pos.y, width, height);
		GameRenderer.instance.spriteRenderer.setColor(Color.WHITE);
		/*
		AssetsLoader.instance.kenneyFont.setColor(textColor);
		AssetsLoader.instance.kenneyFont.setScale(0.2f);
		pos.add(textPadding);
		AssetsLoader.instance.kenneyFont.draw(GameRenderer.instance.spriteRenderer, Integer.toString(value), pos.x, pos.y);
		AssetsLoader.instance.kenneyFont.setScale(1);
		*/
	}
	
	public int getValue() {
		return value;
	}
	
	public Vector2 getMatrixIndex() {
		return matrixIndex.cpy();
	}

}
