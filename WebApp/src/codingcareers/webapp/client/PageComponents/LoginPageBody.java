package codingcareers.webapp.client.PageComponents;

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

public class LoginPageBody extends PageBody {

	public LoginPageBody() {
		TextBox emailBox = new TextBox();
		emailBox.setText("johndoe@gmail.com");
		add(emailBox, DockPanel.NORTH);

		TextBox passwordBox = new PasswordTextBox();
		add(passwordBox, DockPanel.CENTER);
	}

	@Override
	public void attachHandlers() {
		// STUB
	}
	
}
