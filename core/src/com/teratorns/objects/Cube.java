package com.teratorns.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.teratorns.game.GameRenderer3D;

public class Cube extends GameObject3D {
	private Model model;
    private ModelInstance instance;
	
	public Cube(float x, float y, float z) {
		super(x, y, z);
		
		ModelBuilder modelBuilder = new ModelBuilder();
		model = modelBuilder.createBox(5f, 5f, 5f, 
                new Material(ColorAttribute.createDiffuse(Color.GREEN)),
                Usage.Position | Usage.Normal);
        instance = new ModelInstance(model);
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
		GameRenderer3D.instance.modelBatch.render(instance, environment);
	}

	@Override
	public void dispose() {
		System.out.println("Cube disposed!");
		model.dispose();
	}
}
