package com.teratorns.game.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.teratorns.assets.AssestsLoader;
import com.teratorns.game.GameRenderer;
import com.teratorns.gui.Button;

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
		AssestsLoader.instance.kenneyFont.setColor(textColor);
		AssestsLoader.instance.kenneyFont.setScale(textScale);
		Vector2 pos = getPosition().add(textPadding);
		AssestsLoader.instance.kenneyFont.draw(GameRenderer.instance.spriteRenderer, text, pos.x, pos.y);
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
}
