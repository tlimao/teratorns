package com.teratorns.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.teratorns.assets.AssestsLoader;
import com.teratorns.game.GameClock;
import com.teratorns.game.GameRenderer;
import com.teratorns.interaction.Interactor;

public class Bird extends GameObject implements Interactor<Rectangle> {
	private Vector2 pBest;
	private Swarm swarm;
	private float rand;
	
	public Bird(float x, float y) {
		super(x, y);
		pBest = position.cpy();
		velocity.set((float) Math.random(), (float) Math.random());
		
		rand = SwarmConstants.c3;
	}

	@Override
	public void update() {
		float fitness = fitness();
		
		if (fitness > SwarmConstants.threshold) {
			Array<Bird> neighbours = new Array<Bird>();
			
			for (Bird b : swarm.getParticles()) {
				if (position.dst(b.getPosition()) < SwarmConstants.raio && !b.equals(this)) {
					neighbours.add(b);
				}
			}
			
			// Influência do Bando
			Vector2 lBest = pBest.cpy();
			
			for (Bird b : neighbours) {
				if (lBest.dst(FoodSource.food) > b.getPbest().dst(FoodSource.food)) {
					lBest = b.getPbest();
				}
			}
			
			Vector2 v1 = lBest.sub(position);
			//System.out.println(SwarmConstants.raio + " " + v1.toString());
			
			// Influência da Partícula
			Vector2 v2 = velocity.cpy();
			
			// Influência Aleatória
			Vector2 v3 = new Vector2((float) Math.random(), (float) Math.random());
			
			// Nova Velocidade
			velocity.set(0,0);
			if (SwarmConstants.c1 > 1.0E-10f && SwarmConstants.raio > 0) {
				velocity.add(v1.scl(SwarmConstants.c1));
			}
			if (SwarmConstants.c2 > 1.0E-10f) {
				velocity.add(v2.scl(SwarmConstants.c2));
			}
			if (rand > 1.0E-10f && SwarmConstants.c3 > 0) {
				velocity.add(v3.scl(rand));
			}
			velocity.nor().scl(0.3f);
		
			position.add(velocity.cpy().scl(GameClock.instance.getDelta()));
			
			fitness = fitness();
			
			if (fitness < pBest.dst(FoodSource.food)) {
				pBest = position.cpy();
				rand -= SwarmConstants.aleatoryDec;
				if (rand < 0) {
					rand = 0.0f;
				}
			}
		}
	}
	
	public Vector2 getPbest() {
		return pBest.cpy();
	}
	
	public void setSwarm(Swarm swarm)
	{
		this.swarm = swarm;
	}
	
	private float fitness() {
		return position.cpy().dst(FoodSource.food);
	}

	@Override
	public void draw() {
		GameRenderer.instance.spriteRenderer.setColor(0, 0, 0, 1f);
		
		GameRenderer.instance.spriteRenderer.draw(AssestsLoader.instance.circle,
				  position.x - width / 2, position.y - height / 2,
				  width / 2 , height / 2,
				  width     , height,
				  SwarmConstants.raio , SwarmConstants.raio,
				  rotation);
		
		GameRenderer.instance.spriteRenderer.setColor(0, 0, 0, 0.3f);
		
		GameRenderer.instance.spriteRenderer.draw(AssestsLoader.instance.boid,
												  position.x - width / 2, position.y - height / 2,
												  width / 2 , height / 2,
												  width     , height,
												  0.5f      , 0.5f,
												  velocity.angle());
		
		GameRenderer.instance.spriteRenderer.setColor(Color.WHITE);
	}

	@Override
	public boolean isTouched(Rectangle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void drawInteractor() {
		// TODO Auto-generated method stub
		
	}
	
	public void setAleatoryFactor(float value) {
		rand = value;
	}
}
