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
	
	private TextureAtlas zombieAtlas;
	private TextureAtlas guiAtlas;
	
	public Animation zombieWalkingDown;
	public Animation zombieWalkingUp;
	public Animation zombieWalkingLeft;
	public Animation zombieWalkingRight;
	
	public TextureRegion circle;
	public TextureRegion arrow;
	public TextureRegion grass;
	
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

	private AssestsLoader() {
		System.out.println("Assets Loader Created");
	}
	
	/** Load assets */
	public void loadAssets() {
		zombieAtlas = new TextureAtlas(Gdx.files.internal(Constants.TX_ZOMBIE_MAP));

		for (Texture t : zombieAtlas.getTextures()) {
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}
		
		Array<TextureRegion> zombieTextures = new Array<TextureRegion>();
		TextureRegion tx;
		
		for (int i = 1 ; i < 7 ; i++) {
			tx = zombieAtlas.findRegion("zf" + i);
			tx.flip(false, true);
			zombieTextures.add(tx);
		}
		
		for (int i = 1 ; i < 5 ; i++) {
			tx = zombieAtlas.findRegion("zb" + i);
			tx.flip(false, true);
			zombieTextures.add(tx);
		}
		
		for (int i = 1 ; i < 4 ; i++) {
			tx = zombieAtlas.findRegion("zl" + i);
			tx.flip(false, true);
			zombieTextures.add(tx);
		}
		
		for (int i = 1 ; i < 4 ; i++) {
			tx = zombieAtlas.findRegion("zr" + i);
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
		
		circle = zombieAtlas.findRegion("circle");
		grass = zombieAtlas.findRegion("grass");
		arrow = zombieAtlas.findRegion("arrow");
		
		horrorAmbientMusic = Gdx.audio.newSound(Gdx.files.internal("fx/horror.mp3"));
		
		loadUiAssets();
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
	}
	
	/** Dispose loaded assets */
	public void disposeAssests() {
		zombieAtlas.dispose();
		guiAtlas.dispose();
		horrorAmbientMusic.dispose();
	}
}
