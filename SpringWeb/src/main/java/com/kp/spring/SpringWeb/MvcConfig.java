package com.kp.spring.SpringWeb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("menu");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/menu").setViewName("menu");
		registry.addViewController("/userDetails").setViewName("userDetails");
		registry.addViewController("/admin").setViewName("admin");
	}

}
