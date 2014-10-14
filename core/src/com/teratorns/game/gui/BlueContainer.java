package com.teratorns.game.gui;

import com.badlogic.gdx.math.Vector2;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.game.GameRenderer;
import com.teratorns.gui.Container;

public class BlueContainer extends Container {

	private int verticalSize;
	private int horizontalSize;
	private float txWidth;
	private float txHeight;
	
	public BlueContainer(float x, float y, float w, float h) {
		super(x, y, w, h);
		txWidth = AssetsLoader.instance.panelblueTransCenter.getRegionWidth();
		txHeight = AssetsLoader.instance.panelblueTransCenter.getRegionHeight();
		horizontalSize = (int) (w / txWidth);
		verticalSize = (int) (h / txHeight);
	}
	
	@Override
	public void draw() {
		Vector2 pos = position.cpy();
		
		GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.panelblueTransCornerLeftTop, pos.x, pos.y);
		
		pos.add(txWidth, 0);
		
		for (int i = 0; i < horizontalSize - 2; i++) {
			GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.panelblueTransSideTop, pos.x, pos.y);
			
			pos.add(txWidth, 0);
		}
		
		GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.panelblueTransCornerRightTop, pos.x, pos.y);
		
		pos.set(position.cpy().add(0, txHeight));
		
		for (int j = 0 ; j < verticalSize - 2; j++) {
			GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.panelblueTransSideLeft, pos.x, pos.y);
			
			pos.add(txWidth, 0);
			
			for (int i = 0; i < horizontalSize - 2; i++) {
				GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.panelblueTransCenter, pos.x, pos.y);
				
				pos.add(txWidth, 0);
			}
			
			GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.panelblueTransSideRight, pos.x, pos.y);
			
			pos.set(position.x, pos.y + txHeight);
		}
		
		GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.panelblueTransCornerLeftBottom, pos.x, pos.y);
		
		pos.add(txWidth, 0);
		
		for (int i = 0; i < horizontalSize - 2; i++) {
			GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.panelblueTransSideBottom, pos.x, pos.y);
			
			pos.add(txWidth, 0);
		}
		
		GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.panelblueTransCornerRightBottom, pos.x, pos.y);
		
		super.draw();
	}
	
	@Override
	public void setHeight(float height) {
		super.setHeight(height);
		verticalSize = (int) (height / txHeight);
	}
	
	@Override
	public void setWidth(float width) {
		super.setWidth(width);
		horizontalSize = (int) (width / txWidth);
	}
}
