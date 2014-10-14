package com.teratorns.game.gui;

import com.badlogic.gdx.math.Vector2;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.game.GameRenderer;
import com.teratorns.gui.Button;

public class BlueButton extends Button {

	private int size;
	
	public BlueButton(float x, float y, float w, float h) {
		super(x, y, w, h);
		
		size = ((int) (w - AssetsLoader.instance.buttonBlueLeft.getRegionWidth()
						 - AssetsLoader.instance.buttonBlueRight.getRegionWidth()))
						 / AssetsLoader.instance.buttonBlueMiddle.getRegionWidth();
		
		if (size == 0) {
			size = 3;
		}
	}

	@Override
	public void draw() {
		Vector2 pos = getPosition();
		
		GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.buttonBlueLeft, pos.x, pos.y);
		
		pos.add(AssetsLoader.instance.buttonBlueLeft.getRegionWidth(), 0);
		
		for (int i = 0; i < size; i++) {
			GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.buttonBlueMiddle, pos.x, pos.y);
			pos.add(AssetsLoader.instance.buttonBlueMiddle.getRegionWidth(), 0);
		}
		
		GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.buttonBlueRight, pos.x, pos.y);
	}
}
