package com.teratorns.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.teratorns.utils.Constants;

public class AssestsLoader {
	// Singleton
	public static AssestsLoader instance = new AssestsLoader();
	
	private TextureAtlas zombieSprites;
	
	public Animation zombieWalkingDown;
	public Animation zombieWalkingUp;
	public Animation zombieWalkingLeft;
	public Animation zombieWalkingRight;
	
	public TextureRegion circle;
	public TextureRegion arrow;
	public TextureRegion grass;
	
	public Sound horrorAmbientMusic;

	private AssestsLoader() {
		System.out.println("Assets Loader Created");
	}
	
	/** Load assets */
	public void loadAssets() {
		zombieSprites = new TextureAtlas(Gdx.files.internal(Constants.TX_ZOMBIE_MAP));

		for (Texture t : zombieSprites.getTextures()) {
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}
		
		Array<TextureRegion> zombieTextures = new Array<TextureRegion>();
		TextureRegion tx;
		
		for (int i = 1 ; i < 7 ; i++) {
			tx = zombieSprites.findRegion("zf" + i);
			tx.flip(false, true);
			zombieTextures.add(tx);
		}
		
		for (int i = 1 ; i < 5 ; i++) {
			tx = zombieSprites.findRegion("zb" + i);
			tx.flip(false, true);
			zombieTextures.add(tx);
		}
		
		for (int i = 1 ; i < 4 ; i++) {
			tx = zombieSprites.findRegion("zl" + i);
			tx.flip(false, true);
			zombieTextures.add(tx);
		}
		
		for (int i = 1 ; i < 4 ; i++) {
			tx = zombieSprites.findRegion("zr" + i);
			tx.flip(false, true);
			zombieTextures.add(tx);
		}
	
		TextureRegion[] walkingDown  = {zombieTextures.get(0), zombieTextures.get(1), zombieTextures.get(2),
										zombieTextures.get(3), zombieTextures.get(4), zombieTextures.get(5)};
		
		TextureRegion[] walkingUp    = {zombieTextures.get(6), zombieTextures.get(7),
										zombieTextures.get(8), zombieTextures.get(9)};
		
		TextureRegion[] walkingLeft  = {zombieTextures.get(10), zombieTextures.get(11), zombieTextures.get(12)};
		
		TextureRegion[] walkingRight = {zombieTextures.get(13), zombieTextures.get(14), zombieTextures.get(15)};
		
		zombieWalkingDown = new Animation(0.2f, walkingDown);
		zombieWalkingDown.setPlayMode(Animation.PlayMode.LOOP);
		
		zombieWalkingUp = new Animation(0.2f, walkingUp);
		zombieWalkingUp.setPlayMode(Animation.PlayMode.LOOP);
		
		zombieWalkingLeft = new Animation(0.2f, walkingLeft);
		zombieWalkingLeft.setPlayMode(Animation.PlayMode.LOOP);
		
		zombieWalkingRight = new Animation(0.2f, walkingRight);
		zombieWalkingRight.setPlayMode(Animation.PlayMode.LOOP);
		
		circle = zombieSprites.findRegion("circle");
		grass = zombieSprites.findRegion("grass");
		arrow = zombieSprites.findRegion("arrow");
		
		horrorAmbientMusic = Gdx.audio.newSound(Gdx.files.internal("fx/horror ambient.mp3"));
	}
	
	/** Dispose loaded assets */
	public void disposeAssests() {
		zombieSprites.dispose();
		horrorAmbientMusic.dispose();
	}
}
