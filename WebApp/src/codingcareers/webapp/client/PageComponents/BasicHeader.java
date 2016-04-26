package codingcareers.webapp.client.PageComponents;

import codingcareers.webapp.client.Constants;

import codingcareers.webapp.client.Controller;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
public class BasicHeader extends PageHeader {

	private Anchor aboutBtn;
	private Anchor lessonBtn;
	private Anchor profileBtn;
	private Anchor loginBtn;
	private boolean isLoggedIn;

	public BasicHeader() {
       
       aboutBtn = generateLabel("About");
       lessonBtn = generateLabel("Lessons");
       profileBtn = generateLabel("Profile");
       loginBtn= generateLabel("Login");

		attachHandlers();
       
       //TODO: eventHandler for all Hyperlink
       add(aboutBtn);
       add(lessonBtn);
       add(profileBtn);
       add(loginBtn);

        setLoginState(false);
       
	}
	public Anchor generateLabel(String text){
		Anchor hl = new Anchor();
		hl.addStyleName("navhyperlink");
		hl.setText(text);
		return hl;
	}
	@Override
	public void setLoginState(boolean loggedIn) {
		if (loggedIn) {
			loginBtn.setText("Logout");
            profileBtn.setVisible(true);
		} else {
			loginBtn.setText("Login");
            profileBtn.setVisible(false);
		}
		isLoggedIn = loggedIn;
	}

    @Override
    public void attachHandlers() {
		aboutBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Controller.getInstance().loadPage(Constants.ABOUT_PAGE);
			}
		});

		lessonBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Controller.getInstance().loadPage(Constants.TASK_SELECTION_PAGE);
			}
		});

		profileBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Controller.getInstance().loadPage(Constants.PROFILE_PAGE);
			}
		});

		loginBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (isLoggedIn) {
					Controller.getInstance().logout();
				} else {
					Controller.getInstance().loadPage(Constants.LOGIN_PAGE);
				}
			}
		});
    }
}
