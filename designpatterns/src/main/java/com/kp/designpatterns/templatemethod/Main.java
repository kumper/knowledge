package com.kp.designpatterns.templatemethod;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Herbata herbata = new Herbata();
		herbata.recepturaPrzyrzadzenia();

		System.out.println();
		
		Kawa kawa = new Kawa();
		kawa.recepturaPrzyrzadzenia();
	}

}
