package com.teratorns.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.teratorns.utils.Constants;

public class AssetsLoader {
	// Singleton
	public static AssetsLoader instance = new AssetsLoader();
	
	// Fotos
	public TextureRegion travel;
	public TextureRegion f5;
	public TextureRegion teratorns;
	public Sound click;
	public Music robertoRibeiro;

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
		
		Texture txTravel = new Texture(Gdx.files.internal("travel.jpg"));
		txTravel.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		travel = new TextureRegion(txTravel);
		travel.flip(false, true);
		
		Texture txF5 = new Texture(Gdx.files.internal("f5.png"));
		txF5.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		f5 = new TextureRegion(txF5);
		f5.flip(false, true);
		
		click = Gdx.audio.newSound(Gdx.files.internal("click.mp3"));
		
		robertoRibeiro = Gdx.audio.newMusic(Gdx.files.internal("snd/song.mp3"));
	}
	
	/** Dispose loaded assets */
	public void disposeAssests() {
		// Dispose all Assests Here
		click.dispose();
		robertoRibeiro.dispose();
	}
}
