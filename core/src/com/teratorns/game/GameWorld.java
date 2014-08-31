package com.teratorns.game;

import com.badlogic.gdx.utils.Array;
import com.teratorns.objects.ConcreteObject;
import com.teratorns.objects.GameObject;

public class GameWorld {
	
	private Array<GameObject> worldObjects;
	
	public GameWorld() {
		worldObjects = new Array<GameObject>();
		
		worldObjects.add(new ConcreteObject(2, 3));
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
