package com.kp.designpatterns.adapter;

public class IndykAdapter implements Kaczka {

	private Indyk indyk;

	public IndykAdapter(Indyk indyk) {
		super();
		this.indyk = indyk;
	}

	public void kwacz() {
		indyk.gulgaj();
	}

	public void lataj() {
		for (int i=0; i<5; i++) {
			indyk.lataj(); //indyk musi lecie� przynajmniej 5 razy �eby dor�wna� kaczce
		}
	}
}
