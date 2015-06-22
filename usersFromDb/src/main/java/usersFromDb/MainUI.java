package usersFromDb;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.VerticalLayout;

@SpringUI
public class MainUI extends UI {

	private Button logoutBtn = new Button("Wyloguj");

	@Override
	protected void init(VaadinRequest request) {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		User user = (User) authentication.getPrincipal();

		logoutBtn.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getPage().setLocation(getPage().getLocation().getRawPath() + "logout");
				close();
			}
		});
		
		setContent(new VerticalLayout(
				logoutBtn,
				new Label(String.format("Witaj %s %s !", user.getFirstName(), user.getLastName()))));
	}

}
