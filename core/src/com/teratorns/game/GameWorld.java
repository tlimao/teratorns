package com.teratorns.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.teratorns.game.logic.ColonyVariables;
import com.teratorns.objects.Ant;
import com.teratorns.objects.Colony;
import com.teratorns.objects.Food;
import com.teratorns.objects.GameObject;

public class GameWorld {
	
	private Array<GameObject> worldObjects;
	private Colony colony;
	
	public GameWorld() {
		worldObjects = new Array<GameObject>();
	}
	
	public Array<GameObject> getWorldObjects() {
		return worldObjects;
	}
	
	public void addObject(GameObject obj) {
		worldObjects.add(obj);
	}
	
	public void update() {
		if (colony != null) {
			colony.update();
		}
	}
	
	public void createColony() {
		colony = new Colony();
		ColonyVariables.instance.colony = colony;
		worldObjects.clear();
		
		for (int i = 0 ; i < ColonyVariables.instance.antsNumber; i++) {
			Ant a = new Ant();
			colony.addAnt(a);
			worldObjects.add(a);
		}
		
		
		int x = 0;
		int y = 0;
		do{
			x = (int) Math.floor(Math.random()*ColonyVariables.instance.splitFactor);
			y = (int) Math.floor(Math.random()*ColonyVariables.instance.splitFactor);
		} while(new Vector2(x,y).equals(ColonyVariables.instance.colonyPosition));
		
		Food f = new Food(x, y);
		colony.addFood(f);
		worldObjects.add(f);
		
		float distance = Vector2.dst(ColonyVariables.instance.colonyPosition.x, ColonyVariables.instance.colonyPosition.y, x, y);
		ColonyVariables.instance.evaporateFactor = (1 - .001f*ColonyVariables.instance.maxVelocity/distance*distance);
	}
	
	public Colony getColony() {
		return colony;
	}
}
