package com.teratorns.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class AssetsLoader {
	// Singleton
	public static AssetsLoader instance = new AssetsLoader();
	
	public TextureRegion teratorns;
	public Sound click;
	
	// My Sprites
	private TextureAtlas fire_skull_atlas;
	public Animation fire_skull_animation_right;
	public Animation fire_skull_animation_left;
	
	public TextureRegion light_effect;

	private AssetsLoader() {
		System.out.println("Assets Loader Created");
		
		loadAssets();
	}
	
	/** Load assets */
	public void loadAssets() {
		// Load Assets (gfx, snd fx, etc) here ...
		Texture txTeratorns = new Texture(Gdx.files.internal("logo.png"));
		txTeratorns.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		teratorns = new TextureRegion(txTeratorns);
		teratorns.flip(false, true);
		
		click = Gdx.audio.newSound(Gdx.files.internal("click.mp3"));
		
		// My Sprites
		fire_skull_atlas = new TextureAtlas(Gdx.files.internal("gfx/fireskull.pack"));
		Array<TextureRegion> fire_skull_sprites_right = new Array<TextureRegion>();
		Array<TextureRegion> fire_skull_sprites_left = new Array<TextureRegion>();
		
		for (int i = 0; i < 4; i++) {
			TextureRegion skull_tx_right = fire_skull_atlas.findRegion("skull_right_" + (i+1));
			skull_tx_right.flip(false, true);
			fire_skull_sprites_right.add(skull_tx_right);

			TextureRegion skull_tx_left = fire_skull_atlas.findRegion("skull_left_" + (i+1));
			skull_tx_left.flip(false, true);
			fire_skull_sprites_left.add(skull_tx_left);
		}
		
		fire_skull_animation_right = new Animation(0.2f, fire_skull_sprites_right, PlayMode.LOOP);
		fire_skull_animation_left = new Animation(0.2f, fire_skull_sprites_left, PlayMode.LOOP);
		
		light_effect = new TextureRegion(new Texture(Gdx.files.internal("gfx/light.png")));
	}
	
	/** Dispose loaded assets */
	public void disposeAssests() {
		// Dispose all Assests Here
		click.dispose();
	}
}
