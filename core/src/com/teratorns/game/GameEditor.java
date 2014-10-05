package com.teratorns.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.teratorns.game.gui.BlueContainer;
import com.teratorns.game.gui.ButtonFactory;
import com.teratorns.game.gui.ContainerFactory;
import com.teratorns.game.gui.ButtonFactory.ButtonColor;
import com.teratorns.game.gui.ContainerFactory.ContainerColor;
import com.teratorns.gui.Button;
import com.teratorns.gui.GuiElement;
import com.teratorns.interaction.ActionListener;
import com.teratorns.interaction.Interactor;

public class GameEditor implements Interactor<Rectangle> {
	
	private Array<GuiElement> guiElements;
	
	private enum EditorStates {CREATE_SWARM, NUM_PARTICLES, PARTICLE_RAIO, PARTICLE_COLOR, SWARM_AIM, START, KILL};
	
	private GameWorld gameWorld;
	
	private String action;
	
	public GameEditor(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
		
		guiElements = new Array<GuiElement>();
		
		BlueContainer pc1 = (BlueContainer) ContainerFactory.createContainer(10, 10, 240, 50, ContainerColor.BLUE);
		pc1.setTag("Container 1");
		guiElements.add(pc1);
		
		Button b1 = ButtonFactory.createButton(10, 10, 50, 30, ButtonColor.BLUE);
		b1.setTag("Pause");
		b1.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				GameOptions.instance.pause();
			}
		});
		
		Button b2 = ButtonFactory.createButton(10, 10, 50, 30, ButtonColor.BLUE);
		b2.setTag("Resume");
		b2.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				GameOptions.instance.resume();
			}
		});
		
		Button b3 = ButtonFactory.createButton(10, 10, 50, 30, ButtonColor.BLUE);
		b3.setTag("Create Swarm");
		
		b3.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				GameEditor.this.gameWorld.createSwarm();
			}
		});
		
		pc1.addGuiElement(b1);
		
		pc1.addGuiElement(b2);
		
		pc1.addGuiElement(b3);
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
