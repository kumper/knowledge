package pl.kp.java8.lambdatest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@SpringUI
@Theme("valo")
public class MainUI extends UI {
	private final Logger LOG = LoggerFactory.getLogger(MainUI.class);

	private Table table = new Table();
	private BeanItemContainer<Person> container = new BeanItemContainer<Person>(
			Person.class);
	private CheckBox lastNameFilter = new CheckBox("Lastname = P*");
	private CheckBox ageFilter = new CheckBox("Age > 20");
	private Label customLabel = new Label("This should work with Firefox LiveReload plugin - yes, it does");

	@Override
	protected void init(VaadinRequest request) {
		generateTestData();

		lastNameFilter.addValueChangeListener((e) -> refresh());
		ageFilter.addValueChangeListener((e) -> refresh());

		setContent(new VerticalLayout(table, new HorizontalLayout(lastNameFilter, ageFilter), customLabel));

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
		
		final List<Person> testData = generateTestData();
		
		LOG.info("Średni wiek: {}", testData.stream().collect(Collectors.averagingDouble(Person::getAge)));
		LOG.info("Suma lat wszystkich osób: {}", testData.stream().collect(Collectors.summarizingDouble(Person::getAge)).getSum());
		LOG.info("Ludzie w wieku 30-50: {}", testData.stream()
				.filter(e -> e.getAge() >= 30)
				.filter(e -> e.getAge() <= 50)
				.collect(Collectors.toList()));
		
		LOG.info("Lista posortowanych wieków:");
		testData.stream()
				.mapToInt(Person::getAge)
				.sorted()
				.forEach(e -> LOG.info(Integer.valueOf(e).toString()));
		
		testData.sort( (x, y) -> x.getAge() - y.getAge() );
		LOG.info("Lista posortowanych wieków 2: {}", testData);
		//to samo inaczej
		testData.sort(Comparator.comparingInt(Person::getAge));
		
		LOG.info("Osoba z największym (ascii) nazwiskiem: {}", testData.stream().max(Comparator.comparing(Person::getLastName)).get());
		
		LOG.info("Grupowanie (suma lat) po nazwiskach");
		testData.stream()
				.collect(Collectors.groupingBy(Person::getLastName))
				.forEach( (k, v) -> {
					LOG.info("Suma lat nazwiska: {} = {}", k, v.stream().mapToInt(Person::getAge).sum());
				});
		
		LOG.info("Lista oddzielona separatorem: {}", testData.stream().map(Person::getLastName).collect(Collectors.joining(" | ")));
	}

	private List<Person> generateTestData() {
		final List<Person> ret = new ArrayList<MainUI.Person>();

		ret.add(new Person("Kamil", "Parzych", 29));
		ret.add(new Person("Katarzyna", "Parzych", 9));
		ret.add(new Person("Emilia", "Sługosz", 19));
		ret.add(new Person("Tomasz", "Więckowski", 6));
		ret.add(new Person("Michał", "Parcikowski", 12));
		ret.add(new Person("Krzysztof", "Perzan", 35));
		ret.add(new Person("Michał", "Wielki", 42));
		ret.add(new Person("Tomasz", "Perzan", 65));

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

		@Override
		public String toString() {
			return String.format("Person [firstName=%s, lastName=%s, age=%s]",
					firstName, lastName, age);
		}
	}

}
