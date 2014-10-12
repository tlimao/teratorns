package com.teratorns.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.teratorns.game.GameRenderer;

public class ImageButton extends ButtonDecorator {

	private TextureRegion image;
	private Vector2 imagePadding;
	private float scale;
	
	public ImageButton(TextureRegion image) {
		super(new BaseButton(0, 0, 0, 0));
		scale = 1.0f;
		imagePadding = new Vector2(0, 0);
		setImage(image);
	}

	@Override
	public void draw() {
		Vector2 pos = decoratedButton.getPosition();
		pos.add(imagePadding);
		GameRenderer.instance.spriteRenderer.draw(image, pos.x, pos.y);
	}

	public void setImage(TextureRegion image) {
		this.image = image;
		decoratedButton.setDimensions(image.getRegionWidth(), image.getRegionHeight());
	}
	
	public void setScale(float imageScale) {
		scale = imageScale;
		decoratedButton.setDimensions(width * scale, height * scale);
	}
	
	public void setImagePadding(float dx, float dy) {
		imagePadding.set(dx, dy);
	}
}
