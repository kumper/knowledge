package com.kp.ws.SpringSecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter 
{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests().antMatchers("ws/**").hasRole("USER").and().httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("kamil").password("kamil").roles("USER");
	}

//	@Bean
//	public SimplePasswordValidationCallbackHandler callbackHandler() {
//		SimplePasswordValidationCallbackHandler callbackHandler = new SimplePasswordValidationCallbackHandler();
//		
//		Map<String, String> usersMap = new HashMap<String, String>();
//
//		usersMap.put("kamil", "kamil");
//		usersMap.put("admin", "admin");
//		
//		callbackHandler.setUsersMap(usersMap);
//		
//		return callbackHandler;
//	}
//
//	@Bean
//	public Wss4jSecurityInterceptor securityInterceptor() {
//		Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
//		
//		securityInterceptor.setValidationActions("Timestamp UsernameToken");
//		securityInterceptor.setSecurementActions("Timestamp UsernameToken");
//		securityInterceptor.setTimestampPrecisionInMilliseconds(true);
//		securityInterceptor.setSecurementUsername("mojo");
//		securityInterceptor.setSecurementPassword("mojopass");
//		securityInterceptor.setSecurementPasswordType("PasswordText");
//		securityInterceptor.setSecurementUsernameTokenElements("Nonce Created");
//		securityInterceptor.setValidationCallbackHandler(callbackHandler());
//		
//		return securityInterceptor;
//	}
}
