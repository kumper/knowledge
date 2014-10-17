package com.kp.designpatterns.composite;

import com.kp.designpatterns.composite.visitor.IMenuVisitor;

/**
 * Single menu item entry.
 *
 * @author Kamil Parzych
 */
public class MenuItem extends AbstractMenuItem {

	public MenuItem(final String title) {
		super(title);
	}

	@Override
	public void accept(final IMenuVisitor visitor, final int currentLevel) {
		visitor.visit(this, currentLevel);
	}

}
