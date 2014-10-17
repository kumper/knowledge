package com.kp.designpatterns.templatemethod;

public class Herbata extends NapojZKofeina{

	@Override
	public void zaparzenie() {
		System.out.println("Parzenie herbatki");
	}

	@Override
	public void domieszanieDodatkow() {
		System.out.println("Dodawanie cytryny");
	}

}
