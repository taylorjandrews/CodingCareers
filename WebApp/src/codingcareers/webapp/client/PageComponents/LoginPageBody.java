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
    private Button newProfileButton;

	public LoginPageBody() {
		
		Label loginMessage = new Label();
		loginMessage.setText("Please log in to your account.");
		loginMessage.addStyleName("loginMessage");
		add(loginMessage, DockPanel.NORTH);
		
		usernameBox = new TextBox();
		usernameBox.setText("username");
		add(usernameBox, DockPanel.NORTH);

		passwordBox = new PasswordTextBox();
        passwordBox.setText("password");
		add(passwordBox, DockPanel.CENTER);
        
        addStyleName("login");
		loginButton = new Button();
		loginButton.setText("Log in");

        newProfileButton = new Button();
        newProfileButton.setText("Create Profile");

        DockPanel buttonPanel = new DockPanel();
        buttonPanel.add(loginButton, DockPanel.NORTH);
        buttonPanel.add(newProfileButton, DockPanel.SOUTH);
        
        addStyleName("loginButton");
		add(buttonPanel, DockPanel.EAST);
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

        newProfileButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Controller.getInstance().loadPage(Constants.PROFILE_CREATION);
            }
        });
	}
	
}
