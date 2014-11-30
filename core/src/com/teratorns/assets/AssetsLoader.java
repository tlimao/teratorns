package com.teratorns.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.teratorns.utils.Constants;

public class AssetsLoader {
	// Singleton
	public static AssetsLoader instance = new AssetsLoader();

	private TextureAtlas iconsAtlas;
	private TextureAtlas antAtlas;
	
	public Animation antAnimation;
	
	public BitmapFont kenneyFont;
	
	public TextureRegion circle;
	public TextureRegion baseColor;
	
	public TextureRegion startIcon;
	public TextureRegion stopIcon;
	public TextureRegion pauseIcon;
	public TextureRegion plusIcon;
	public TextureRegion minusIcon;
	public TextureRegion refreshIcon;
	public TextureRegion objectiveIcon;
	
	public TextureRegion boid;
	
	private AssetsLoader() {
		System.out.println("Assets Loader Created");
	}
	
	/** Load assets */
	public void loadAssets() {
		loadBaseUiAssets();
		
		loadUiIcons();
		
		loadFonts();
		
		loadPsoAssets();
		
		loadAnt();
	}
	
	private void loadBaseUiAssets() {
		baseColor = new TextureRegion(new Texture(Gdx.files.internal(Constants.BASE_COLOR)));
	}
		
	private void loadUiIcons() {
		iconsAtlas = new TextureAtlas(Gdx.files.internal(Constants.TX_ICONS_MAP));

		for (Texture t : iconsAtlas.getTextures()) {
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}
		
		startIcon = iconsAtlas.findRegion("play");
		startIcon.flip(false, true);
		stopIcon = iconsAtlas.findRegion("stop");
		stopIcon.flip(false, true);
		pauseIcon = iconsAtlas.findRegion("stop");
		pauseIcon.flip(false, true);
		plusIcon = iconsAtlas.findRegion("plus");
		plusIcon.flip(false, true);
		minusIcon = iconsAtlas.findRegion("minus");
		minusIcon.flip(false, true);
		refreshIcon = iconsAtlas.findRegion("refresh");
		refreshIcon.flip(false, true);
		objectiveIcon = iconsAtlas.findRegion("objective");
		objectiveIcon.flip(false, true);
	}
	
	private void loadFonts() {
		 kenneyFont = new BitmapFont(Gdx.files.internal(Constants.KENNEY_BASE_FONT), Gdx.files.internal(Constants.KENNEY_BASE_TX), true);
	}
	
	private void loadPsoAssets() {
		Texture txBoid = new Texture(Gdx.files.internal(Constants.TX_BOID));
		txBoid.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		boid = new TextureRegion(txBoid);
		
		Texture txCircle = new Texture(Gdx.files.internal(Constants.TX_CIRCLE));
		txCircle.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		circle = new TextureRegion(txCircle);
	}
	
	private void loadAnt() {
		antAtlas = new TextureAtlas(Gdx.files.internal("gfx/ant/antpack.pack"));
		Array<TextureRegion> antAnim = new Array<TextureRegion>();
		
		for (Texture t : antAtlas.getTextures()) {
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}
		
		antAnim.add(antAtlas.findRegion("ant1"));
		antAnim.add(antAtlas.findRegion("ant2"));
		antAnim.add(antAtlas.findRegion("ant3"));
		antAnim.add(antAtlas.findRegion("ant2"));
		
		antAnimation = new Animation(0.1f, antAnim);
		antAnimation.setPlayMode(Animation.PlayMode.LOOP);
	}
	
	/** Dispose loaded assets */
	public void disposeAssests() {
		iconsAtlas.dispose();
		antAtlas.dispose();
		kenneyFont.dispose();
		antAtlas.dispose();
	}
}
