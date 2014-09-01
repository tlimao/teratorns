package com.teratorns.helpers;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.teratorns.game.GameOptions;
import com.teratorns.game.GameWorld;
import com.teratorns.objects.ConcreteObject;
import com.teratorns.objects.GameObject;
import com.teratorns.utils.Transformations;

public class InteractionHelper {
	
	private GameWorld gameWorld;
	private GameOptions gameOptions;
	private PlayerHelper playerHelper;
	private float interactionRange;
	private Rectangle interactionRect;
	
	public InteractionHelper(GameWorld gameWorld, PlayerHelper playerHelper, GameOptions gameOptions) {
		this.gameWorld = gameWorld;
		this.playerHelper = playerHelper;
		this.gameOptions = gameOptions;
		
		interactionRange = 0.5f;
		interactionRect = new Rectangle();
		interactionRect.setSize(interactionRange, interactionRange);
	}
	
	public void clicked(float sX, float sY) {
		
		Vector2 point = Transformations.screenToWorld(sX, sY);
		
		Array<GameObject> objects = gameWorld.getWorldObjects();
		
		for (GameObject obj : objects) {
			((ConcreteObject) obj).isTouched(interactionRect.setPosition(point.sub(interactionRange / 2, interactionRange / 2)));
		}
	}
	
	public Rectangle getLastClick() {
		return interactionRect;
	}
}
