package codingcareers.webapp.client.PageComponents;

import java.util.ArrayList;

import static codingcareers.webapp.client.Constants.*;

public class PageBodyFactory {

	private final int NOT_SELECTED = -1;

    private int reward = NOT_SELECTED;
	private String instruction;
	private ArrayList<String> tests;
	private String solutions;
	private ArrayList<Integer> progress;
	private String profile;
	
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
                toBuild =  new TaskPageBody();
                break;
            case TASK_SELECTION_PAGE:
                toBuild =  new TaskSelectionPageBody();
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

	public void setInstructions(String instruction){
		this.instruction = instruction;
	}

	public void setPreviousSolution(String solutions){
        this.solutions = solutions;
	}

	public void setProgress(ArrayList<Integer> progress){
		this.progress = progress;
	}

	public void setTestCases(ArrayList<String> tests){
        this.tests = tests;
	}

	public void setProfile(String profile){
		this.profile = profile;
	}

    private void clearParams() {
        reward = NOT_SELECTED;
        instruction = null;
        tests = null;
        progress = null;
        profile = null;
    }
	
}
