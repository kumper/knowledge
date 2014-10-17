package com.kp.designpatterns.templatemethod;

public class Kawa extends NapojZKofeina {

	@Override
	public void zaparzenie() {
		System.out.println("Parzenie kawy");
	}

	@Override
	public void domieszanieDodatkow() {
		System.out.println("Dodawanie mleka i cukru");
	}

	@Override
	public boolean domieszacDodatki() {
		return false; //wykorzystujemy metod� "haczyk" domy�lnie, by nie dodawa� dodatk�w
	}

}
