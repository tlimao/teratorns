package com.teratorns.view;

import com.badlogic.gdx.utils.Array;
import com.teratorns.game.GameGui;
import com.teratorns.game.GameRenderer;
import com.teratorns.gui.GuiElement;
import com.teratorns.interaction.Interactor;

public class GuiView extends View {
	
	private GameGui gameGui;
	
	public GuiView(GameGui gameGui) {
		this.gameGui = gameGui;
		
		addLayer(new GuiLayer());
		addLayer(new GuiInteraction());
	}
	
	private class GuiLayer extends Layer {

		@Override
		public void draw() {
			Array<GuiElement> elements = gameGui.getGuiElements();

			GameRenderer.instance.spriteRenderer.begin();
			GameRenderer.instance.spriteRenderer.setProjectionMatrix(GameRenderer.instance.guiCamera.combined);
			
			for (GuiElement element : elements) {
				if (element.isVisible())
				{
					element.draw();
				}
			}
			
			GameRenderer.instance.spriteRenderer.end();
		}
	}
	
	private class GuiInteraction extends Layer {
		
		@Override
		public void draw() {
			Array<GuiElement> elements = gameGui.getGuiElements();
			
			GameRenderer.instance.shapeRenderer.setProjectionMatrix(GameRenderer.instance.guiCamera.combined);
			
			for (GuiElement element : elements) {
				if (element.isVisible())
				{
					((Interactor<?>) element).drawInteractor();
				}
			}
		}
	}
}
