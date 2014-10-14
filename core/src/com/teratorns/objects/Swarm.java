package com.teratorns.objects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Swarm {
	private Array<Bird> swarm;
	private Vector2 aim;
	
	public Swarm()
	{
		swarm = new Array<Bird>();
		aim = FoodSource.food;
	}
	
	public Vector2 getAim() {
		return aim.cpy();
	}
	
	public void onClick(float x, float y)
	{
		aim.set(x, y);
	}
	
	public void addParticle(Bird particle)
	{
		swarm.add(particle);
		particle.setSwarm(this);
	}
	
	public void update()
	{
		for (int i = 0; i < swarm.size; i++) {
			swarm.get(i).update();
		}
	}
	
	public void draw()
	{
		for (Bird particle : swarm)
		{
			particle.draw();
		}
	}
	
	public Array<Bird> getParticles() {
		return swarm;
	}
}
