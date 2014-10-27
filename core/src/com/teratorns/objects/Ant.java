package com.teratorns.objects;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.math.Vector2;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.game.GameClock;
import com.teratorns.game.GameRenderer;
import com.teratorns.game.logic.ColonyVariables;
import com.teratorns.game.logic.PheromoneLogic;
import com.teratorns.utils.Constants;

public class Ant extends GameObject{
	Vector2 gridPosition;
	//Vector2 lastGridPosition;
	ArrayList<Vector2> path = new ArrayList<Vector2>();
	Colony colony;
	Boolean type = false;
	ArrayList<Vector2> directions = new ArrayList<Vector2>();
	int size = 1;
	Vector2 aim = getCellCenter(ColonyVariables.instance.colonyPosition);
	Boolean searching = true;
	Boolean food = false;
	Boolean success = false;
	Boolean giveUp = false;
	
	
	
	
	
	public Ant(){
		super(ColonyVariables.instance.colonyPosition.x + ColonyVariables.instance.gridWidthSize/2, ColonyVariables.instance.colonyPosition.y + ColonyVariables.instance.gridHeightSize/2);
		this.path.add(ColonyVariables.instance.colonyPosition);
		velocity.x = 0;
		velocity.y = 0;
		gridPosition = ColonyVariables.instance.colonyPosition;
		//lastGridPosition = new Vector2(-10,-10);
		
	}

	@Override
	public void update(){
		if(isOut()){
//			System.out.println("is out!");
			//velocity.scl(-1);
			giveUp = true;
		}
		if(giveUp){
			searching = false;
//			System.out.println("giving up");
			aim.set(getCellCenter(ColonyVariables.instance.colonyPosition));
//			if(aim.x < 0 || aim.y < 0){
//				System.out.println("aim -> colony :" + this.aim);
//			}
			giveUp = false;
		}
		else{
			gridPosition = PheromoneLogic.instance.calculateGridPosition(position);
			if(position.dst(aim) < ColonyVariables.instance.raio){
				if(searching){
					size++;
					if(size == ColonyVariables.instance.limitOfSteps){
						giveUp = true;
					}
					if(PheromoneLogic.instance.calculateGridPosition(this.colony.food.position).equals(gridPosition)){
						//velocity.set(0,0);
//						System.out.println("find food");
						food = true;
						searching = false;
						spreadPheromone();
						setAim(false);
//						System.out.println(aim);
					}
					else{
						setAim(true);
					}
				}
				else{
//					System.out.println("backing");
					if(food){
//						System.out.println("releasing pheromone");
						spreadPheromone();
					}
					if(gridPosition.equals(ColonyVariables.instance.colonyPosition)){
//						System.out.println("im home");
						//velocity.set(0,0);
						food = false;
						searching = true;
						path.clear();
						path.add(ColonyVariables.instance.colonyPosition);
						size = 0;
						giveUp = false;
					}
					else{
						setAim(false);
					}
					
				}
			}
			updateVelocity();
		}
	}
			
			

	@Override
	public void draw() {
		if(!type){
			GameRenderer.instance.spriteRenderer.setColor(0, 0, 0, 0.3f);
		}
		else{
			GameRenderer.instance.spriteRenderer.setColor(1, 0, 0, 0.3f);
		}
			GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.txa,
													  position.x - width / 2, position.y - height / 2,
													  width / 2 , height / 2,
													  width     , height,
													  0.5f      , 0.5f,
													  velocity.angle()*3);
	}
	
	public void setColony(Colony colony) {
		this.colony = colony;
	}
	
	public void updateVelocity(){
		//Vector2 randomVelocity = new Vector2((float) Math.random()-0.5f, (float)Math.random()-0.5f);
		velocity.set(aim.cpy().sub(position));
		//velocity.set(velocity.cpy().scl(ColonyVariables.instance.inertiaFactor).add(randomVelocity.cpy().scl(ColonyVariables.instance.aleatoryFactor)).add(aim.cpy().sub(position).scl(ColonyVariables.instance.pheromoneFactor)));
		velocity.set(velocity.cpy().nor().scl(ColonyVariables.instance.maxVelocity));
		position.add(velocity.cpy().scl(GameClock.instance.getDelta()));
	}
	
	public Vector2 getCellCenter(Vector2 grid){
		return new Vector2(grid.cpy().x*ColonyVariables.instance.gridWidthSize + ColonyVariables.instance.gridWidthSize/2, grid.cpy().y*ColonyVariables.instance.gridHeightSize + ColonyVariables.instance.gridHeightSize/2);
	}
	
	public void spreadPheromone(){
		Number actualPheromone = PheromoneLogic.instance.pheromoneMap.remove(gridPosition);
		if(actualPheromone == null){
			actualPheromone = 0;
		}
		float floatActualPheromone = actualPheromone.floatValue();
		
		floatActualPheromone+=(1f/size)*ColonyVariables.instance.pheromoneAddFactor;
		if(floatActualPheromone > ColonyVariables.instance.maxPheromone){
			floatActualPheromone = ColonyVariables.instance.maxPheromone;
		}
		PheromoneLogic.instance.pheromoneMap.put(gridPosition, floatActualPheromone);
	}
	
	public Boolean isOut(){
		if(position.x < -0.2f || position.x > (Constants.viewportWidth +.2f)){
			return true;
		}
		if(position.y < -0.2f || position.y > (Constants.viewportHeight + .2f)){
			return true;
		}
		return false;
	}
	
	public Boolean validGrid(Vector2 gp){
		if(gp.x < 0 || gp.x >= ColonyVariables.instance.splitFactor){
			return false;
		}
		if(gp.y < 0 || gp.y >= ColonyVariables.instance.splitFactor){
			return false;
		}
		return true;
	}
	
	public void setAim(Boolean next){
		if(next){
			HashMap<Integer, Integer> notNullDirections = new HashMap<Integer, Integer>();
			ArrayList<Float> prob = new ArrayList<Float>();
			ArrayList<Vector2> directions = new ArrayList<Vector2>();
			directions.add(0, new Vector2(gridPosition.x-1, gridPosition.y-1));
			directions.add(1, new Vector2(gridPosition.x, gridPosition.y-1));
			directions.add(2, new Vector2(gridPosition.x+1, gridPosition.y-1));
			directions.add(3, new Vector2(gridPosition.x-1, gridPosition.y));
			directions.add(4, new Vector2(gridPosition.x+1, gridPosition.y));
			directions.add(5, new Vector2(gridPosition.x-1, gridPosition.y+1));
			directions.add(6, new Vector2(gridPosition.x, gridPosition.y+1));
			directions.add(7, new Vector2(gridPosition.x+1, gridPosition.y+1));
			float soma = 0;
			int j = 0;
			for(int i = 0; i < 8; i++){
				if( (validGrid(directions.get(i))) && !(path.contains(directions.get(i))) ){
					prob.add(j, PheromoneLogic.instance.pheromoneMap.get(directions.get(i)));
					soma+=(prob.get(j)*prob.get(j));
					notNullDirections.put(j, i);
					j++;
				}
			}

			if(soma == 0){
				giveUp = true;
				return;
			}
			
			for(int i = 0; i < prob.size(); i++){
				prob.set(i, (prob.get(i)*prob.get(i))/soma);
			}
			
			float lucky = (float) Math.random();
			int random = 0;
			float tax = prob.get(0);
			while(lucky > tax){
				lucky-=tax;
				random++;
				tax = prob.get(random);
			}
			path.add(directions.get(notNullDirections.get(random)));
			aim.set(getCellCenter(directions.get(notNullDirections.get(random))));
//			if(aim.x < 0 || aim.y < 0){
//				System.out.println("aim -> next: " + this.aim);
//			}
		}
		else{
			if(path.size() <= 1){
				giveUp = true;
			}
			else{
				//path.remove(path.size() - 1);
				aim.set(getCellCenter(path.remove(path.size() - 1)));
//				if(aim.x < 0 || aim.y < 0){
//					System.out.println("aim -> back: " + this.aim);
//				}
			}
		}
	}
	
}
