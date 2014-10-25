package com.teratorns.game.logic;

import java.util.HashMap;
import java.util.Map.Entry;

import com.badlogic.gdx.math.Vector2;

public class PheromoneLogic {
	
	public static PheromoneLogic instance = new PheromoneLogic();
	public HashMap<Vector2, Float> pheromoneMap = new HashMap<Vector2, Float>();
	
	public PheromoneLogic() {
		startMap();
	}
	
	public Vector2 calculatePosition(Vector2 realPosition){
		Vector2 gridPosition = new Vector2();
		gridPosition.x = (float) Math.floor(realPosition.x/ColonyVariables.instance.gridWidthSize);
		gridPosition.y = (float) Math.floor(realPosition.y/ColonyVariables.instance.gridHeightSize);
		return gridPosition;
	}
	 
	public void startMap(){
//		pheromoneMap.put(new Vector2(-1,-1), 0f);
//		pheromoneMap.put(new Vector2(ColonyVariables.instance.gridWidthSize, ColonyVariables.instance.gridHeightSize), 0f);
//		for(int i = 0; i < ColonyVariables.instance.splitFactor; i++){
//			pheromoneMap.put(new Vector2(i,-1), 0f);
//			pheromoneMap.put(new Vector2(i,ColonyVariables.instance.gridHeightSize), 0f);
//			for(int j = 0; j < ColonyVariables.instance.splitFactor; j++){
//				pheromoneMap.put(new Vector2(i,j), 1f);
//				pheromoneMap.put(new Vector2(-1,j), 0f);
//				pheromoneMap.put(new Vector2(ColonyVariables.instance.gridWidthSize,j), 0f);
//				
//			}
//		}
		
	for(int i = 0; i < ColonyVariables.instance.splitFactor; i++){
		for(int j = 0; j < ColonyVariables.instance.splitFactor; j++){
			pheromoneMap.put(new Vector2(i,j), 1f);	
		}
	}
		System.out.println(pheromoneMap);
	}

	public void evaporate() {
		for (Entry<Vector2, Float> entry : pheromoneMap.entrySet()){
			float newPheromone = entry.getValue()*ColonyVariables.instance.evaporateFactor;
			if(newPheromone < ColonyVariables.instance.minPheromone){
				newPheromone = 1;
			}
		    pheromoneMap.put(entry.getKey(), newPheromone);
		}
	}
}
