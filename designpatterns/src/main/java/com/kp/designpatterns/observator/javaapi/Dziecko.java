package com.kp.designpatterns.observator.javaapi;

import java.util.Observable;
import java.util.Observer;

public class Dziecko implements Observer {
	
	private String nazwa;
	private Pogoda pogoda;
	
	public Dziecko(String nazwa, Pogoda pogoda) {
		super();
		this.nazwa = nazwa;
		this.pogoda = pogoda;
		this.pogoda.addObserver(this);
	}
	
	public void przestanOgladacPogode() {
		this.pogoda.deleteObserver(this);
	}

	public void update(Observable o, Object arg) {
		StringBuilder sb = new StringBuilder()
		.append("Dziecko[")
		.append(nazwa)
		.append("]: Wow!!!");
	
	System.out.println(sb.toString());
	}

}
