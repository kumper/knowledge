package pl.kp.java8.lambdatest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@SpringUI
@Theme("valo")
public class MainUI extends UI {

	private Table table = new Table();
	private BeanItemContainer<Person> container = new BeanItemContainer<Person>(
			Person.class);
	private CheckBox lastNameFilter = new CheckBox("Lastname");
	private CheckBox ageFilter = new CheckBox("Age");

	@Override
	protected void init(VaadinRequest request) {
		generateTestData();

		lastNameFilter.addValueChangeListener((e) -> refresh());
		ageFilter.addValueChangeListener((e) -> refresh());

		setContent(new VerticalLayout(table, new HorizontalLayout(lastNameFilter, ageFilter)));

		table.setContainerDataSource(container);

		refresh();
	}

	private void refresh() {
		if (container.removeAllItems()) {
			Stream<Person> stream = generateTestData().stream();

			if (lastNameFilter.getValue()) {
				stream = stream.filter(e -> e.getLastName().startsWith("P"));
			}
			if (ageFilter.getValue()) {
				stream = stream.filter(e -> e.getAge() > 20);
			}

			container.addAll(stream.collect(Collectors.toList()));
		}
	}

	private List<Person> generateTestData() {
		final List<Person> ret = new ArrayList<MainUI.Person>();

		ret.add(new Person("Kamil", "Parzych", 29));
		ret.add(new Person("Katarzyna", "Parzych", 9));
		ret.add(new Person("Emilia", "Sługosz", 19));
		ret.add(new Person("Tomasz", "Więckowski", 6));
		ret.add(new Person("Michał", "Parcikowski", 12));

		return ret;
	}

	public class Person {
		private String firstName;
		private String lastName;
		private int age;

		public Person(String firstName, String lastName, int age) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public int getAge() {
			return age;
		}
	}

}
