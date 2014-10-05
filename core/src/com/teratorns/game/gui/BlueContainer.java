package com.teratorns.game.gui;

import com.badlogic.gdx.math.Vector2;
import com.teratorns.assets.AssestsLoader;
import com.teratorns.game.GameRenderer;
import com.teratorns.gui.Container;

public class BlueContainer extends Container {

	private int verticalSize;
	private int horizontalSize;
	private float txWidth;
	private float txHeight;
	
	public BlueContainer(float x, float y, float w, float h) {
		super(x, y, w, h);
		txWidth = AssestsLoader.instance.panelblueTransCenter.getRegionWidth();
		txHeight = AssestsLoader.instance.panelblueTransCenter.getRegionHeight();
		horizontalSize = (int) (w / txWidth);
		verticalSize = (int) (h / txHeight);
	}

	@Override
	public void doAction() {
		System.out.println(tag + " clicked!");
	}
	
	@Override
	public void draw() {
		Vector2 pos = position.cpy();
		
		GameRenderer.instance.spriteRenderer.draw(AssestsLoader.instance.panelblueTransCornerLeftTop, pos.x, pos.y);
		
		pos.add(txWidth, 0);
		
		for (int i = 0; i < horizontalSize - 2; i++) {
			GameRenderer.instance.spriteRenderer.draw(AssestsLoader.instance.panelblueTransSideTop, pos.x, pos.y);
			
			pos.add(txWidth, 0);
		}
		
		GameRenderer.instance.spriteRenderer.draw(AssestsLoader.instance.panelblueTransCornerRightTop, pos.x, pos.y);
		
		pos.set(position.cpy().add(0, txHeight));
		
		for (int j = 0 ; j < verticalSize - 2; j++) {
			GameRenderer.instance.spriteRenderer.draw(AssestsLoader.instance.panelblueTransSideLeft, pos.x, pos.y);
			
			pos.add(txWidth, 0);
			
			for (int i = 0; i < horizontalSize - 2; i++) {
				GameRenderer.instance.spriteRenderer.draw(AssestsLoader.instance.panelblueTransCenter, pos.x, pos.y);
				
				pos.add(txWidth, 0);
			}
			
			GameRenderer.instance.spriteRenderer.draw(AssestsLoader.instance.panelblueTransSideRight, pos.x, pos.y);
			
			pos.set(position.x, pos.y + txHeight);
		}
		
		GameRenderer.instance.spriteRenderer.draw(AssestsLoader.instance.panelblueTransCornerLeftBottom, pos.x, pos.y);
		
		pos.add(txWidth, 0);
		
		for (int i = 0; i < horizontalSize - 2; i++) {
			GameRenderer.instance.spriteRenderer.draw(AssestsLoader.instance.panelblueTransSideBottom, pos.x, pos.y);
			
			pos.add(txWidth, 0);
		}
		
		GameRenderer.instance.spriteRenderer.draw(AssestsLoader.instance.panelblueTransCornerRightBottom, pos.x, pos.y);
		
		super.draw();
	}
}
