package com.teratorns.assets;

public class AssestsLoader {
	// Singleton
	public static AssestsLoader instance = new AssestsLoader();

	private AssestsLoader() {
		System.out.println("Assets Loader Created");
	}
	
	/** Load assets */
	public void loadAssets() {
		// Load Assets (gfx, snd fx, etc) here ...
	}
	
	/** Dispose loaded assets */
	public void disposeAssests() {
		// Dispose all Assests Here
	}
}
