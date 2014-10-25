package com.teratorns.game;

import com.teratorns.objects.Bird;
import com.teratorns.objects.Swarm;
import com.teratorns.objects.SwarmConstants;
import com.teratorns.utils.Constants;

public class GameWorld {
	private Swarm swarm;
	
	public GameWorld() {
		createSwarm();
	}
	
	public void update() {
		
		if (swarm != null) {
			swarm.update();
		}
	}
	
	public void createSwarm() {
		swarm = new Swarm();
		
		for (int i = 0 ; i < SwarmConstants.swarmSize ; i++) {
			Bird b = new Bird((float) Math.random() * Constants.viewportWidth, (float) Math.random() * Constants.viewportHeight);
			swarm.addParticle(b);
		}
	}
	
	public void addParticle() {
		if (swarm != null) {
			Bird b = new Bird((float) Math.random() * Constants.viewportWidth, (float) Math.random() * Constants.viewportHeight);
			swarm.addParticle(b);
		}
	}
	
	public void removeParticle() {
		if (swarm.getParticles().size > 1) {
			if (swarm.getParticles().size > 0) {
				swarm.getParticles().removeIndex(0);
			}
		}
	}
	
	public Swarm getSwarm() {
		return swarm;
	}
}
