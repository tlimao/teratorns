package com.teratorns.game.gui;

import com.teratorns.assets.AssetsLoader;
import com.teratorns.gui.Container;

public abstract class ContainerFactory {
	
	public static enum ContainerColor {ORANGE, GREEN, BLUE};
	
	public static Container createContainer(float x, float y, float w, float h, ContainerColor color) {
		Container newContainer = null;
		
		float width = (((int) w) / AssetsLoader.instance.panelblueTransCenter.getRegionWidth());
		float height = (((int) h) / AssetsLoader.instance.panelblueTransCenter.getRegionHeight());
		
		if (width < 2) {
			width = 2;
		}
		
		if (height < 2) {
			height = 2;
		}
		
		height *= AssetsLoader.instance.panelblueTransCenter.getRegionHeight();
		width *= AssetsLoader.instance.panelblueTransCenter.getRegionWidth();
		
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
