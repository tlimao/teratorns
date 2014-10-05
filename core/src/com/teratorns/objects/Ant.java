package com.teratorns.objects;

import java.util.ArrayList;

import com.badlogic.gdx.math.Rectangle;
import com.teratorns.interaction.Interactor;

public class Ant extends GameObject implements Interactor<Rectangle> {
	ArrayList<Integer> visited;
	int actualCity;
	int dist;
	
	Ant(int startCity){
		super(0,0);
		visited = new ArrayList<Integer>();
		actualCity = startCity;
		visited.add(startCity);
		dist = 0;
	}
	
	void update(int newActualCity, int travDist){
		actualCity = newActualCity;
		visited.add(actualCity);
		dist += travDist;
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

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}