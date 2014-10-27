package com.teratorns.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
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
	
	private TextureAtlas guiAtlas;
	private TextureAtlas iconsAtlas;

	private TextureAtlas antAtlas;
	public Animation antWalking;
	
	public TextureRegion circle;
	public TextureRegion arrow;
	public TextureRegion grass;
	public TextureRegion flag;
	
	public TextureRegion panelblueTransSideLeft;
	public TextureRegion panelblueTransSideRight;
	public TextureRegion panelblueTransSideTop;
	public TextureRegion panelblueTransSideBottom;
	public TextureRegion panelblueTransCornerLeftTop;
	public TextureRegion panelblueTransCornerRightTop;
	public TextureRegion panelblueTransCornerLeftBottom;
	public TextureRegion panelblueTransCornerRightBottom;
	public TextureRegion panelblueTransCenter;
	
	public TextureRegion greenButton;
	
	public TextureRegion buttonBlueLeft;
	public TextureRegion buttonBlueRight;
	public TextureRegion buttonBlueMiddle;
	
	public Sound horrorAmbientMusic;
	
	public BitmapFont kenneyFont;
	
	public TextureRegion baseColor;
	
	public TextureRegion startIcon;
	public TextureRegion stopIcon;
	public TextureRegion pauseIcon;
	public TextureRegion plusIcon;
	public TextureRegion minusIcon;
	public TextureRegion refreshIcon;
	public TextureRegion ObjectiveIcon;
	public TextureRegion txa;
	public TextureRegion food;
	
	private AssetsLoader() {
		System.out.println("Assets Loader Created");
	}
	
	/** Load assets */
	public void loadAssets() {
		antAtlas = new TextureAtlas(Gdx.files.internal(Constants.TX_ANT_MAP));
		
		for (Texture t : antAtlas.getTextures()) {
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}
		
		Array<TextureRegion> antTextures = new Array<TextureRegion>();
		
		
		for (int i = 1 ; i < 4 ; i++) {
			txa = antAtlas.findRegion("ant" + i);
			txa.flip(false, true);
			antTextures.add(txa);
		}
		
		food = antAtlas.findRegion("food");
		
		TextureRegion[] walking  = {antTextures.get(0), antTextures.get(1), antTextures.get(2)};
		
		antWalking = new Animation(0.2f, walking);
		antWalking.setPlayMode(Animation.PlayMode.LOOP);

		//////////////////////
		
		horrorAmbientMusic = Gdx.audio.newSound(Gdx.files.internal("fx/horror.mp3"));
		
		loadUiAssets();
		
		loadFonts();
	}
	
	public void loadUiAssets() {
		guiAtlas = new TextureAtlas(Gdx.files.internal(Constants.TX_GUI_MAP));

		for (Texture t : guiAtlas.getTextures()) {
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}
		
		panelblueTransSideLeft = guiAtlas.findRegion("blue_trans_side_left");
		panelblueTransSideLeft.flip(false, true);
		panelblueTransSideRight = guiAtlas.findRegion("blue_trans_side_right");
		panelblueTransSideRight.flip(false, true);
		panelblueTransSideTop = guiAtlas.findRegion("blue_trans_side_top");
		panelblueTransSideTop.flip(false, true);
		panelblueTransSideBottom = guiAtlas.findRegion("blue_trans_side_bottom");
		panelblueTransSideBottom.flip(false, true);
		panelblueTransCenter = guiAtlas.findRegion("blue_trans_center");
		panelblueTransCornerLeftTop = guiAtlas.findRegion("blue_trans_left_top");
		panelblueTransCornerLeftTop.flip(false, true);
		panelblueTransCornerRightTop = guiAtlas.findRegion("blue_trans_right_top");
		panelblueTransCornerRightTop.flip(false, true);
		panelblueTransCornerLeftBottom = guiAtlas.findRegion("blue_trans_left_bottom");
		panelblueTransCornerLeftBottom.flip(false, true);
		panelblueTransCornerRightBottom = guiAtlas.findRegion("blue_trans_right_bottom");
		panelblueTransCornerRightBottom.flip(false, true);
		
		buttonBlueLeft = guiAtlas.findRegion("button_blue_left");
		buttonBlueRight = guiAtlas.findRegion("button_blue_right");
		buttonBlueMiddle = guiAtlas.findRegion("button_blue_mid");
		
		
		baseColor = new TextureRegion(new Texture(Gdx.files.internal("gui/base_color.png")));
		
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
		ObjectiveIcon = iconsAtlas.findRegion("objective");
		ObjectiveIcon.flip(false, true);
	}
	
	public void loadFonts() {
		 kenneyFont = new BitmapFont(Gdx.files.internal("fnt/fnt.fnt"), Gdx.files.internal("fnt/fnt.png"), true);
	}
	
	/** Dispose loaded assets */
	public void disposeAssests() {
		antAtlas.dispose();
		guiAtlas.dispose();
		iconsAtlas.dispose();
		kenneyFont.dispose();
		horrorAmbientMusic.dispose();
	}
}
