package com.teratorns.game.views;

import com.badlogic.gdx.utils.Array;
import com.teratorns.game.GameEditor;
import com.teratorns.game.GameRenderer;
import com.teratorns.gui.GuiElement;
import com.teratorns.interaction.Interactor;
import com.teratorns.view.Layer;
import com.teratorns.view.View;

public class EditView extends View  {

	private GameEditor gameEditor;
	
	public EditView(GameEditor gameEditor) {
		this.gameEditor = gameEditor;
		addLayer(new PrimaryMenu());
		addLayer(new PrimaryMenuInteraction());
	}
	
	private class PrimaryMenu extends Layer {
		
		@Override
		public void draw() {
			Array<GuiElement> elements = gameEditor.getGuiElements();

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
	
	private class PrimaryMenuInteraction extends Layer {
		
		@Override
		public void draw() {
			Array<GuiElement> elements = gameEditor.getGuiElements();
			
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
