package com.teratorns.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.gui.BaseButton;
import com.teratorns.gui.BaseContainer;
import com.teratorns.gui.GuiElement;
import com.teratorns.gui.TextButton;
import com.teratorns.interaction.ActionListener;
import com.teratorns.interaction.Interactor;
import com.teratorns.utils.Constants;

public class GameGui implements Interactor<Rectangle> {
	
	private Array<GuiElement> guiElements;
	
	public GameGui() {
		
		guiElements = new Array<GuiElement>();
		
		createGui();
	}
	
	public Array<GuiElement> getGuiElements() {
		return guiElements;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isTouched(Rectangle obj) {
		boolean flag = false;
		for (GuiElement element : guiElements) {
			if (element instanceof Interactor<?>) {
					if (((Interactor<Rectangle> ) element).isTouched(obj)) {
						Gdx.app.error("ACTION", "action");
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
	
	private void createGui() {
		BaseContainer container = new BaseContainer((Constants.windowWidth - 550), 100);
		container.setPadding(20, 20);
		
		TextButton button1 = new TextButton(new BaseButton(0, 0, 200, 50));
		button1.setText("  Button 1");
		button1.setColor(Color.CYAN);
		button1.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				AssetsLoader.instance.click.play(5f);
			}
		});
		TextButton button2 = new TextButton(new BaseButton(0, 0, 200, 50));
		button2.setText("  Button 2");
		button2.setColor(Color.CYAN);
		
		container.addGuiElement(button1);
		container.addGuiElement(button2);
		
		guiElements.add(container);
	}
}
