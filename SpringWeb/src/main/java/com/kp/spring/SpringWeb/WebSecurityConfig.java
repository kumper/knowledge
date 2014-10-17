package com.kp.spring.SpringWeb;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/home").permitAll();
		
		http.authorizeRequests().antMatchers("/userDetails").hasRole("BASIC");
		http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN");

		http.formLogin().loginPage("/login").permitAll();
		http.logout().permitAll();
		
		http.authorizeRequests().anyRequest().authenticated();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("kamil").password("kamil").roles("BASIC");
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("BASIC", "ADMIN");
	} 
	
}
