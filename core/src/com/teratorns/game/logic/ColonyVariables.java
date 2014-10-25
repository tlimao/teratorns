package com.teratorns.game.logic;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.teratorns.utils.Constants;


public class ColonyVariables {

	//singleton
	public static ColonyVariables instance = new ColonyVariables();
	
	public float robustness = 0.5f;
	public float maxVelocity = 5f;
	public float evaporation = 0.5f;
	public Vector2 colonyPosition = new Vector2(0,0);
	public ArrayList<Vector2> foodPositions = new ArrayList<Vector2>();
	public float splitFactor = 20f;
	public float gridWidthSize = Constants.viewportWidth/splitFactor;;
	public float gridHeightSize = Constants.viewportHeight/splitFactor;
	public int limitOfSteps = (int) (splitFactor*splitFactor/2);
	public float inertiaFactor = 1f;
	public float aleatoryFactor = 0.1f;
	public float pheromoneFactor = 5f;
	public float pheromoneAddFactor = 20f;
	public int sources = 1;
	public int antsNumber = 200;
	public float raio = 0.05f;
	public float maxPheromone = 100;
	public float minPheromone = 1;
	public float evaporateFactor = 0.999f;
	
}
