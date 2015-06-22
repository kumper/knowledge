package usersFromDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
	
	@Autowired
	UserRepository userDao;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		userDao.deleteAll();
		userDao.save(new User("kparzych", "Kamil", "Parzych", "$2a$10$Uz7lWAhscy1pTKkHG0TnQu3kKT6ZNkvQG1ifG.T4UKfPhhWOd0q3S", "Avery", "ADMIN,USER"));
		userDao.save(new User("jszwaj", "Jarosław", "Szwaj", "$2a$10$RqMOS0ODO.ysxmLuX.YBJurHWetd.Se2MiMh.2o28u1QXmxdidTCe", "Avery", "ADMIN,USER"));
		userDao.save(new User("mkrakowski", "Marek", "Krakowski", "$2a$10$.okUzPN82YA07oxK35KosOXe7wLLkgN9m4z9rr4NIvA3ucDyMCCH.", "Alfatherm", "USER"));
	}
}
