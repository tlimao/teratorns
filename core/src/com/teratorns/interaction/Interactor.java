package com.teratorns.interaction;

public interface Interactor<T> {
	
    /** T is a poligon that is used to detect interaction. Eg.: A button will have a retangle as interactor */
	public boolean isTouched(T obj);
	
    /** Implement this method if you want to debug the interactor ( position, size, ... ) */
	public void drawInteractor();
}
