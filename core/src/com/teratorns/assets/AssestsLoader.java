package com.teratorns.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;

public class AssestsLoader {
	// Singleton
	public static AssestsLoader instance = new AssestsLoader();
	
	public Model shipModel;

	private AssestsLoader() {
		System.out.println("Assets Loader Created");
	}
	
	/** Load assets */
	public void loadAssets() {
		ModelLoader loader = new ObjLoader();
		shipModel = loader.loadModel(Gdx.files.internal("ship/ship.obj"));
	}
	
	/** Dispose loaded assets */
	public void disposeAssests() {
		shipModel.dispose();
	}
}
