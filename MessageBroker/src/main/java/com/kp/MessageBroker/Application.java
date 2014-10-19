package com.kp.MessageBroker;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.vaadin.server.VaadinServlet;

@Configuration
@ComponentScan(basePackages = {"com.kp.MessageBroker"})
@EnableAutoConfiguration
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Bean
	public ServletRegistrationBean vaadin() {
		final ServletRegistrationBean vaadin = new ServletRegistrationBean(new VaadinServlet());
		
		vaadin.setName("Vaadin");
		vaadin.addInitParameter("UI", "com.kp.MessageBroker.ui.AddressbookUI");
		
		List<String> urlMappings = new ArrayList<String>();
		urlMappings.add("/ui/*");
		urlMappings.add("/VAADIN/*");
		vaadin.setUrlMappings(urlMappings);
		
		return vaadin;
	}

    public static void main(String[] args) {
        
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        log.info("Application started");
        
        for (final String bean : ctx.getBeanDefinitionNames()) {
        	log.info(bean);
        }
    }
}
