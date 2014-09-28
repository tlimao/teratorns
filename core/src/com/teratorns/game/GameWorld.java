package com.teratorns.game;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.utils.Array;
import com.teratorns.objects.Cube;
import com.teratorns.objects.GameObject3D;
import com.teratorns.objects.Ship;

public class GameWorld {
	private Environment environment;
	private Array<GameObject3D> worldObjects;
	
	public GameWorld() {
		environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
        
		worldObjects = new Array<GameObject3D>();
		
		worldObjects.add(new Ship(0, 0, 0));
	}
	
	public Array<GameObject3D> getWorldObjects() {
		return worldObjects;
	}
	
	public Environment getEnvironment() {
		return environment;
	}
	
	public void addObject(GameObject3D obj) {
		worldObjects.add(obj);
	}
	
	public void update() {
		for (GameObject3D obj : worldObjects) {
			obj.update();
		}
	}
	
	public void dispose() {
		worldObjects.clear();
	}
}
