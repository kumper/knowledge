package com.kp.frameworks.springjpavaadin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.kp.frameworks.springjpavaadin.dao.CustomerRepository;
import com.kp.frameworks.springjpavaadin.entity.Customer;
import com.vaadin.server.VaadinServlet;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
    	ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        CustomerRepository repository = context.getBean(CustomerRepository.class);

        // save a couple of customers
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));
        
		//more random customers
		String[] fnames = { "Peter", "Alice", "Joshua", "Mike", "Olivia",
				"Nina", "Alex", "Rita", "Dan", "Umberto", "Henrik", "Rene",
				"Lisa", "Marge" };
		String[] lnames = { "Smith", "Gordon", "Simpson", "Brown", "Clavel",
				"Simons", "Verne", "Scott", "Allison", "Gates", "Rowling",
				"Barks", "Ross", "Schneider", "Tate" };
		for (int i = 0; i < 1000; i++) {
			String fName = fnames[(int) (fnames.length * Math.random())];
			String lName = lnames[(int) (lnames.length * Math.random())];
	        repository.save(new Customer(fName, lName));
		}
    }
    
    @Bean
    public ServletRegistrationBean Vaadin() {
    	ServletRegistrationBean vaadin = new ServletRegistrationBean(new VaadinServlet(), "/*");
    	vaadin.addInitParameter("UI", "com.kp.frameworks.springjpavaadin.ui.AddressbookUI");
    	return vaadin;
    }
}
