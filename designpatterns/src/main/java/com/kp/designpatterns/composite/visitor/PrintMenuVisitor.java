package com.kp.designpatterns.composite.visitor;

import com.kp.designpatterns.composite.MenuItem;
import com.kp.designpatterns.composite.Menu;

/**
 * Implementation of visitor for printing the menu on console.
 * 
 * @author Kamil Parzych
 */
public class PrintMenuVisitor implements IMenuVisitor {

	public void visit(final MenuItem item, final int currentLevel) {
		for (int i = 0; i < currentLevel; i++) {
			System.out.print("\t");
		}
		System.out.println("- " + item.getTitle());
	}

	public void visit(final Menu item, final int currentLevel) {
		for (int i = 0; i < currentLevel; i++) {
			System.out.print("\t");
		}
		System.out.println("+ " + item.getTitle());
	}

}
