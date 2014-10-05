package com.teratorns.game.gui;

import com.badlogic.gdx.math.Vector2;
import com.teratorns.assets.AssestsLoader;
import com.teratorns.game.GameOptions;
import com.teratorns.game.GameRenderer;
import com.teratorns.gui.Button;

public class BlueButton extends Button {

	private int size;
	
	public BlueButton(float x, float y, float w, float h) {
		super(x, y, w, h);
		
		size = ((int) (w - AssestsLoader.instance.buttonBlueLeft.getRegionWidth()
						 - AssestsLoader.instance.buttonBlueRight.getRegionWidth()))
						 / AssestsLoader.instance.buttonBlueMiddle.getRegionWidth();
		
		if (size == 0) {
			size = 3;
		}
	}

	@Override
	public void doAction() {
		System.out.println(tag + " Clicked!!");
		GameOptions.instance.resume();
	}

	@Override
	public void draw() {
		Vector2 pos = position.cpy();
		
		GameRenderer.instance.spriteRenderer.draw(AssestsLoader.instance.buttonBlueLeft, pos.x, pos.y);
		
		pos.add(AssestsLoader.instance.buttonBlueLeft.getRegionWidth(), 0);
		
		for (int i = 0; i < size; i++) {
			GameRenderer.instance.spriteRenderer.draw(AssestsLoader.instance.buttonBlueMiddle, pos.x, pos.y);
			pos.add(AssestsLoader.instance.buttonBlueMiddle.getRegionWidth(), 0);
		}
		
		GameRenderer.instance.spriteRenderer.draw(AssestsLoader.instance.buttonBlueRight, pos.x, pos.y);
	}
}
