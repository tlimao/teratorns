package com.teratorns.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.gui.BaseButton;
import com.teratorns.gui.BaseContainer;
import com.teratorns.gui.Container.ContainerAlignment;
import com.teratorns.gui.GuiElement;
import com.teratorns.gui.ImageButton;
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
		BaseContainer container1 = new BaseContainer(0,0);
		container1.setPadding(20, 20);
		BaseContainer container2 = new BaseContainer(0,0);
		container2.setPadding(20, 20);
		BaseContainer container3 = new BaseContainer(0,0);
		container3.setPadding(20, 20);
		container3.setAlignment(ContainerAlignment.VERTICAL);
		BaseContainer container4 = new BaseContainer(981,0);
		container4.setPadding(74, 40);
		container4.setAlignment(ContainerAlignment.VERTICAL);
		
		ImageButton button1 = new ImageButton(AssetsLoader.instance.travel);
		button1.setWidth(200);
		button1.setHeight(200);
		/*TextButton button1 = new TextButton(new BaseButton(0, 0, 200, 200));
		button1.setText("  C");
		button1.setColor(Color.CYAN);*/
		button1.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				AssetsLoader.instance.click.play(5f);
			}
		});
		
		TextButton button2 = new TextButton(new BaseButton(10, 100, 150, 150));
		button2.setText("  A");
		button2.setColor(Color.CYAN);
		
		TextButton button3 = new TextButton(new BaseButton(0, 0, 100, 100));
		button3.setText("  R");
		button3.setColor(Color.CYAN);
		
		TextButton button4 = new TextButton(new BaseButton(60, 20, 300, 300));
		button4.setText("  O");
		button4.setColor(Color.CYAN);
		
		TextButton button5 = new TextButton(new BaseButton(20, 0, 250, 250));
		button5.setText("  L");
		button5.setColor(Color.CYAN);
		
		TextButton button6 = new TextButton(new BaseButton(50, 50, 100, 100));
		button6.setText("  I");
		button6.setColor(Color.CYAN);
		
		TextButton button7 = new TextButton(new BaseButton(20, 0, 200, 200));
		button7.setText("  N");
		button7.setColor(Color.CYAN);
		
		TextButton button8 = new TextButton(new BaseButton(50, 40, 110, 110));
		button8.setText("  A");
		button8.setColor(Color.CYAN);
		
		TextButton button9 = new TextButton(new BaseButton(20, 1, 920, 68));
		button9.setText("ITABAIANA");
		button9.setColor(Color.CYAN);
		
		TextButton button10 = new TextButton(new BaseButton(0, 0, 150, 150));
		button10.setText("Elis");
		button10.setColor(Color.CYAN);
		
		TextButton button11 = new TextButton(new BaseButton(0, 0, 150, 150));
		button11.setText("Chico B.");
		button11.setColor(Color.CYAN);
		
		TextButton button12 = new TextButton(new BaseButton(0, 0, 150, 150));
		button12.setText("Roberto R.");
		button12.setColor(Color.CYAN);
		
		TextButton button13 = new TextButton(new BaseButton(0, 0, 150, 150));
		button13.setText("Alcione");
		button13.setColor(Color.CYAN);
		
		container1.addGuiElement(button1);
		container1.addGuiElement(button2);
		container1.addGuiElement(button3);
		container1.addGuiElement(button4);
		container2.addGuiElement(button5);
		container2.addGuiElement(button6);
		container2.addGuiElement(button7);
		container2.addGuiElement(button8);
		
		container3.addGuiElement(container1);
		container3.addGuiElement(container2);
		container3.addGuiElement(button9);
		
		container4.addGuiElement(button10);
		container4.addGuiElement(button11);
		container4.addGuiElement(button12);
		container4.addGuiElement(button13);
		
		guiElements.add(container3);
		guiElements.add(container4);
	}
}
