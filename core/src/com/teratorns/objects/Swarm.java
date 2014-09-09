package com.teratorns.objects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Swarm {
	private Array<ConcreteObject> swarm;
	private Vector2 aim;
	
	public Swarm()
	{
		swarm = new Array<ConcreteObject>();
		aim = new Vector2(0,0);
	}
	
	public void onClick(float x, float y)
	{
		aim.x = x;
		aim.y = y;
	}
	
	public void addUnity(ConcreteObject unity)
	{
		swarm.add(unity);
	}
	
	public void update()
	{
		for (int i = 0; i< swarm.size; i++) {
			swarm.get(i).update();
		}
	}
	
	public void draw()
	{
		for (ConcreteObject unity : swarm)
		{
			unity.draw();
		}
	}
}
