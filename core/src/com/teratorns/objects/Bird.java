package com.teratorns.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.game.GameClock;
import com.teratorns.game.GameRenderer;
import com.teratorns.interaction.Interactor;

public class Bird extends GameObject implements Interactor<Rectangle> {
	private Vector2 pBest;
	private Swarm swarm;
	
	public Bird(float x, float y) {
		super(x, y);
		pBest = position.cpy();
		velocity.set((float) Math.random(), (float) Math.random());
	}

	@Override
	public void update() {
		float fitness = fitness();
		
		if (fitness > SwarmConstants.threshold) {
			Vector2 v1, v2, v3, v4;
			
			// Inércia
			v1 = velocity.cpy();
			
			// Influência Própria
			v2 = getPbest().sub(position).scl(SwarmConstants.c1);
			
			// Influência do Bando
			Vector2 lBest = pBest.cpy();
			
			for (Bird b : swarm.getParticles()) {
				if (position.dst(b.getPosition()) < SwarmConstants.raio && !b.equals(this)) {
					if (lBest.dst(FoodSource.food) > b.getPbest().dst(FoodSource.food)) {
						lBest = b.getPbest();
					}
				}
			}
			
			v3 = (SwarmConstants.raio > 0) ? lBest.sub(position).scl(SwarmConstants.c2) : new Vector2(0, 0);

			// Fator Aleatório
			v4 = new Vector2(0, 0);
			v4.add(v2.cpy().scl((float) -Math.random()));
			v4.add(v3.cpy().scl((float) -Math.random()));
			v4.scl(SwarmConstants.c3);
			
			// Nova Velocidade
			velocity.set(v1.add(v2.add(v3.add(v4))));
			velocity.nor();
			
			position.add(velocity.cpy().scl(GameClock.instance.getDelta()));
			
			if (fitness() < pBest.dst(FoodSource.food)) {
				pBest = position.cpy();
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
		
		GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.circle,
				  position.x - width / 2, position.y - height / 2,
				  width / 2 , height / 2,
				  width     , height,
				  SwarmConstants.raio , SwarmConstants.raio,
				  rotation);
		
		GameRenderer.instance.spriteRenderer.setColor(0, 0, 0, 0.3f);
		
		GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.boid,
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
}
