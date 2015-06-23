package usersFromDb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@SpringUI
@Scope("prototype")
public class MainUI extends UI {
	
	private final Logger LOG = LoggerFactory.getLogger(MainUI.class);
	
	@Autowired
	UserService userService;

	private Button logoutBtn = new Button("Wyloguj");

	@Override
	protected void init(VaadinRequest request) {
		LOG.info("request.getUserPrincipal(): {}", request.getUserPrincipal().getName());
		
		//Pobranie principal z requesta Vaadin
		CustomUserDetails user = (CustomUserDetails) userService.loadUserByUsername(request.getUserPrincipal().getName());

		logoutBtn.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getPage().setLocation(getPage().getLocation().getRawPath() + "logout");
				close();
			}
		});
		
		setContent(new VerticalLayout(
				logoutBtn,
				new Label(String.format("Witaj %s %s ! Twoje uprawnienia: %s", 
						user.getFirstName(), 
						user.getLastName(), 
						user.getAuthorities())),

//				//nie działa w Vaadin
//				new Button("Check Admin", new Button.ClickListener() {
//					@Override
//					public void buttonClick(ClickEvent event) {
//						try {
//							((VerticalLayout) MainUI.this.getContent()).addComponent(new Label(userService.checkAdmin()));
//						} catch (Exception e) {
//							Notification.show("Access error: " + e.getMessage(), Notification.Type.ERROR_MESSAGE);
//						}
//					}
//				})

				new Button("Check Admin", e -> {
					if (userService.isCurrentUserAdmin()) {
						((VerticalLayout) MainUI.this.getContent()).addComponent(new Label("You're indeed an Admin"));
					}
					else {
						Notification.show("Access error: You're not authorized as Admin", Notification.Type.ERROR_MESSAGE);
					}
				})
				
				));
		
		
	}

}
