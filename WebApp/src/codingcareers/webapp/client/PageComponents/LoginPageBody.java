package codingcareers.webapp.client.PageComponents;

import codingcareers.webapp.client.Controller;
import codingcareers.webapp.client.UICallback;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

public class LoginPageBody extends PageBody {

	private TextBox usernameBox;
	private TextBox passwordBox;
	private Button loginButton;

	public LoginPageBody() {
		usernameBox = new TextBox();
		usernameBox.setText("username");
		add(usernameBox, DockPanel.NORTH);

		passwordBox = new PasswordTextBox();
        passwordBox.setText("password");
		add(passwordBox, DockPanel.CENTER);
        
        addStyleName("login");
		loginButton = new Button();
		loginButton.setText("Log in");
        
        addStyleName("loginButton");
		add(loginButton, DockPanel.EAST);
        addStyleName("show-password");
        
        addStyleName("loginbackground");
		attachHandlers();
        
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
