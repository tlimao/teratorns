package com.teratorns.helpers;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.teratorns.game.GameEditor;
import com.teratorns.game.GameWorld;
import com.teratorns.interaction.Interactor;
import com.teratorns.objects.Bird;
import com.teratorns.objects.FoodSource;
import com.teratorns.objects.GameObject;
import com.teratorns.utils.Transformations;

public class InteractionHelper {
	
	private GameWorld gameWorld;
	private GameEditor gameEditor;
	private PlayerHelper playerHelper;
	private float interactionRange;
	private Rectangle interactionRect;
	
	public InteractionHelper(GameWorld gameWorld, GameEditor gameEditor, PlayerHelper playerHelper) {
		this.gameWorld = gameWorld;
		this.gameEditor = gameEditor;
		this.playerHelper = playerHelper;
		
		interactionRange = 0.25f;
		interactionRect = new Rectangle();
		interactionRect.setSize(interactionRange, interactionRange);
	}
	
	public void clicked(float sX, float sY) {
		
		if (gameEditor.isTouched(new Rectangle(sX, sY, interactionRange, interactionRange))) {
			// Nada
		}
		
		else {
			Vector2 point = Transformations.screenToWorld(sX, sY);
			
			FoodSource.food.set(point);
			
			Array<Bird> objects = gameWorld.getSwarm().getParticles();
			
			interactionRect.setPosition(point);
			
			for (GameObject obj : objects) {
				((Interactor<Rectangle>) obj).isTouched(interactionRect);
			}
		}
	}
	
	public Rectangle getLastClick() {
		return interactionRect;
	}
}
