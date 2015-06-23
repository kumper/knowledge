package usersFromDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	UserRepository userDao;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userDao.findOneByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Can't find user");
		}
		return new CustomUserDetails(user);
	}
	
//	@PreAuthorize("hasRole('ADMIN')") //nie działa z Vaadin
	public String checkAdmin() {
		return "You are an admin!";
	}
	
	public boolean isCurrentUserAdmin() {
		final CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return user.getAuthorities().contains(Roles.ADMIN);
	}

}
