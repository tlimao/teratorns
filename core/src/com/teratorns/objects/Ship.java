package com.teratorns.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.utils.AnimationController;
import com.badlogic.gdx.graphics.g3d.utils.AnimationController.AnimationDesc;
import com.badlogic.gdx.graphics.g3d.utils.AnimationController.AnimationListener;
import com.teratorns.assets.AssestsLoader;
import com.teratorns.game.GameRenderer3D;

public class Ship extends GameObject3D {
    private ModelInstance instance;
    private AnimationController controller;
	
	public Ship(float x, float y, float z) {
		super(x, y, z);
		
        instance = new ModelInstance(AssestsLoader.instance.shipModel);
        
        /*/ You use an AnimationController to um, control animations.  Each control is tied to the model instance
        controller = new AnimationController(instance);  
        // Pick the current animation by name
        controller.setAnimation("Bend",1, new AnimationListener(){

            @Override
            public void onEnd(AnimationDesc animation) {
                // this will be called when the current animation is done. 
                // queue up another animation called "balloon". 
                // Passing a negative to loop count loops forever.  1f for speed is normal speed.
                controller.queue("balloon", -1, 1f, null, 0f);
            }

            @Override
            public void onLoop(AnimationDesc animation) {
                // TODO Auto-generated method stub
                
            }
            
        });*/
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void draw() {
		GameRenderer3D.instance.modelBatch.render(instance);
	}
	
	public void draw(Environment environment) {
		//controller.update(Gdx.graphics.getDeltaTime());
		GameRenderer3D.instance.modelBatch.render(instance, environment);
	}

	@Override
	public void dispose() {
		System.out.println("Cube disposed!");
	}
}
