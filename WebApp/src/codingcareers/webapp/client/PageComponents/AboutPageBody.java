package codingcareers.webapp.client.PageComponents;

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Label;

import codingcareers.webapp.client.Constants;

public class AboutPageBody extends PageBody{

	public AboutPageBody(){
		Label welcomeMessage = new Label();
		welcomeMessage.setText("Welcome to "+ Constants.TITLE);
		welcomeMessage.addStyleName("welcomeMessage");
		add(welcomeMessage, DockPanel.NORTH);
		
		Label textMessage = new Label();
		textMessage.setText(Constants.ABOUT_PAGE_INFO);
		textMessage.addStyleName("textMessage");
		add(textMessage, DockPanel.CENTER);
		
		Anchor tryItNow = new Anchor("Try it Now!","http://domain.com/index.tml");
		tryItNow.addStyleName("tryItNow");
		add(tryItNow, DockPanel.SOUTH);
	}
	@Override
	public void attachHandlers() {
		//STUB
	}
}
