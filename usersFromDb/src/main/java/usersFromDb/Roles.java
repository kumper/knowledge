package usersFromDb;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public interface Roles {
//	public static final String ADMIN = "ADMIN";
//	public static final String USER = "USER";
	
	//w celu zapewnienia poprawności metody equals()
	public static final GrantedAuthority ADMIN = new SimpleGrantedAuthority("ADMIN");
	public static final GrantedAuthority USER = new SimpleGrantedAuthority("USER");
	

}
