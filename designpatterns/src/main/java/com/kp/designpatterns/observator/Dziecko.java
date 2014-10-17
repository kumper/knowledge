package com.kp.designpatterns.observator;

public class Dziecko implements Observator {
	
	private String nazwa;
	private Pogoda pogoda;
	
	public Dziecko(String nazwa, Pogoda pogoda) {
		super();
		this.nazwa = nazwa;
		this.pogoda = pogoda;
		this.pogoda.register(this);
	}

	public void update() {
		StringBuilder sb = new StringBuilder()
			.append("Dziecko[")
			.append(nazwa)
			.append("]: Wow!!!");
		
		System.out.println(sb.toString());
	}
	
	public void przestanOgladacPogode() {
		this.pogoda.unregister(this);
	}

}
