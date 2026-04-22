package com.teratorns.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.teratorns.assets.AssetsLoader;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.teratorns.game.GameClock;
import com.teratorns.game.GameRenderer;
import com.teratorns.interaction.Interactor;
import com.teratorns.utils.Constants;

public class Bird extends GameObject implements Interactor<Rectangle> {
	
	private Vector2 pBest;
	private Swarm swarm;

	// Fração do viewport usada para definir o tamanho visual do pássaro (ajustar conforme necessário)
	private static final float BOID_VIEWPORT_FRACTION = 0.06f; // 6% da altura do viewport
	
	public Bird(float x, float y) {
		super(x, y);
		pBest = position.cpy();
		velocity.set((float) Math.random() - 0.5f, (float) Math.random() - 0.5f);
	}

	@Override
	public void update() {
		float fitness = fitness();
		
		if (fitness > SwarmConstants.threshold) {
			Vector2 v1, v2, v3, v4;
			
			// In�rcia
			v1 = velocity.cpy();
			
			// Influ�ncia Pr�pria
			v2 = getPbest().sub(position).scl(SwarmConstants.c1);
			
			// Influ�ncia do Bando
			Vector2 lBest = pBest.cpy();
			boolean hasNeighbours = false;
			
			for (Bird b : swarm.getParticles()) {
				if (position.dst(b.getPosition()) < 2 * SwarmConstants.raio && !b.equals(this)) {
					if (lBest.dst(FoodSource.food) > b.getPbest().dst(FoodSource.food)) {
						lBest = b.getPbest();
						hasNeighbours = true;
					}
				}
			}
			
			v3 = (SwarmConstants.raio > 0 && hasNeighbours) ? lBest.sub(position).scl(SwarmConstants.c2) : new Vector2(0, 0);

			// Fator Aleat�rio
			v4 = new Vector2(0, 0);
			v4.add(v2.cpy().scl((float) -Math.random()));
			v4.add(v3.cpy().scl((float) -Math.random()));
			v4.scl(SwarmConstants.c3);
			
			if (SwarmConstants.c1 == 0 && SwarmConstants.c2 == 0) {
				if (SwarmConstants.c3 != 0) {
					v4.set((float) Math.random() - 0.5f, (float) Math.random() - 0.5f); 
				} else {
					v4.set(0, 0);
				}
			} 
			
			// Nova Velocidade
			velocity.set(v1.add(v2.add(v3.add(v4)))).nor();
			
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
		// Calcular tamanhos em unidades do viewport (independente de pixels)
		TextureRegion boidTx = AssetsLoader.instance.boid;
		float regionW = boidTx.getRegionWidth();
		float regionH = boidTx.getRegionHeight();

		// Fração do viewport que o pássaro deve ocupar (tuneable)
		float desiredHeightWorld = Constants.viewportHeight * BOID_VIEWPORT_FRACTION;
		float desiredWidthWorld = desiredHeightWorld * (regionW / regionH);

		float drawScaleX = desiredWidthWorld / width; // width normalmente 1
		float drawScaleY = desiredHeightWorld / height;

		// Círculo: use SwarmConstants.raio se disponível, senão derive a partir do boid
		float circleRadiusWorld = (SwarmConstants.raio > 0) ? SwarmConstants.raio : (desiredWidthWorld / 2f);
		float circleScaleX = (2 * circleRadiusWorld) / width;
		float circleScaleY = (2 * circleRadiusWorld) / height;

		GameRenderer.instance.spriteRenderer.setColor(0, 0, 0, 0.3f);
		GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.circle,
				  position.x - width / 2, position.y - height / 2,
				  width / 2 , height / 2,
				  width     , height,
				  circleScaleX , circleScaleY,
				  0);
		GameRenderer.instance.spriteRenderer.setColor(0, 0, 0, 0.3f);
		GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.boid,
				  position.x - width / 2, position.y - height / 2,
				  width / 2 , height / 2,
				  width     , height,
				  drawScaleX, drawScaleY,
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
