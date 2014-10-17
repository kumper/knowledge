package com.kp.designpatterns.composite;

import com.kp.designpatterns.composite.visitor.IMenuVisitor;
import com.kp.designpatterns.composite.visitor.PrintMenuVisitor;

/**
 * Client class to show way of working {@link Menu}.
 */
public class App {
	public static void main(String[] args) {
		final Menu menu = new Menu("MENU");
		
		menu.addItem(
				new Menu("Menu główne", 
						new MenuItem("Wydruki"),
						new MenuItem("Informacje"), 
						new Menu("Aktywności",
								new MenuItem("Lista oczekujących"),
								new MenuItem("Moje")), 
						new Menu("Sprawy", 
								new MenuItem("Lista oczekujących"),
								new MenuItem("Moje"))))
			.addItem(
					new Menu("Administracja", 
							new MenuItem("Zmień hasło")));

		final IMenuVisitor visitor = new PrintMenuVisitor();
		
		menu.accept(visitor, 0);
	}
}
