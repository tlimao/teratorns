package com.teratorns.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.teratorns.GameRun;
import com.teratorns.utils.Constants;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(Constants.windowWidth, Constants.windowHeight);
        }

        @Override
        public ApplicationListener getApplicationListener () {
                return new GameRun();
        }
}