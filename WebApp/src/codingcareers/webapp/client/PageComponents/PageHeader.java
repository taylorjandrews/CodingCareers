package codingcareers.webapp.client.PageComponents;

import codingcareers.webapp.client.Constants;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;

public abstract class PageHeader extends HorizontalPanel implements PageComponent{

	//TODO PageHeader Load()
	public void load() {
        RootPanel headerPanel = RootPanel.get(Constants.HEADER_ID);
		headerPanel.clear();
		headerPanel.add(this);
    }

	public abstract void setLoginState(boolean loggedIn);
}
