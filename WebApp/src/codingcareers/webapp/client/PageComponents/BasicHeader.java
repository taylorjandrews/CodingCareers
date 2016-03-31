package codingcareers.webapp.client.PageComponents;

import codingcareers.webapp.client.Constants;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;


public class BasicHeader extends PageHeader {

	public BasicHeader() {
        Label title = new Label();
        title.setText(Constants.TITLE);
        add(title);
	}

	@Override
	public void setLoginState(boolean loggedIn) {
		// STUB
		return;
	}

	@Override
	public void setUsername(String username) {
		// STUB
		return;
	}

    @Override
    public void attachHandlers() {
        // STUB
    }
}
