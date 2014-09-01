package com.teratorns.interaction;

public interface Interactor<T> {
	
	public boolean isTouched(T obj);
	
	public void drawInteractor();
}
