package com.teratorns.helpers;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.teratorns.game.GameOptions;
import com.teratorns.game.GameWorld;
import com.teratorns.game.objects.FireSkull;
import com.teratorns.interaction.Interactor;
import com.teratorns.objects.GameObject;
import com.teratorns.utils.Constants;
import com.teratorns.utils.Transformations;

public class InteractionHelper {
	
	private GameWorld gameWorld;
	private GameOptions gameOptions;
	private PlayerHelper playerHelper;
	private float interactRange;
	private Rectangle interactRect;
	private Vector2 lastClickedPosition;
	
	public InteractionHelper(GameWorld gameWorld, PlayerHelper playerHelper, GameOptions gameOptions) {
		this.gameWorld = gameWorld;
		this.playerHelper = playerHelper;
		this.gameOptions = gameOptions;
		
		interactRange = 0.01f * Constants.viewportWidth;
		interactRect = new Rectangle(-10, -10, interactRange, interactRange);
		lastClickedPosition = new Vector2(-10, -10);
	}
	
	public void touchIn(int sX, int sY) {
		lastClickedPosition.set(Transformations.screenToWorld(sX, sY));
		
		interactRect.setPosition(lastClickedPosition);
		
		Array<GameObject> worldObjects = gameWorld.getWorldObjects();
		
		for (GameObject obj : worldObjects) {
			((Interactor<Rectangle>) obj).isTouched(interactRect);
			
			if (obj instanceof FireSkull) {
				((FireSkull) obj).setAim(lastClickedPosition);
			}
		}
	}
	
	public Vector2 getLastClickPosition() {
		return lastClickedPosition.cpy();
	}
	
	public float getInteractionRange() {
		return interactRange;
	}
}
