package com.teratorns.game.logic;

import java.util.HashMap;

import com.badlogic.gdx.math.Vector2;

public class CopyOfPheromoneLogic {
	
	public static CopyOfPheromoneLogic instance = new CopyOfPheromoneLogic();
	public HashMap<Vector2, Vector2> pheromoneMap = new HashMap<Vector2, Vector2>();
	
	public CopyOfPheromoneLogic() {
		startMap();
	}
	
	public Vector2 calculatePosition(Vector2 realPosition){
		Vector2 gridPosition = new Vector2();
		gridPosition.x = (float) Math.floor(realPosition.x/ColonyVariables.instance.gridWidthSize);
		gridPosition.y = (float) Math.floor(realPosition.y/ColonyVariables.instance.gridHeightSize);
		return gridPosition;
	}
	
	public void startMap(){
		for(int i = 0; i < ColonyVariables.instance.splitFactor; i++){
			pheromoneMap.put(new Vector2(i,-1), new Vector2(0,100));
			pheromoneMap.put(new Vector2(i,ColonyVariables.instance.gridHeightSize), new Vector2(0,-100));
			for(int j = 0; j < ColonyVariables.instance.splitFactor; j++){
				pheromoneMap.put(new Vector2(i,j), new Vector2(0,0));
				pheromoneMap.put(new Vector2(-1,j), new Vector2(100,0));
				pheromoneMap.put(new Vector2(ColonyVariables.instance.gridWidthSize,j), new Vector2(-100,0));
				
			}
		}
	}
}
