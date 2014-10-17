package com.kp.designpatterns.observator;

public class Rodzic implements Observator {
	
	private String nazwa;
	private Pogoda pogoda;
	
	public Rodzic(String nazwa, Pogoda pogoda) {
		super();
		this.nazwa = nazwa;
		this.pogoda = pogoda;
		this.pogoda.register(this);
	}

	public void update() {
		StringBuilder sb = new StringBuilder()
			.append("Rodzic[")
			.append(nazwa)
			.append("]: Pi�knie.");
		
		System.out.println(sb.toString());
	}
}
