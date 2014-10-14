package com.teratorns.gui;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.teratorns.game.GameRenderer;

public class ImageButton extends ButtonDecorator {

	private TextureRegion image;
	private Vector2 imagePadding;
	private float imageTextureWidth;
	private float imageTextureHeight;
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
		GameRenderer.instance.spriteRenderer.draw(image,
												  pos.x, pos.y,
												  0, 0,
												  imageTextureWidth, imageTextureHeight,
												  scale, scale,
												  0);
	}

	public void setImage(TextureRegion image) {
		this.image = image;
		imageTextureWidth = image.getRegionWidth();
		imageTextureHeight = image.getRegionHeight();
		decoratedButton.setDimensions(imageTextureWidth, imageTextureHeight);
	}
	
	public void setScale(float imageScale) {
		scale = imageScale;
		decoratedButton.setDimensions(imageTextureWidth * scale, imageTextureHeight * scale);
	}
	
	public void setImagePadding(float dx, float dy) {
		imagePadding.set(dx, dy);
	}
}
