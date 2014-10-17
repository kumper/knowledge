package com.kp.designpatterns.observator.javaapi;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Podmiot
		Pogoda pogoda = new Pogoda();
		
		//Obserwatorzy
		Rodzic r1 = new Rodzic("rodzic1", pogoda);
		Rodzic r2 = new Rodzic("rodzic2", pogoda);
		Dziecko d1 = new Dziecko("dziecko1", pogoda);
		Dziecko d2 = new Dziecko("dziecko2", pogoda);
		Dziecko d3 = new Dziecko("dziecko3", pogoda);
		
		//Logika
		pogoda.change();
		pogoda.notifyObservers(null);
		
		System.out.println();
		
		d1.przestanOgladacPogode();
		d2.przestanOgladacPogode();

		pogoda.change();
		pogoda.notifyObservers(null);	
	}
}
