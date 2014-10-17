package com.kp.designpatterns.templatemethod;

public abstract class NapojZKofeina {

	public final void recepturaPrzyrzadzenia() {
		gotowanieWody();
		zaparzenie();
		nalewanieDoFilizanki();
		if (domieszacDodatki()) {
			domieszanieDodatkow();
		}
	}

	public void gotowanieWody() {
		System.out.println("Gotowanie wody");
	}

	public abstract void zaparzenie();

	public void nalewanieDoFilizanki() {
		System.out.println("Nalewanie do filizanki");
	}

	public abstract void domieszanieDodatkow();

	public boolean domieszacDodatki() {
		return true;
	}
}
