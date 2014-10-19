package com.kp.MessageBroker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

public class ServletInitializer extends SpringBootServletInitializer {

	static final Logger log = LoggerFactory.getLogger(ServletInitializer.class);

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		log.info("Starting ServletInitializer");

		final SpringApplicationBuilder result = application
				.sources(Application.class);
		
//		result.run();
//
//		ApplicationContext ctx = result.context();
//		for (final String bean : ctx.getBeanDefinitionNames()) {
//			log.info(bean);
//		}
		
		return result;
	}

}
