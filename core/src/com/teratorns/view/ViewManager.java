package com.teratorns.view;

import com.badlogic.gdx.utils.Array;

public class ViewManager {
	public static ViewManager instance = new ViewManager();
	
	public Array<View> views;
	
	private ViewManager() {
		views = new Array<View>();
	}
	
	public void addView(View view) {
		views.add(view);
	}
	
	public void clear() {
		views.clear();
	}
}
