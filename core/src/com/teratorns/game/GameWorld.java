package com.teratorns.game;

import com.badlogic.gdx.utils.Array;
import com.teratorns.objects.GameObject;
import com.teratorns.objects.TeratornsLogoObject;
import com.teratorns.utils.Constants;

public class GameWorld {
	
	private Array<GameObject> worldObjects;
	
	public GameWorld() {
		worldObjects = new Array<GameObject>();
		
		float x = (Constants.viewportWidth - 1) / 2; 
		float y = (Constants.viewportHeight - 1) / 2; 
		
		addObject(new TeratornsLogoObject(x, y));
	}
	
	public Array<GameObject> getWorldObjects() {
		return worldObjects;
	}
	
	public void addObject(GameObject obj) {
		worldObjects.add(obj);
	}
	
	public void update() {
		for (GameObject obj : worldObjects) {
			obj.update();
		}
	}
}
