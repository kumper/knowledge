package com.kp.designpatterns.composite;

import com.kp.designpatterns.composite.visitor.IMenuVisitor;

/**
 * An abstract class being a base for composite pattern for {@link Menu}.
 *
 * @author Kamil Parzych
 */
public abstract class AbstractMenuItem {

	/**
	 * The name for item. 
	 */
	private String title;
	
	public AbstractMenuItem(final String title) {
		this.title = title;
	}

	/**
	 * The name for item. 
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * An input for Visitor pattern.
	 * 
	 * @param visitor visitor instance
	 * @param currentLevel used to differ on which level item is printed
	 */
	public abstract void accept(final IMenuVisitor visitor, final int currentLevel);
}
