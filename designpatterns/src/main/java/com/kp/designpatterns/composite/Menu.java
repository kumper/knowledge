package com.kp.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

import com.kp.designpatterns.composite.visitor.IMenuVisitor;

/**
 * Class represents a sub-menu, which extends the menu hierarchy on deeper level.
 *
 * @author Kamil Parzych
 */
public class Menu extends AbstractMenuItem {
	private List<AbstractMenuItem> list;

	/**
	 * Main constructor.
	 *
	 * @param title title of the menu
	 */
	public Menu(final String title) {
		super(title);
		this.list = new ArrayList<AbstractMenuItem>();
	}


	/**
	 * Secondary constructor - quickly creates also the items.
	 *
	 * @param title title of the menu
	 */
	public Menu(final String title, final AbstractMenuItem... items) {
		this(title);
		for (final AbstractMenuItem item : items) {
			list.add(item);
		}
	}
	
	public Menu addItem(final AbstractMenuItem item) {
		this.list.add(item);
		
		return this;
	}

	@Override
	public void accept(final IMenuVisitor visitor, final int currentLevel) {
		visitor.visit(this, currentLevel);

		for(final AbstractMenuItem item : list) {
			item.accept(visitor, currentLevel + 1);
		}
	}

}
