package com.kp.designpatterns.composite.visitor;

import com.kp.designpatterns.composite.MenuItem;
import com.kp.designpatterns.composite.Menu;

/**
 * Interface for visitor pattern.
 *
 * @author Kamil Parzych
 */
public interface IMenuVisitor {

	public void visit(final MenuItem item, final int currentLevel);
	public void visit(final Menu item, final int currentLevel);

}
