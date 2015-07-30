package pl.kp.vaadinchart;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@SpringUI
@Theme("valo")
@Widgetset("pl.kp.vaadinchart.widgetset.MyAppWidgetSet")
public class MainUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		setContent(new MyChart());
	}

}
