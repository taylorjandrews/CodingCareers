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
        VerticalPanel vp = new VerticalPanel();

        Label loginMessage = new Label();
        loginMessage.setText("Create an Account");
        loginMessage.addStyleName("loginMessage");
        add(loginMessage, DockPanel.NORTH);

        usernameBox = new TextBox();
        usernameBox.setText("Username");
        usernameBox.addStyleName("registerUsername");
        //add(usernameBox, DockPanel.NORTH);
        vp.add(usernameBox);

        passwordBox = new PasswordTextBox();
        passwordBox.setText("password");
        passwordBox.addStyleName("registerPassword");
        vp.add(passwordBox);
        //add(passwordBox, DockPanel.CENTER);
        addStyleName("registerBody");
       
        createButton = new Button();
        createButton.setText("Create Account");
        createButton.addStyleName("createButton");
        vp.add(createButton);

        vp.addStyleName("createbackground");

        add(vp, DockPanel.CENTER);

        //add(createButton, DockPanel.EAST);
        addStyleName("show-password");
        
        //addStyleName("createbackground");

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
