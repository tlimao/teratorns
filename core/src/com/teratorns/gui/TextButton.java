package com.teratorns.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.game.GameRenderer;

public class TextButton extends ButtonDecorator {

	private Vector2 textPadding;
	private float textScale;
	private Color textColor;
	private String text;
	
	public TextButton(Button button) {
		super(button);
		textPadding = new Vector2(0, 0);
		text = "Text Button";
		textColor = Color.BLACK;
		textScale = 1.0f;
	}

	@Override
	public void draw() {
		decoratedButton.draw();
		AssetsLoader.instance.kenneyFont.setColor(textColor);
		AssetsLoader.instance.kenneyFont.setScale(textScale);
		Vector2 pos = getPosition().add(textPadding);
		AssetsLoader.instance.kenneyFont.draw(GameRenderer.instance.spriteRenderer, text, pos.x, pos.y);
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setTextPadding(float x, float y) {
		textPadding.set(x, y);
	}
	
	public void setColor(Color color) {
		textColor = color;
	}
	
	public void setColor(float r, float g, float b, float a) {
		textColor.set(r, g, b, a);
	}
	
	public void setScale(float scale) {
		textScale = scale;
	}
	
	@Override
	public boolean isTouched(Rectangle obj) {
		return super.isTouched(obj);
	}
}
