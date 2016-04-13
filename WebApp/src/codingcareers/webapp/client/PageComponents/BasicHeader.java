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

       
	}
	public Anchor generateLabel(String text){
		Anchor hl = new Anchor();
		hl.addStyleName("navhyperlink");
		hl.setText(text);
		return hl;
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
				Controller.getInstance().loadPage(Constants.PROGRESS_PAGE);
			}
		});

		loginBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Controller.getInstance().loadPage(Constants.LOGIN_PAGE);
			}
		});
    }
}
