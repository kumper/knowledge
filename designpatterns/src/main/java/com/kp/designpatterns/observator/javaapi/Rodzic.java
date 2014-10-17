package com.kp.designpatterns.observator.javaapi;

import java.util.Observable;
import java.util.Observer;

public class Rodzic implements Observer {
	
	private String nazwa;
	private Pogoda pogoda;
	
	public Rodzic(String nazwa, Pogoda pogoda) {
		super();
		this.nazwa = nazwa;
		this.pogoda = pogoda;
		this.pogoda.addObserver(this);
	}

	public void update(Observable o, Object arg) {
		StringBuilder sb = new StringBuilder()
			.append("Rodzic[")
			.append(nazwa)
			.append("]: Pi�knie.");
		
		System.out.println(sb.toString());
	}
}
