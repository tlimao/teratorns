package com.teratorns.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.teratorns.game.gui.Button1;
import com.teratorns.game.gui.PrimaryContainer;
import com.teratorns.gui.GuiElement;
import com.teratorns.interaction.Interactor;

public class GameEditor implements Interactor<Rectangle> {
	
	private Array<GuiElement> guiElements;
	
	public GameEditor() {
		guiElements = new Array<GuiElement>();
		
		PrimaryContainer pc1 = new PrimaryContainer(10, 10, 780, 60);
		pc1.setTag("Container 1");
		Button1 b1 = new Button1(10, 10, 40, 20);
		b1.setTag("Button 1");
		pc1.addGuiElement(b1);
		
		Button1 b2 = new Button1(10, 10, 40, 20);
		b2.setTag("Button 2");
		pc1.addGuiElement(b2);
		
		Button1 b3 = new Button1(10, 10, 40, 20);
		b3.setTag("Button 3");
		pc1.addGuiElement(b3);
		
		PrimaryContainer pc2 = new PrimaryContainer(10, 10, 100, 40);
		pc2.setTag("Container2");
		pc1.addGuiElement(pc2);
		
		guiElements.add(pc1);
	}
	
	public Array<GuiElement> getGuiElements() {
		return guiElements;
	}

	@Override
	public boolean isTouched(Rectangle obj) {
		boolean flag = false;
		
		for (GuiElement element : guiElements) {
			if (element instanceof Interactor<?>) {
					if (((Interactor) element).isTouched(obj)) {
						element.doAction();
						flag = true;
						break;
					}
			}
		}
		
		return flag;
	}

	@Override
	public void drawInteractor() {
		// TODO Auto-generated method stub
		
	}
}
