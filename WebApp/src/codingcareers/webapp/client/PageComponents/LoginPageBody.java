package codingcareers.webapp.client.PageComponents;

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;

import codingcareers.webapp.client.Constants;

public class LoginPageBody extends PageBody {

	public LoginPageBody() {
		Label loginMessage = new Label();
		loginMessage.setText("Welcome back to Coding Careers! If you already have an account, login here.");
		loginMessage.addStyleName("loginMessage");
		add(loginMessage, DockPanel.NORTH);


		VerticalPanel loginPage = new VerticalPanel();
		Label loginUsername = new Label();
		loginUsername.setText("Username");
		loginUsername.addStyleName("loginUsername");
		loginPage.add(loginUsername);

		TextBox emailBox = new TextBox();
		emailBox.setText("johndoe@gmail.com");
		emailBox.addStyleName("emailBox");
		loginPage.add(emailBox);

		Label loginPassword = new Label();
		loginPassword.setText("Password");
		loginPassword.addStyleName("loginPassword");
		loginPage.add(loginPassword);

		TextBox passwordBox = new PasswordTextBox();
		passwordBox.addStyleName("passwordBox");
		loginPage.add(passwordBox);

		add(loginPage, DockPanel.CENTER);
	}

	@Override
	public void attachHandlers() {
		// STUB
	}
	
}
