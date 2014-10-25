package com.teratorns.game;

import java.util.ArrayList;

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
		worldObjects.clear();
		
		for (int i = 0 ; i < ColonyVariables.instance.antsNumber; i++) {
			Ant a = new Ant();
			colony.addAnt(a);
			worldObjects.add(a);
		}
		
		
		ColonyVariables.instance.foodPositions = new ArrayList<Vector2>();
		
		for(int i = 0; i < ColonyVariables.instance.sources; i++){
			
			int x = (int) Math.floor(Math.random()*ColonyVariables.instance.splitFactor);
			int y = (int) Math.floor(Math.random()*ColonyVariables.instance.splitFactor);
			if(new Vector2(x,y).equals(ColonyVariables.instance.colonyPosition)){
				i--;
			}
			else{
				ColonyVariables.instance.foodPositions.add(new Vector2(x,y));
			}
		}
		
		for(Vector2 food : ColonyVariables.instance.foodPositions){
			Food f = new Food(food.x, food.y);
			System.out.println("("+food.x+","+food.y+")");
			colony.addFood(f);
			worldObjects.add(f);
		}
	}
	
	public Colony getColony() {
		return colony;
	}
}
