package com.teratorns.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.game.GameGui;
import com.teratorns.game.GameRenderer;
import com.teratorns.gui.GuiElement;
import com.teratorns.interaction.Interactor;
import com.teratorns.utils.Constants;

public class GuiView extends View {
	
	private GameGui gameGui;
	
	public GuiView(GameGui gameGui) {
		this.gameGui = gameGui;
		
		addLayer(new GuiBackground());
		addLayer(new GuiLayer());
		//addLayer(new GuiInteraction());
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
	
	private class GuiBackground extends Layer {

		@Override
		public void draw() {
			GameRenderer.instance.spriteRenderer.begin();
			GameRenderer.instance.spriteRenderer.setProjectionMatrix(GameRenderer.instance.guiCamera.combined);
			GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.background,
													  0, 0,
													  0, 0,
													  Constants.windowWidth, Constants.windowHeight,
													  1, 1,
													  0);
			GameRenderer.instance.spriteRenderer.setColor(Color.WHITE);
			GameRenderer.instance.spriteRenderer.end();
		}
		
	}
}
