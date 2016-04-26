package codingcareers.webapp.client.PageComponents;

import codingcareers.webapp.client.Controller;
import codingcareers.webapp.client.User;

import java.util.ArrayList;

import static codingcareers.webapp.client.Constants.*;

public class PageBodyFactory {

	private final int NOT_SELECTED = -1;

	private String instructions;
	private String tests;
	private User user;
	
	//TODO Fill out specific construction for each page
	public PageBody buildPageBody(String pageType) throws InvalidPageException {
		PageBody toBuild;
        switch (pageType) {
			case ABOUT_PAGE:
				toBuild =  new AboutPageBody();
                break;
            case LOGIN_PAGE:
                toBuild =  new LoginPageBody();
                break;
            case TASK_PAGE:
                toBuild =  new TaskPageBody(instructions, tests);
                break;
            case TASK_SELECTION_PAGE:
                toBuild =  new TaskSelectionPageBody();
                break;
            case PROFILE_PAGE:
                if (user == null) {
                    toBuild = new LoginPageBody();
                } else {
                    toBuild = new ProfilePageBody(user);
                }
                break;
            case PROFILE_CREATION:
                toBuild = new ProfileCreationBody();
                break;
            default:
                throw new InvalidPageException("Invalid page type give for construction.");
		}
        clearParams();
        return toBuild;
	};


	public void setInstructions(String instructions){
		this.instructions = instructions;
	}


	public void setTestCases(String tests){
        this.tests = tests;
	}

	public void setUser(User user){
		this.user = user;
	}

    private void clearParams() {
        instructions = null;
        tests = null;
        user = null;
    }
	
}
