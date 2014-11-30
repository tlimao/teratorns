package com.teratorns.game;

import com.badlogic.gdx.utils.Array;
import com.teratorns.gui.BaseContainer;
import com.teratorns.gui.GuiElement;
import com.teratorns.gui.TextArea;
import com.teratorns.objects.Table;
import com.teratorns.utils.Constants;

public class GameHud {
	
	private Array<GuiElement> guiElements;
	private static TextArea score;
	
	public GameHud() {
		guiElements = new Array<GuiElement>();
		
		float posX = Constants.windowWidth * 0.125f;
		float posY = Constants.windowHeight * 0.1f;
		TextArea fiveColors = new TextArea();
		fiveColors.setText("FOUR COLORS");
		fiveColors.setScale(2.5f);
		fiveColors.setPosition(posX, posY);
		fiveColors.setTextColor(155.0f/255, 89.0f/255, 182.0f/255, 0.7f);
		score = new TextArea();
		posX = Constants.windowWidth * 0.25f;
		posY = Constants.windowHeight * 0.75f;
		score.setPosition(posX, posY);
		score.setScale(1.5f);
		score.setText("Score 0");
		score.setTextColor(0, 0, 0, 0.6f);
		BaseContainer teratornsLogo = new BaseContainer(0, 0);
		teratornsLogo.setColor(0,0,0,0);
		teratornsLogo.addGuiElement(fiveColors);
		teratornsLogo.addGuiElement(score);
		guiElements.add(teratornsLogo);
	}
	
	public Array<GuiElement> getGuiElements() {
		return guiElements;
	}
	
	public static void updateScore() {
		score.setText("Score " + Table.score);
	}
}
