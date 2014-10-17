package com.kp.designpatterns.observator.javaapi;

import java.util.Observable;

public class Pogoda extends Observable {
	
	public void change() {
		setChanged();
	}

//	Inny sposób (bez wywo³ania metody setChanged())
//	
//	@Override
//	public void notifyObservers() {
//		setChanged();
//		super.notifyObservers();
//	}
//
//	@Override
//	public void notifyObservers(Object arg) {
//		setChanged();
//		super.notifyObservers(arg);
//	}

}
