package com.kp.designpatterns.observator;

public interface Observable {
	
	public void register(Observator o);
	public void unregister(Observator o);
	public void informAll();

}
