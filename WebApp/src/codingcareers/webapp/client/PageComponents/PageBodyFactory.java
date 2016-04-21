package codingcareers.webapp.client.PageComponents;

import codingcareers.webapp.client.Controller;
import codingcareers.webapp.client.User;

import java.util.ArrayList;

import static codingcareers.webapp.client.Constants.*;

public class PageBodyFactory {

	private final int NOT_SELECTED = -1;

    private int reward = NOT_SELECTED;
	private String instructions;
	private String tests;
	private String solutions;
	private ArrayList<Integer> progress;
	private User user;
	
	//TODO Fill out specific construction for each page
	public PageBody buildPageBody(String pageType) throws InvalidPageException {
		PageBody toBuild;
        switch (pageType) {
			case ABOUT_PAGE:
				toBuild =  new AboutPageBody();
                break;
			case CHARACTER_CREATION_PAGE:
                toBuild =  new CharacterCreationPageBody();
                break;
            case LANDING_PAGE:
                toBuild =  new LandingPageBody();
                break;
            case LOGIN_PAGE:
                toBuild =  new LoginPageBody();
                break;
            case PROGRESS_PAGE:
                toBuild =  new ProgressPageBody();
                break;
            case TASK_PAGE:
                toBuild =  new TaskPageBody(instructions, tests);
                break;
            case TASK_SELECTION_PAGE:
                toBuild =  new TaskSelectionPageBody();
                break;
            case PROFILE_PAGE:
                ProfilePageBody body = new ProfilePageBody();
                if (user != null) {
                    body.setUser(user);
                }
                toBuild = body;
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

	public void setRewards(int reward){
		this.reward = reward;
	}

	public void setInstructions(String instructions){
		this.instructions = instructions;
	}

	public void setPreviousSolution(String solutions){
        this.solutions = solutions;
	}

	public void setProgress(ArrayList<Integer> progress){
		this.progress = progress;
	}

	public void setTestCases(String tests){
        this.tests = tests;
	}

	public void setUser(User user){
		this.user = user;
	}

    private void clearParams() {
        reward = NOT_SELECTED;
        instructions = null;
        tests = null;
        progress = null;
        user = null;
    }
	
}
