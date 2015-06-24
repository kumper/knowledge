package usersFromDb;

import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

//Sprawdzić czy to nie będzie potrzebne po deploy'u na tomcat
public class SecurityWebApplicationInitializer {//extends AbstractSecurityWebApplicationInitializer {

    public SecurityWebApplicationInitializer() {
//        super(SecurityConfig.class);
    }

}
