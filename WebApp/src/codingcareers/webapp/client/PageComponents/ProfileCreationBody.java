package codingcareers.webapp.client.PageComponents;

import codingcareers.webapp.client.Controller;
import codingcareers.webapp.client.UICallback;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

/**
 * Created by ian on 4/19/16.
 */
public class ProfileCreationBody extends PageBody {

    private TextBox usernameBox;
    private TextBox passwordBox;

    private Button createButton;

    public ProfileCreationBody() {

        Label loginMessage = new Label();
        loginMessage.setText("Create an Account");
        loginMessage.addStyleName("loginMessage");
        add(loginMessage, DockPanel.NORTH);

        usernameBox = new TextBox();
        usernameBox.setText("Username");
        add(usernameBox, DockPanel.NORTH);

        passwordBox = new PasswordTextBox();
        passwordBox.setText("password");
        add(passwordBox, DockPanel.CENTER);

        addStyleName("login");
        createButton = new Button();
        createButton.setText("Create");

        addStyleName("loginButton");
        add(createButton, DockPanel.EAST);
        addStyleName("show-password");

        attachHandlers();

    }

    @Override
    public void attachHandlers() {
        createButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Controller.getInstance().createAccount(usernameBox.getText(), passwordBox.getText(), new UICallback() {
                    @Override
                    public void exec(String args) {
                        add(new Label(args), DockPanel.SOUTH);
                    }
                });
            }
        });
    }
}
