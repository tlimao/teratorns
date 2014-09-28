package com.teratorns.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.teratorns.objects.Bird;
import com.teratorns.objects.GameObject;
import com.teratorns.objects.Swarm;
import com.teratorns.utils.Constants;

public class GameWorld {
	
	private Array<GameObject> worldObjects;
	private Swarm swarm1, swarm2, swarm3, swarm4;
	
	public GameWorld() {
		worldObjects = new Array<GameObject>();
		
		swarm1 = new Swarm();
		swarm2 = new Swarm();
		swarm3 = new Swarm();
		swarm4 = new Swarm();
		
		for (int i = 0 ; i < 9 ; i++) {
			Bird b = new Bird(0.25f, Color.RED, (float) Math.random() * Constants.viewportWidth, (float) Math.random() * Constants.viewportHeight);
			swarm1.addParticle(b);
			worldObjects.add(b);
		}
		
		for (int i = 0 ; i < 9 ; i++) {
			Bird b = new Bird(0, Color.BLUE, (float) Math.random() * Constants.viewportWidth, (float) Math.random() * Constants.viewportHeight);
			swarm2.addParticle(b);
			worldObjects.add(b);
		}
		
		for (int i = 0 ; i < 9 ; i++) {
			Bird b = new Bird(0.5f, Color.DARK_GRAY, (float) Math.random() * Constants.viewportWidth, (float) Math.random() * Constants.viewportHeight);
			swarm3.addParticle(b);
			worldObjects.add(b);
		}
		
		for (int i = 0 ; i < 9 ; i++) {
			Bird b = new Bird(10, Color.WHITE, (float) Math.random() * Constants.viewportWidth, (float) Math.random() * Constants.viewportHeight);
			swarm4.addParticle(b);
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
		/*for (GameObject obj : worldObjects) {
			obj.update();
		}*/
		
		swarm1.update();
		swarm2.update();
		swarm3.update();
		swarm4.update();
	}
}
