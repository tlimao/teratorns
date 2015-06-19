package com.teratorns.helpers;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.teratorns.game.GameGui;
import com.teratorns.game.GameOptions;
import com.teratorns.game.GameWorld;
import com.teratorns.interaction.Interactor;
import com.teratorns.objects.GameObject;
import com.teratorns.utils.Constants;
import com.teratorns.utils.Transformations;

public class InteractionHelper {
	
	private GameWorld gameWorld;
	private GameGui gameGui;
	private GameOptions gameOptions;
	private PlayerHelper playerHelper;
	private float interactRange;
	private Rectangle interactRect;
	private Vector2 lastClickedPosition;
	
	public InteractionHelper(GameWorld gameWorld, GameGui gameGui, PlayerHelper playerHelper, GameOptions gameOptions) {
		this.gameWorld = gameWorld;
		this.gameGui = gameGui;
		this.playerHelper = playerHelper;
		this.gameOptions = gameOptions;
		
		interactRange = 0.01f * Constants.viewportWidth;
		interactRect = new Rectangle(-10, -10, interactRange, interactRange);
		lastClickedPosition = new Vector2(-10, -10);
	}
	
	public void touchIn(int sX, int sY) {
		// Screen System (Pixels)
		interactRect.setPosition(new Vector2(sX, sY));
		
		// For GUI elements consider the Screen System (Pixels)
		gameGui.isTouched(interactRect);
		
		// World System
		lastClickedPosition.set(Transformations.screenToWorld(sX, sY));
		
		interactRect.setPosition(lastClickedPosition);

		/*Array<GameObject> worldObjects = gameWorld.getWorldObjects();
		
		for (GameObject obj : worldObjects) {
			((Interactor<Rectangle>) obj).isTouched(interactRect);
		}*/
	}
	
	public Vector2 getLastClickPosition() {
		return lastClickedPosition.cpy();
	}
	
	public float getInteractionRange() {
		return interactRange;
	}
}
