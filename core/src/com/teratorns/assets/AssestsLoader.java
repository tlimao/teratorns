package com.teratorns.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssestsLoader {
	// Singleton
	public static AssestsLoader instance = new AssestsLoader();
	
	public TextureRegion[] sheep;
	public Animation sheepWalkingR;
	public Animation sheepWalkingL;
	public Sound sheepFx;

	private AssestsLoader() {
		System.out.println("Assets Loader Created");
	}
	
	/** Load assets */
	public void loadAssets() {
		sheep = new TextureRegion[4];
		
		sheep[0] = new TextureRegion(new Texture(Gdx.files.internal("gfx/sheep03.png")));
		sheep[1] = new TextureRegion(new Texture(Gdx.files.internal("gfx/sheep01.png")));
		sheep[2] = new TextureRegion(new Texture(Gdx.files.internal("gfx/sheep02.png")));
		sheep[3] = new TextureRegion(new Texture(Gdx.files.internal("gfx/sheep01.png")));
		
		sheep[0].flip(false, true);
		sheep[1].flip(false, true);
		sheep[2].flip(false, true);
		sheep[3].flip(false, true);
		
		sheepWalkingR = new Animation(0.1f, sheep);
		sheepWalkingR.setPlayMode(Animation.PlayMode.LOOP);
		
		sheep = new TextureRegion[4];
		
		sheep[0] = new TextureRegion(new Texture(Gdx.files.internal("gfx/sheep03.png")));
		sheep[1] = new TextureRegion(new Texture(Gdx.files.internal("gfx/sheep01.png")));
		sheep[2] = new TextureRegion(new Texture(Gdx.files.internal("gfx/sheep02.png")));
		sheep[3] = new TextureRegion(new Texture(Gdx.files.internal("gfx/sheep01.png")));
		
		sheep[0].flip(true, true);
		sheep[1].flip(true, true);
		sheep[2].flip(true, true);
		sheep[3].flip(true, true);
		
		sheepWalkingL = new Animation(0.1f, sheep);
		sheepWalkingL.setPlayMode(Animation.PlayMode.LOOP);
		
		sheepFx = Gdx.audio.newSound(Gdx.files.internal("fx/sheep.mp3"));
	}
	
	/** Dispose loaded assets */
	public void disposeAssests() {
		sheepFx.dispose();
	}
}
