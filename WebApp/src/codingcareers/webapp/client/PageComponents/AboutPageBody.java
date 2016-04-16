package codingcareers.webapp.client.PageComponents;

import codingcareers.webapp.client.Controller;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Label;

import codingcareers.webapp.client.Constants;

public class AboutPageBody extends PageBody{

	private Anchor tryItNow;

	public AboutPageBody(){
		Label welcomeMessage = new Label();
		welcomeMessage.setText("Welcome to "+ Constants.TITLE);
		welcomeMessage.addStyleName("welcomeMessage");
		add(welcomeMessage, DockPanel.NORTH);

		Label aboutMessage = new Label();
		aboutMessage.setText(Constants.ABOUT_PAGE_INFO);
		aboutMessage.addStyleName("aboutMessage");
		add(aboutMessage, DockPanel.CENTER);

		tryItNow = new Anchor("Try it Now!");
		tryItNow.addStyleName("tryItNow");
		add(tryItNow, DockPanel.SOUTH);

		attachHandlers();
	}

	@Override
	public void attachHandlers() {
        tryItNow.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                Controller.getInstance().loadPage(Constants.TASK_SELECTION_PAGE);
            }
        });
	}
}
