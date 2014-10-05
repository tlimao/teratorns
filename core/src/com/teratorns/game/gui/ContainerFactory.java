package com.teratorns.game.gui;

import com.teratorns.assets.AssestsLoader;
import com.teratorns.gui.Container;

public abstract class ContainerFactory {
	
	public static enum ContainerColor {ORANGE, GREEN, BLUE};
	
	public static Container createContainer(float x, float y, float w, float h, ContainerColor color) {
		Container newContainer = null;
		
		float width = AssestsLoader.instance.panelblueTransCenter.getRegionWidth() * (((int) w) / AssestsLoader.instance.panelblueTransCenter.getRegionWidth());
		float height = AssestsLoader.instance.panelblueTransCenter.getRegionHeight() * (((int) h) / AssestsLoader.instance.panelblueTransCenter.getRegionHeight());
		
		switch (color) {
			case ORANGE:
				newContainer = new BlueContainer(x, y, width, height);
				break;
			case GREEN:
				newContainer = new BlueContainer(x, y, width, height);
				break;
			case BLUE:
				newContainer = new BlueContainer(x, y, width, height);
				break;

		}
		
		return newContainer;
	}
}
