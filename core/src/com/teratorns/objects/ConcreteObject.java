package com.teratorns.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.teratorns.game.GameClock;
import com.teratorns.game.GameRenderer;
import com.teratorns.interaction.Interactor;
import com.teratorns.utils.Constants;

public class ConcreteObject extends GameObject implements Interactor<Rectangle> {

	private Rectangle interactionRect;
	private Color color;
	private Swarm swarm;
	
	private Vector2 aim;
	private Vector2 pBest;
	private float maxForce;
	private Vector2 maxVelocity;
	private boolean flag;
	
	private Array<Vector2> patch;
	
	public ConcreteObject(float x, float y) {
		super(x, y);
		
		interactionRect = new Rectangle(x, y, width, height);
		color = Color.RED;
		
		maxVelocity = new Vector2(3f, 3f);
		maxForce = 0.05f;
		aim = position.cpy();
		pBest = position.cpy();
		
		flag = false;
		
		patch = new Array<Vector2>();
	}
	
	public void setSwarm(Swarm swarm)
	{
		this.swarm = swarm;
	}

	@Override
	public boolean isTouched(Rectangle rect) {
		
		if (interactionRect.overlaps(rect)) {
			color = Color.GREEN;
			return true;
		}
		
		color = Color.RED;
		
		return false;	
	}
	
	@Override
	public void update() {
		// Analyze Swarm
		//swarmAnalyze(swarm.getParticles());
		
		if (!flag) {
			if (Math.random() > 0.8f) {
				aim.set((float) Math.random() * Constants.viewportWidth, (float) Math.random() * Constants.viewportHeight);
			}
			
			// Update position
			velocity.add(acceleration.add(goTo(aim)));
			velocity.nor().scl(maxVelocity);
			position.add(velocity.cpy().scl(GameClock.instance.getDelta()));
			
			// Adjust position
			if (position.x > Constants.viewportWidth){
				position.x = Constants.viewportWidth;
			} else if (position.x < 0){
				position.x = 0;
			}
			
			if (position.y > Constants.viewportHeight){
				position.y = Constants.viewportHeight;
			} else if (position.y < 0){
				position.y = 0;
			}
			
			acceleration.scl(0);
			
			// Update Interaction Rectangle
			interactionRect.setPosition(position);
	
			if (!flag) {
				patch.add(position.cpy());
			}
			
			if (position.cpy().dst(FoodSource.food) < 0.5f) {
				flag = true;
			}
		}
	}
	
	private void swarmAnalyze(Array<ConcreteObject> swarm)
	{
		// Calculate Repulsion, Alignment, Cohesion
		Vector2 repulsion = fRepulsion(swarm);
		//Vector2 alignment = fAlignment(swarm);
		//Vector2 cohesion = fCoesion(swarm);
		// Weights
		repulsion.scl(3);
		//alignment.scl(1);
		//cohesion.scl(0.9f);
		// Apply to acceleration
		acceleration.add(repulsion);
		//acceleration.add(alignment);
		//acceleration.add(cohesion);
	}
	
	public Vector2 fRepulsion(Array<ConcreteObject> swarm)
	{
		Vector2 fRepulsion = new Vector2();
		float dist = 2.5f;
		int count = 0;
		
		for (ConcreteObject unity : swarm) {
			float d = unity.position.dst(position);
			
			if (d > 0 && d < dist) {
				Vector2 diff = position.cpy().sub(unity.position);
				diff.nor().scl(1.0f/d);
				fRepulsion.add(diff);
				count++;
			}
		}
		
		if (count > 0) {
			fRepulsion.scl(1.0f/count);
		}
		
		if (fRepulsion.len() > 0) {
			fRepulsion.nor().scl(maxVelocity).sub(velocity).nor().scl(maxForce);
		}
		
		return fRepulsion;
	}
	
	private Vector2 goTo(Vector2 aim)
	{
		Vector2 steer;
		
		Vector2 destiny = aim.cpy().sub(position);
		
		float d = destiny.len();
		
		if (d > 0.5f) {
			destiny.nor();
			destiny.scl(maxVelocity);
			
			steer = destiny.sub(velocity);
			steer.nor().scl(maxForce);
		}
		
		else
		{
			steer = new Vector2(0,0);
			velocity = new Vector2(0,0);
		}
		
		return steer;
	}

	@Override
	public void drawInteractor() {
		GameRenderer.instance.shapeRenderer.begin(ShapeType.Line);
		GameRenderer.instance.shapeRenderer.setColor(color);
		GameRenderer.instance.shapeRenderer.rect(interactionRect.x, interactionRect.y, interactionRect.width, interactionRect.height);
		GameRenderer.instance.shapeRenderer.end();
	}

	@Override
	public void draw() {
		GameRenderer.instance.shapeRenderer.begin(ShapeType.Filled);
		GameRenderer.instance.shapeRenderer.setColor(color);
		GameRenderer.instance.shapeRenderer.circle(position.x, position.y, 0.1f, 12);
		GameRenderer.instance.shapeRenderer.end();
		GameRenderer.instance.shapeRenderer.begin(ShapeType.Line);
		GameRenderer.instance.shapeRenderer.line(position, position.cpy().add(velocity.cpy().nor().scl(0.25f)));
		GameRenderer.instance.shapeRenderer.end();
		
		if (flag) {
			GameRenderer.instance.shapeRenderer.begin(ShapeType.Line);
			GameRenderer.instance.shapeRenderer.setColor(color);
			for (int i = 0 ; i < patch.size - 1 ; i++) {
				GameRenderer.instance.shapeRenderer.line(patch.get(i), patch.get(i+1));
			}
			
			GameRenderer.instance.shapeRenderer.end();
		}
	}

}
