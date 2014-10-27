package com.teratorns.objects;

import com.badlogic.gdx.utils.Array;
import com.teratorns.game.logic.PheromoneLogic;

public class Colony {

	private Array<Ant> ants;
	Food food;
//	private Vector2 aim;
	
	public Colony()
	{
		ants = new Array<Ant>();
	//	aim = FoodSource.food;
	}
	
//	public Vector2 getAim() {
//		return aim.cpy();
//	}
	
	public void onClick(float x, float y)
	{
		
//		aim.set(x, y);
	}
	
	public void addAnt(Ant ant)
	{
		ants.add(ant);
		ant.setColony(this);
	}
	
	public void update()
	{
		PheromoneLogic.instance.evaporate();
		for (int i = 0; i < ants.size; i++) {
			ants.get(i).update();
		}
	}
	
	public void draw()
	{
		for (Ant ant : ants)
		{
			ant.draw();
		}
	}
	
	public Array<Ant> getAnts() {
		return ants;
	}

	public void addFood(Food f) {
		this.food = f;
		f.setColony(this);
	}
}
