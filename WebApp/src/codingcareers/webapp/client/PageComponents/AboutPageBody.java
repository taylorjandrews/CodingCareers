package codingcareers.webapp.client.PageComponents;

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Label;

import codingcareers.webapp.client.Constants;

public class AboutPageBody extends PageBody{

	public AboutPageBody(){
		Label welcomeMessage = new Label();
		welcomeMessage.setText("Welcome to "+ Constants.TITLE);
		add(welcomeMessage, DockPanel.NORTH);
		
		Label textMessage = new Label();
		textMessage.setText("There should be some welcome messages in the Constant class files");
		add(textMessage, DockPanel.CENTER);
		
		Anchor tryItNow = new Anchor("Try it Now!","http://domain.com/index.tml");
		
		add(tryItNow, DockPanel.SOUTH);
	}
	@Override
	public void attachHandlers() {
		//STUB
	}
}
