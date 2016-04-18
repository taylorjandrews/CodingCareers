package codingcareers.webapp.client.PageComponents;

import codingcareers.webapp.client.User;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Label;

public class ProfilePageBody extends PageBody {

	Label usernameTitle;

	public ProfilePageBody() {
		usernameTitle = new Label();
		usernameTitle.setText("NO USER SELECTED");
		add(usernameTitle, DockPanel.CENTER);
	}

	public void setUser(User user) {
		usernameTitle.setText(user.getUsername());
		add(usernameTitle, DockPanel.CENTER);
	}

	@Override
	public void attachHandlers() {
		// STUB
	}
}
