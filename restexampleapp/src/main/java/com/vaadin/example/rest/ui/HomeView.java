package com.vaadin.example.rest.ui;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@PageTitle("Vaadin REST Examples")
@Route(value = "", layout = MainLayout.class)
public class HomeView extends Main {

	public HomeView() {
		
		
		add(new Section(new H2(new RouterLink("Call REST service", InMemoryJSONView.class)),
				new Paragraph("This is to display json data into grid list view")));

	}
}
