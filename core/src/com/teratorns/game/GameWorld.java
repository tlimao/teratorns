package com.teratorns.game;

import com.badlogic.gdx.utils.Array;
import com.teratorns.game.objects.FireSkull;
import com.teratorns.objects.GameObject;
import com.teratorns.utils.Constants;

public class GameWorld {
	
	private Array<GameObject> worldObjects;
	
	public GameWorld() {
		worldObjects = new Array<GameObject>();
		
		float x = (Constants.viewportWidth - 5) / 2.0f; 
		float y = (Constants.viewportHeight - 5 * Constants.aspectRatio) / 2.0f;
		
		addObject(new FireSkull(x, y));
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
