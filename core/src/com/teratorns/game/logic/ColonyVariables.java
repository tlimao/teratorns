package com.teratorns.game.logic;

import com.badlogic.gdx.math.Vector2;
import com.teratorns.objects.Colony;
import com.teratorns.utils.Constants;


public class ColonyVariables {

	//singleton
	public static ColonyVariables instance = new ColonyVariables();
	public Colony colony;
	public float robustness = 0.5f;
	public float maxVelocity = 3f;
	public Vector2 colonyPosition = new Vector2(0,0);
	public float splitFactor = 40f;
	public float gridWidthSize = Constants.viewportWidth/splitFactor;;
	public float gridHeightSize = Constants.viewportHeight/splitFactor;
	public int limitOfSteps = (int) (splitFactor*splitFactor/2);
	public float inertiaFactor = 1f;
	public float aleatoryFactor = 0.1f;
	public float pheromoneFactor = 60f;
	public float pheromoneAddFactor = 20f;
	public int antsNumber = 1000;
	public float raio = 0.05f;
	public float maxPheromone = 100;
	public float minPheromone = 1;
	public float evaporateFactor;
	//public float evaporateFactor = .999f;

	public void reset(){
		maxVelocity = 3;
	}

}
