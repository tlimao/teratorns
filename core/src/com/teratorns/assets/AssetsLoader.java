package com.teratorns.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.teratorns.utils.Constants;

public class AssetsLoader {
	// Singleton
	public static AssetsLoader instance = new AssetsLoader();
	
	public TextureRegion teratorns;
	public Sound click;

	// Simple Font File for tests (Credits to Kenney)
	public BitmapFont kenneyFont;
	
	// Assets use for GUI
	public TextureRegion baseColor;
	
	private AssetsLoader() {
		System.out.println("Assets Loader Created");
		
		loadGuiAssets();
		
		loadAssets();
	}
	
	/** Base assets for GUI **/
	private void loadGuiAssets() {
		baseColor = new TextureRegion(new Texture(Gdx.files.internal(Constants.BASE_COLOR)));
		kenneyFont = new BitmapFont(Gdx.files.internal(Constants.KENNEY_BASE_FONT), Gdx.files.internal(Constants.KENNEY_BASE_TX), true);
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
