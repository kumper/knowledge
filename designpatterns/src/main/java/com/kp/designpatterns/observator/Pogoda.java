package com.kp.designpatterns.observator;

import java.util.ArrayList;

public class Pogoda implements Observable {

	private final ArrayList<Observator> list = new ArrayList<Observator>();

	public void register(Observator o) {
		list.add(o);
	}

	public void unregister(Observator o) {
		list.remove(o);
	}

	public void informAll() {
		for (Observator o : list) {
			o.update();
		}
	}

}
