package com.teratorns.view;

import com.badlogic.gdx.utils.Array;

public class ViewArray {
	public static ViewArray instance = new ViewArray();
	
	public Array<View> views;
	
	private ViewArray() {
		views = new Array<View>();
	}
	
	public void addView(View view) {
		views.add(view);
	}
	
	public void clear() {
		views.clear();
	}
}
