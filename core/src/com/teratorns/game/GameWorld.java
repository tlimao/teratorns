package com.teratorns.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.teratorns.objects.Bird;
import com.teratorns.objects.GameObject;
import com.teratorns.objects.Swarm;
import com.teratorns.utils.Constants;

public class GameWorld {
	
	private Array<GameObject> worldObjects;
	private Swarm swarm1;
	
	public GameWorld() {
		worldObjects = new Array<GameObject>();
		
		swarm1 = new Swarm();
		
		for (int i = 0 ; i < 9 ; i++) {
			Bird b = new Bird(0, Color.RED, (float) Math.random() * Constants.viewportWidth, (float) Math.random() * Constants.viewportHeight);
			swarm1.addParticle(b);
			worldObjects.add(b);
		}
	}
	
	public Array<GameObject> getWorldObjects() {
		return worldObjects;
	}
	
	public void addObject(GameObject obj) {
		worldObjects.add(obj);
	}
	
	public void update() {
		swarm1.update();
	}
}
