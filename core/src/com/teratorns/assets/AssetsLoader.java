package com.teratorns.assets;

import sun.swing.BakedArrayList;

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
	
	public TextureRegion carol1;
	public TextureRegion carol2;
	public TextureRegion carol3;
	public TextureRegion carol4;
	public TextureRegion carol5;
	public TextureRegion carol6;
	public TextureRegion carol7;
	public TextureRegion carol8;
	
	public TextureRegion txt1;
	public TextureRegion txt2;
	
	public TextureRegion lC;
	public TextureRegion lA;
	public TextureRegion lR;
	public TextureRegion lO;
	public TextureRegion lL;
	public TextureRegion lI;
	public TextureRegion lN;
	
	public TextureRegion song;
	
	public TextureRegion background;
	
	public TextureRegion robertoCd;
	public TextureRegion elisCd;
	public TextureRegion chicoCd;
	public TextureRegion miltonCd;
	
	public Sound click;
	public Music roberto;
	public Music elis;
	public Music milton;
	public Music chico;

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
		
		Texture txSong = new Texture(Gdx.files.internal("song.png"));
		txSong.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		song = new TextureRegion(txSong);
		song.flip(false, true);
		
		Texture txBackground = new Texture(Gdx.files.internal("travelback.jpg"));
		txBackground.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		background = new TextureRegion(txBackground);
		background.flip(false, true);
		
		Texture txTravel = new Texture(Gdx.files.internal("travel.jpg"));
		txTravel.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		travel = new TextureRegion(txTravel);
		travel.flip(false, true);
		
		Texture txF5 = new Texture(Gdx.files.internal("f5.png"));
		txF5.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		f5 = new TextureRegion(txF5);
		f5.flip(false, true);
		
		Texture txCarol1 = new Texture(Gdx.files.internal("carol1.jpg"));
		txCarol1.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		carol1 = new TextureRegion(txCarol1);
		carol1.flip(false, true);
		
		Texture txCarol2 = new Texture(Gdx.files.internal("carol2.jpg"));
		txCarol2.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		carol2 = new TextureRegion(txCarol2);
		carol2.flip(false, true);
		
		Texture txCarol3 = new Texture(Gdx.files.internal("carol3.jpg"));
		txCarol3.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		carol3 = new TextureRegion(txCarol3);
		carol3.flip(false, true);
		
		Texture txCarol4 = new Texture(Gdx.files.internal("carol4.jpg"));
		txCarol4.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		carol4 = new TextureRegion(txCarol4);
		carol4.flip(false, true);
		
		Texture txCarol5 = new Texture(Gdx.files.internal("carol5.jpg"));
		txCarol5.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		carol5 = new TextureRegion(txCarol5);
		carol5.flip(false, true);
		
		Texture txCarol6 = new Texture(Gdx.files.internal("carol6.jpg"));
		txCarol6.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		carol6 = new TextureRegion(txCarol6);
		carol6.flip(false, true);
		
		Texture txCarol7 = new Texture(Gdx.files.internal("carol7.jpg"));
		txCarol7.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		carol7 = new TextureRegion(txCarol7);
		carol7.flip(false, true);
		
		Texture txCarol8 = new Texture(Gdx.files.internal("carol8.jpg"));
		txCarol8.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		carol8 = new TextureRegion(txCarol8);
		carol8.flip(false, true);
		
		Texture txRoberto = new Texture(Gdx.files.internal("roberto.jpg"));
		txRoberto.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		robertoCd = new TextureRegion(txRoberto);
		robertoCd.flip(false, true);
		
		Texture txMilton = new Texture(Gdx.files.internal("milton.jpg"));
		txMilton.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		miltonCd = new TextureRegion(txMilton);
		miltonCd.flip(false, true);
		
		Texture txElis = new Texture(Gdx.files.internal("elis.jpg"));
		txElis.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		elisCd = new TextureRegion(txElis);
		elisCd.flip(false, true);
		
		Texture txChico = new Texture(Gdx.files.internal("chico.jpg"));
		txChico.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		chicoCd = new TextureRegion(txChico);
		chicoCd.flip(false, true);
		
		Texture txlC = new Texture(Gdx.files.internal("c.png"));
		txlC.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		lC = new TextureRegion(txlC);
		lC.flip(false, true);
		
		Texture txlA = new Texture(Gdx.files.internal("a.png"));
		txlA.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		lA = new TextureRegion(txlA);
		lA.flip(false, true);
		
		Texture txlR = new Texture(Gdx.files.internal("r.png"));
		txlR.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		lR = new TextureRegion(txlR);
		lR.flip(false, true);
		
		Texture txlO = new Texture(Gdx.files.internal("o.png"));
		txlO.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		lO = new TextureRegion(txlO);
		lO.flip(false, true);
		
		Texture txlL = new Texture(Gdx.files.internal("l.png"));
		txlL.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		lL = new TextureRegion(txlL);
		lL.flip(false, true);
		
		Texture txlI = new Texture(Gdx.files.internal("i.png"));
		txlI.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		lI = new TextureRegion(txlI);
		lI.flip(false, true);
		
		Texture txlN = new Texture(Gdx.files.internal("n.png"));
		txlN.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		lN = new TextureRegion(txlN);
		lN.flip(false, true);
		
		Texture txTxt1 = new Texture(Gdx.files.internal("text1.png"));
		txTxt1.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		txt1 = new TextureRegion(txTxt1);
		txt1.flip(false, true);
		
		Texture txTxt2 = new Texture(Gdx.files.internal("text2.png"));
		txTxt2.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		txt2 = new TextureRegion(txTxt2);
		txt2.flip(false, true);
		
		click = Gdx.audio.newSound(Gdx.files.internal("click.mp3"));
		
		roberto = Gdx.audio.newMusic(Gdx.files.internal("snd/roberto.mp3"));
		elis = Gdx.audio.newMusic(Gdx.files.internal("snd/elis.mp3"));
		chico = Gdx.audio.newMusic(Gdx.files.internal("snd/chico.mp3"));
		milton = Gdx.audio.newMusic(Gdx.files.internal("snd/milton.mp3"));
	}
	
	/** Dispose loaded assets */
	public void disposeAssests() {
		// Dispose all Assests Here
		click.dispose();
		roberto.dispose();
		elis.dispose();
		chico.dispose();
		milton.dispose();
	}
}
