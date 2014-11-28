package com.kp.frameworks.springjpavaadin.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.kp.frameworks.springjpavaadin.entity.Customer;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.addon.jpacontainer.provider.CachingMutableLocalEntityProvider;
import com.vaadin.data.Container.Filter;
import com.vaadin.data.Item;
import com.vaadin.data.util.filter.Compare;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class CustomTable extends VerticalLayout implements ComponentContainer {
	
	private Table table = new Table("Custom Table");
	private Button showOnlyAlice = new Button("Show only Alice");
	
	public CustomTable() {
		this.addComponent(table);
		this.addComponent(showOnlyAlice);
		
		SpringContextHelper sch = new SpringContextHelper(VaadinServlet.getCurrent().getServletContext());
		// We need a factory to create entity manager
		EntityManagerFactory emf = (EntityManagerFactory) sch.getBean("entityManagerFactory");

		// We need an entity manager to create entity provider
		EntityManager em = emf.createEntityManager();

		// We need an entity provider to create a container        
		CachingMutableLocalEntityProvider<Customer> entityProvider =
		    new CachingMutableLocalEntityProvider<Customer>(Customer.class, em);

		// And there we have it
		final JPAContainer<Customer> customerContainer = new JPAContainer<Customer> (Customer.class);
		customerContainer.setEntityProvider(entityProvider);

		table.setContainerDataSource(customerContainer);
		table.setVisibleColumns(new String[] { "firstName", "lastName" });
		table.setColumnHeaders("First Name", "Last Name");
		table.setSelectable(true);
		table.setImmediate(true);
		
		showOnlyAlice.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Filter onlyAliceFilter = new SimpleStringFilter("firstName", "Alice", true, false);
				customerContainer.removeAllContainerFilters();
				customerContainer.addContainerFilter(onlyAliceFilter);
				
				Notification.show("Only Alice are shown");
			}
		});
		
	}

}
