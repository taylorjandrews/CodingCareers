package codingcareers.webapp.client.PageComponents;

import codingcareers.webapp.client.Constants;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;

public abstract class PageHeader extends HorizontalPanel implements PageComponent{

	//TODO PageHeader Load()
	public void load() {
        RootPanel.get(Constants.HEADER_ID).add(this);
    }
	
	//TODO + setLoginState(loggedIn: boolean): void
	public abstract void setLoginState(boolean loggedIn);
	public abstract void setUsername(String username);
}
