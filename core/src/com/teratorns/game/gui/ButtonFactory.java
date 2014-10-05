package com.teratorns.game.gui;

import com.teratorns.assets.AssestsLoader;
import com.teratorns.gui.Button;

public abstract class ButtonFactory {
	
	public static enum ButtonColor {ORANGE, GREEN, BLUE};
	
	public static Button createButton(float x, float y, float w, float h, ButtonColor color) {
		Button newButton = null;
		
		float width, height;
		
		switch (color) {
			case ORANGE:
				width = AssestsLoader.instance.buttonBlueMiddle.getRegionWidth() * (((int) w) / AssestsLoader.instance.buttonBlueMiddle.getRegionWidth());
				width += AssestsLoader.instance.buttonBlueLeft.getRegionWidth() + AssestsLoader.instance.buttonBlueRight.getRegionWidth();
				height = AssestsLoader.instance.buttonBlueMiddle.getRegionHeight();
				newButton = new BlueButton(x, y, width, height);
				break;
			case GREEN:
				width = AssestsLoader.instance.buttonBlueMiddle.getRegionWidth() * (((int) w) / AssestsLoader.instance.buttonBlueMiddle.getRegionWidth());
				width += AssestsLoader.instance.buttonBlueLeft.getRegionWidth() + AssestsLoader.instance.buttonBlueRight.getRegionWidth();
				height = AssestsLoader.instance.buttonBlueMiddle.getRegionHeight();
				newButton = new BlueButton(x, y, width, height);
				break;
			case BLUE:
				width = AssestsLoader.instance.buttonBlueMiddle.getRegionWidth() * (((int) w) / AssestsLoader.instance.buttonBlueMiddle.getRegionWidth());
				width += AssestsLoader.instance.buttonBlueLeft.getRegionWidth() + AssestsLoader.instance.buttonBlueRight.getRegionWidth();
				height = AssestsLoader.instance.buttonBlueMiddle.getRegionHeight();
				newButton = new BlueButton(x, y, width, height);
				break;
		}
		
		return newButton;
	}
}
