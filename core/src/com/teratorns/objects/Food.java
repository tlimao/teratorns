package com.teratorns.objects;

import com.teratorns.assets.AssetsLoader;
import com.teratorns.game.GameRenderer;
import com.teratorns.game.logic.ColonyVariables;

public class Food extends GameObject{
	
	Colony colony;
	public Food(float f, float g){
		super(f*ColonyVariables.instance.gridWidthSize + ColonyVariables.instance.gridWidthSize/2, g*ColonyVariables.instance.gridHeightSize + ColonyVariables.instance.gridHeightSize/2);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void draw() {
		GameRenderer.instance.spriteRenderer.setColor(0.5f,0,1, 1);
		GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.food,
												  position.x - width*4 / 2, position.y - height*4 / 2,
												  width*4 / 2 , height*4 / 2,
												  width*4     , height*4,
												  0.5f      , 0.5f,
												  velocity.angle());
	}

	public void setColony(Colony colony) {
		this.colony = colony;
	}
	
}
