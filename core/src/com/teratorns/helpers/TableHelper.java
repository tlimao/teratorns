package com.teratorns.helpers;

import java.util.Vector;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.teratorns.game.GameFour;
import com.teratorns.interaction.Interactor;
import com.teratorns.objects.Bird;
import com.teratorns.objects.FoodSource;
import com.teratorns.objects.GameObject;
import com.teratorns.objects.Table;
import com.teratorns.utils.Transformations;

public class TableHelper {

	private Table table;
	private float interactionRange;
	private Rectangle interactionRect;
	private Vector2 touchPosition;
	
	public TableHelper(GameFour game) {
		table = game.getGameTable();
		
		interactionRange = 0.25f;
		interactionRect = new Rectangle();
		interactionRect.setSize(interactionRange, interactionRange);
		
		touchPosition = new Vector2();
	}
	
	public void clicked(float sX, float sY) {
		
		Vector2 point = Transformations.screenToWorld(sX, sY);
		
		touchPosition.set(point.cpy());
		
		interactionRect.setPosition(point);
		
		table.isTouched(interactionRect);
	}
	
	public Vector2 getTouchPosition() {
		return touchPosition;
	}
}
