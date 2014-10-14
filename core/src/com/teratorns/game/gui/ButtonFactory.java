package com.teratorns.game.gui;

import com.teratorns.assets.AssetsLoader;
import com.teratorns.gui.Button;

public abstract class ButtonFactory {
	
	public static enum ButtonColor {ORANGE, GREEN, BLUE};
	
	public static Button createButton(float x, float y, float w, float h, ButtonColor color) {
		Button newButton = null;
		
		float width, height;
		
		switch (color) {
			case ORANGE:
				width = AssetsLoader.instance.buttonBlueMiddle.getRegionWidth() * (((int) w) / AssetsLoader.instance.buttonBlueMiddle.getRegionWidth());
				width += AssetsLoader.instance.buttonBlueLeft.getRegionWidth() + AssetsLoader.instance.buttonBlueRight.getRegionWidth();
				height = AssetsLoader.instance.buttonBlueMiddle.getRegionHeight();
				newButton = new BlueButton(x, y, width, height);
				break;
			case GREEN:
				width = AssetsLoader.instance.buttonBlueMiddle.getRegionWidth() * (((int) w) / AssetsLoader.instance.buttonBlueMiddle.getRegionWidth());
				width += AssetsLoader.instance.buttonBlueLeft.getRegionWidth() + AssetsLoader.instance.buttonBlueRight.getRegionWidth();
				height = AssetsLoader.instance.buttonBlueMiddle.getRegionHeight();
				newButton = new BlueButton(x, y, width, height);
				break;
			case BLUE:
				width = AssetsLoader.instance.buttonBlueMiddle.getRegionWidth() * (((int) w) / AssetsLoader.instance.buttonBlueMiddle.getRegionWidth());
				width += AssetsLoader.instance.buttonBlueLeft.getRegionWidth() + AssetsLoader.instance.buttonBlueRight.getRegionWidth();
				height = AssetsLoader.instance.buttonBlueMiddle.getRegionHeight();
				newButton = new BlueButton(x, y, width, height);
				break;
		}
		
		return newButton;
	}
}
