package com.kp.designpatterns.adapter;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Kaczka dzikaKaczka = new DzikaKaczka(); //klasa docelowa
		
		Indyk dzikiIndyk = new DzikiIndyk(); //klasa adoptowana
		
		Kaczka indykAdapter = new IndykAdapter(dzikiIndyk);
		
		//Pomijamy test dzikiego indyka
		
		System.out.println("Test dzikiej kaczki");
		testujKaczke(dzikaKaczka);
		
		System.out.println("\nTest adaptera indyka");
		testujKaczke(indykAdapter);
	}
	
	private static void testujKaczke(Kaczka kaczka) {
		kaczka.kwacz();
		kaczka.lataj();
	}
}
