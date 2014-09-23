package com.teratorns.objects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Swarm {
	public static Vector2 gBest;
	private Array<ConcreteObject> swarm;
	private Vector2 aim;
	
	public Swarm()
	{
		swarm = new Array<ConcreteObject>();
		aim = new Vector2(0,0);
		gBest = new Vector2(0, 0);
	}
	
	public void onClick(float x, float y)
	{
		aim.set(x, y);
	}
	
	public void setGbest(float x, float y) {
		gBest.set(x, y);
	}
	
	public void addParticle(ConcreteObject particle)
	{
		swarm.add(particle);
		particle.setSwarm(this);
	}
	
	public void update()
	{
		for (int i = 0; i< swarm.size; i++) {
			swarm.get(i).update();
		}
	}
	
	public void draw()
	{
		for (ConcreteObject particle : swarm)
		{
			particle.draw();
		}
	}
	
	public Array<ConcreteObject> getParticles() {
		return swarm;
	}
}
