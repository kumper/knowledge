package com.kp.designpatterns.observator.javaapi;

import java.util.Observable;

public class Pogoda extends Observable {
	
	public void change() {
		setChanged();
	}

//	Inny spos�b (bez wywo�ania metody setChanged())
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
