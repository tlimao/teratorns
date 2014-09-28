package com.teratorns.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.teratorns.assets.AssestsLoader;
import com.teratorns.game.GameClock;
import com.teratorns.game.GameRenderer;
import com.teratorns.interaction.Interactor;

public class Bird extends GameObject implements Interactor<Rectangle> {
	private float l = 2f;
	private Vector2 pBest;
	private boolean flag;
	private Array<Vector2> path;
	private Swarm swarm;
	private Color color;
	
	public Bird(float l, Color color, float x, float y) {
		super(x, y);
		this.l = l;
		this.color = color;
		flag = false;
		path = new Array<Vector2>();
		pBest = position.cpy();
		velocity.scl((float) Math.random(), (float) Math.random());
	}

	@Override
	public void update() {
		float fitness = fitness();
		
		if (fitness < 0.01f) {
			flag = true;
		}
		
		else {
			flag = false;
			
			Array<Bird> neighbours = new Array<Bird>();
			
			for (Bird b : swarm.getParticles()) {
				if (position.dst(b.getPosition()) < l && !b.equals(this)) {
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
			
			Vector2 v1 = lBest.sub(position).nor();
			
			// Influência da Partícula
			Vector2 v2 = velocity.cpy().nor();
			
			// Influência Aleatória
			Vector2 v3 = new Vector2((float) Math.random(), (float) Math.random());
			
			// Influência de Afastamento - para as partículas não se chocarem
			Vector2 diff = new Vector2();
			int count = 0;
			for (Bird b : neighbours) {
				if (position.dst(b.getPosition()) < 0.2f) {
					diff.add(position.cpy().sub(b.getPosition()));
					count++;
				}
			}
			
			if (count > 0) {
				diff.scl(1.0f/count);
			}
			
			Vector2 v4 = diff.nor();
			
			// Nova Velocidade
			velocity.set(0,0);
			velocity.add(v1.scl(0.2f));
			velocity.add(v2.scl(0.3f));
			velocity.add(v3.scl(0.05f));
			velocity.add(v4.scl((fitness > 0.2f) ? 0.1f : 0.01f));
			
			position.add(velocity.cpy().scl(GameClock.instance.getDelta()));
			
			fitness = fitness();
			
			if (fitness < pBest.dst(FoodSource.food)) {
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
		return position.dst(FoodSource.food);
	}

	@Override
	public void draw() {
		TextureRegion Tx = null;
		
		float a = velocity.angle();
		
		if (a < 45 || a > 315) {
			Tx = AssestsLoader.instance.zombieWalkingRight.getKeyFrame(GameClock.instance.getRunTime());
		}
		
		if (a > 45 && a < 135) {
			Tx = AssestsLoader.instance.zombieWalkingDown.getKeyFrame(GameClock.instance.getRunTime());
		}
		
		if (a > 135 && a < 215) {
			Tx = AssestsLoader.instance.zombieWalkingLeft.getKeyFrame(GameClock.instance.getRunTime());
		}
		
		if (a > 215 && a < 315) {
			Tx = AssestsLoader.instance.zombieWalkingUp.getKeyFrame(GameClock.instance.getRunTime());
		}
		
		GameRenderer.instance.spriteRenderer.draw(Tx,
												  position.x - width / 2, position.y - height / 2,
												  width / 2 , height / 2,
												  width     , height,
												  1f         , 1f,
												  rotation);
		/*GameRenderer.instance.shapeRenderer.begin(ShapeType.Filled);
		GameRenderer.instance.shapeRenderer.setColor(color);
		GameRenderer.instance.shapeRenderer.circle(position.x, position.y, 0.1f, 12);
		GameRenderer.instance.shapeRenderer.end();
		GameRenderer.instance.shapeRenderer.begin(ShapeType.Line);
		GameRenderer.instance.shapeRenderer.setColor(color);
		GameRenderer.instance.shapeRenderer.circle(position.x, position.y, l/2, 24);
		GameRenderer.instance.shapeRenderer.end();
		GameRenderer.instance.shapeRenderer.setColor(color);
		GameRenderer.instance.shapeRenderer.begin(ShapeType.Line);
		GameRenderer.instance.shapeRenderer.line(position, position.cpy().add(velocity.cpy().nor().scl(0.25f)));
		GameRenderer.instance.shapeRenderer.end();
		
		if (flag) {
			GameRenderer.instance.shapeRenderer.begin(ShapeType.Line);
			GameRenderer.instance.shapeRenderer.setColor(color);
			for (int i = 0 ; i < path.size - 1 ; i++) {
				GameRenderer.instance.shapeRenderer.line(path.get(i), path.get(i+1));
			}
			
			GameRenderer.instance.shapeRenderer.end();
		}*/
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
