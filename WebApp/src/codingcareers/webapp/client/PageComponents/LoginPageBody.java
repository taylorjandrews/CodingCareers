package codingcareers.webapp.client.PageComponents;

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;
import codingcareers.webapp.client.Constants;
import codingcareers.webapp.client.Controller;
import codingcareers.webapp.client.UICallback;

public class LoginPageBody extends PageBody {

	private TextBox usernameBox;
	private TextBox passwordBox;
	private Button loginButton;

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
		emailBox.setText("H3LL0 L@UR3N");
		emailBox.addStyleName("emailBox");
		loginPage.add(emailBox);

		Label loginPassword = new Label();
		loginPassword.setText("Password");
		loginPassword.addStyleName("loginPassword");
		loginPage.add(loginPassword);

		TextBox passwordBox = new PasswordTextBox();
		passwordBox.addStyleName("passwordBox");
		loginPage.add(passwordBox);

		loginButton = new Button();
		loginButton.setText("Log in");
		loginButton.addStyleName("loginButton");
		loginPage.add(loginButton);

		add(loginPage, DockPanel.CENTER);
	}

	@Override
	public void attachHandlers() {
		loginButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Controller.getInstance().login(usernameBox.getText(), passwordBox.getText(), new UICallback() {
					@Override
					public void exec(String args) {
						add(new Label(args), DockPanel.SOUTH);
					}
				});
			}
		});
	}
	
}
