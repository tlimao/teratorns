package com.teratorns.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.teratorns.GameRun;
import com.teratorns.utils.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//config.width = Constants.windowWidth;
		//config.height = Constants.windowHeight;
		new LwjglApplication(new GameRun(), config);
	}
}
