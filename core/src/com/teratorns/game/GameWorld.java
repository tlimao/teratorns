package com.teratorns.game;

import com.badlogic.gdx.utils.Array;
import com.teratorns.objects.ConcreteObject;
import com.teratorns.objects.GameObject;
import com.teratorns.objects.Sheep;
import com.teratorns.objects.Swarm;

public class GameWorld {
	
	private Array<GameObject> worldObjects;
	private Swarm swarm;
	
	public GameWorld() {
		worldObjects = new Array<GameObject>();
		
		swarm = new Swarm();
		
		ConcreteObject c1 = new ConcreteObject(2, 2);
		ConcreteObject c2 = new ConcreteObject(2, 2);
		ConcreteObject c3 = new ConcreteObject(2, 2);
		ConcreteObject c4 = new ConcreteObject(2, 2);
		
		swarm.addUnity(c1);
		swarm.addUnity(c2);
		swarm.addUnity(c3);
		swarm.addUnity(c4);
		
		worldObjects.add(c1);
		worldObjects.add(c2);
		worldObjects.add(c3);
		worldObjects.add(c4);
	}
	
	public Array<GameObject> getWorldObjects() {
		return worldObjects;
	}
	
	public void addObject(GameObject obj) {
		worldObjects.add(obj);
	}
	
	public void update() {
		/*for (GameObject obj : worldObjects) {
			obj.update();
		}*/
		
		swarm.update();
	}
}
