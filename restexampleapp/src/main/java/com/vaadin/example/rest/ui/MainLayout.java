package com.vaadin.example.rest.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.applayout.AppLayout.Section;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.RouterLink;

/**
 * Application that demonstrates, Spring to fetch data from a
 * REST source and how to show it in a Front End.
 * 
 * 3rd party data is fetched from https://jsonplaceholder.typicode.com/ using
 * our {@link RestClientService) class.
 */
@CssImport("./styles/shared-styles.css")
@Push
public class MainLayout extends AppLayout implements AfterNavigationObserver {

	private final H1 pageTitle;
	private final RouterLink home;
	private final RouterLink inMemoryJSON;

	public MainLayout() {
		// Navigation
		home = new RouterLink("Home", HomeView.class);
		inMemoryJSON = new RouterLink("JSONView", InMemoryJSONView.class);
		
		Image img = new Image("https://1000logos.net/wp-content/uploads/2019/07/Westpac-Logo.png", "Ws Logo");
		Tabs tabs = new Tabs(new Tab("Home"), new Tab("About"));
		img.setHeight("44px");
//		addToNavbar(img, tabs);

		final UnorderedList list = new UnorderedList(new ListItem(home));
		final Nav navigation = new Nav(list);
		addToDrawer(navigation);
		setPrimarySection(Section.DRAWER);
		setDrawerOpened(false);

		// Header
		pageTitle = new H1("Home");
		final Header header = new Header(new DrawerToggle(), img, tabs);
		addToNavbar(header);
	}

	private RouterLink[] getRouterLinks() {
		return new RouterLink[] { home, inMemoryJSON};
	}

	@Override
	public void afterNavigation(AfterNavigationEvent event) {
		for (final RouterLink routerLink : getRouterLinks()) {
			if (routerLink.getHighlightCondition().shouldHighlight(routerLink, event)) {
				pageTitle.setText(routerLink.getText());
			}
		}
	}
}