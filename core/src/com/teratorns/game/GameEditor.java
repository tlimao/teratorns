package com.teratorns.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.teratorns.game.gui.BlueButton;
import com.teratorns.game.gui.BlueContainer;
import com.teratorns.game.gui.ButtonFactory;
import com.teratorns.game.gui.ButtonFactory.ButtonColor;
import com.teratorns.game.gui.ContainerFactory;
import com.teratorns.game.gui.ContainerFactory.ContainerColor;
import com.teratorns.gui.GuiElement;
import com.teratorns.interaction.Interactor;

public class GameEditor implements Interactor<Rectangle> {
	
	private Array<GuiElement> guiElements;
	
	public GameEditor() {
		guiElements = new Array<GuiElement>();
		
		BlueContainer pc1 = (BlueContainer) ContainerFactory.createContainer(10, 10, 780, 90, ContainerColor.BLUE);
		pc1.setTag("Container 1");
		BlueButton b1 = (BlueButton) ButtonFactory.createButton(10, 13, 60, 20, ButtonColor.BLUE);
		b1.setTag("Button 1");
		pc1.addGuiElement(b1);
		
		BlueButton b2 = (BlueButton) ButtonFactory.createButton(10, 13, 90, 20, ButtonColor.BLUE);
		b2.setTag("Button 2");
		pc1.addGuiElement(b2);
		
		BlueButton b3 = (BlueButton) ButtonFactory.createButton(10, 13, 40, 20, ButtonColor.BLUE);
		b3.setTag("Button 3");
		pc1.addGuiElement(b3);
		
		BlueContainer pc2 = (BlueContainer) ContainerFactory.createContainer(10, 10, 500, 60, ContainerColor.BLUE);
		pc2.setTag("Container 2");

		pc1.addGuiElement(pc2);

		BlueButton b4 = (BlueButton) ButtonFactory.createButton(10, 13, 60, 20, ButtonColor.BLUE);
		b4.setTag("Button 4");
		pc2.addGuiElement(b4);
		
		BlueButton b5 = (BlueButton) ButtonFactory.createButton(10, 13, 90, 20, ButtonColor.BLUE);
		b5.setTag("Button 5");
		pc2.addGuiElement(b5);
		
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
