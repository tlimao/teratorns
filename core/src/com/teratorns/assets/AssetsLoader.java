package com.teratorns.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetsLoader {
	// Singleton
	public static AssetsLoader instance = new AssetsLoader();
	
	public TextureRegion teratorns;
	public Sound click;

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
	}
	
	/** Dispose loaded assets */
	public void disposeAssests() {
		// Dispose all Assests Here
		click.dispose();
	}
}
