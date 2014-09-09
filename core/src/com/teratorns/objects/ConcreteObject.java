package com.teratorns.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.teratorns.game.GameClock;
import com.teratorns.game.GameRenderer;
import com.teratorns.interaction.Interactor;
import com.teratorns.utils.Constants;

public class ConcreteObject extends GameObject implements Interactor<Rectangle> {

	private Rectangle interactionRect;
	private Color color;
	private Swarm swarm;
	
	private Vector2 aim;
	private float maxForce;
	private Vector2 maxVelocity;
	
	public static Vector2 meta = new Vector2(6, 6);
	private boolean flag;
	
	public ConcreteObject(float x, float y) {
		super(x, y);
		
		interactionRect = new Rectangle(x, y, width, height);
		color = Color.RED;
		
		maxVelocity = new Vector2(3f, 3f);
		maxForce = 0.05f;
		aim = position.cpy();
		
		flag = false;
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
		//swarmAnalyze(swarm);
		if (!flag) {
			if (Math.random() > 0.8f) {
				aim.set((float) Math.random() * Constants.viewportWidth, (float) Math.random() * Constants.viewportHeight);
			}
			// Update position
			//velocity.add(acceleration);
			velocity.add(acceleration.add(goTo(aim)));
			velocity.nor().scl(maxVelocity);
			position.add(velocity.cpy().scl(GameClock.instance.getDelta()));
			
			// Adjust position
			if (position.x > Constants.viewportWidth){
				position.x = 0;
			} else if (position.x < 0){
				position.x = Constants.viewportWidth;
			}
			
			if (position.y > Constants.viewportHeight){
				position.y = 0;
			} else if (position.y < 0){
				position.y = Constants.viewportHeight;
			}
			
			acceleration.scl(0);
			
			// Update Interaction Rectangle
			interactionRect.setPosition(position);
	
			System.out.println("d: " + position.dst(meta));
			if (position.cpy().dst(meta) < 0.5f) {
				flag = true;
			}
		}
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
		GameRenderer.instance.shapeRenderer.circle(position.x, position.y, 0.25f, 12);
		GameRenderer.instance.shapeRenderer.end();
	}

}
