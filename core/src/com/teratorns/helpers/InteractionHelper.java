package com.teratorns.helpers;

import com.teratorns.game.GameOptions;
import com.teratorns.game.GameWorld;

public class InteractionHelper {
	
	private GameWorld gameWorld;
	private GameOptions gameOptions;
	private PlayerHelper playerHelper;
	
	public InteractionHelper(GameWorld gameWorld, 
							 PlayerHelper playerHelper,
							 GameOptions gameOptions) {
		this.gameWorld = gameWorld;
		this.playerHelper = playerHelper;
		this.gameOptions = gameOptions;
	}
}
