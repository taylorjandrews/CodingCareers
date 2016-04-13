package codingcareers.webapp.client;

import java.util.ArrayList;

import codingcareers.webapp.client.PageComponents.*;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;

public class Controller{
	private static PageComposite view;
	private static Model model;
	private static CodeInterpreter interpreter;
	private static PageBodyFactory bodyFactory;
    private static History history;

    private static Controller instance;

    private Controller() {
        //TODO: Iniditialize model and interpreter
        bodyFactory = new PageBodyFactory();

        // Initialize history information
        history = new History();
        history.addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> event) {
                String historyToken = event.getValue();
                System.out.println(historyToken);

                // Is the desired page TaskPage or not?
                if (isNumeric(historyToken.substring(historyToken.length() - 1))) {
                    int numStartIndex = historyToken.length() - 1;
                    for (int i = historyToken.length() - 2; i > 0; i--) {
                        if (!isNumeric(historyToken.substring(i))) {
                            numStartIndex = i + 1;
                            break;
                        }
                    }
                    int taskNumber = Integer.parseInt(historyToken.substring(numStartIndex));
                    loadTaskPage(taskNumber);
                } else {
                    loadPage(historyToken);
                }
            }
        });
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    /*
        NOTE: This method should not be directly used if going to a task page. For all other pages it is fine.
     */
	public void loadPage(String pageType)
	{
		PageBody content;
        // TODO: Set page body information for the builder based on known information of controller
		try {
			content = bodyFactory.buildPageBody(pageType);
		} catch(InvalidPageException e) {
			System.out.println("Exception thrown:" + e);
			return;
		}

        // Add to history. If TASK_PAGE then it should be added by loadTaskPage.
        if (!pageType.equals(Constants.TASK_PAGE)) {
            history.newItem(pageType);
        }

		view = PageCompositeFlyweightFactory.getInstance().buildPage(content);
		view.load();
	}

    public void loadTaskPage(int taskID) {
        //TODO: fetch task information from database and load it into bodyFactor

        loadPage(Constants.TASK_PAGE);
        history.newItem(Constants.TASK_PAGE + String.valueOf(taskID));
    }

    /*
    Code for this found at http://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
     */
    private boolean isNumeric(String str) {
        try {
            double d = Integer.parseInt(str);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }
	
	//TODO: handleWidgetInput(s: String, callback: UICallback): void
	public void handleWidgetInput(String s, UICallback callback){
		return;
	}
	//TODO:handleSubmittedCode(code: String, tests: ArrayList<String>, callback:UICallback): void
	public void handleSubmittedCode(String code, ArrayList<String> tests, UICallback callback){
		return;
	}
	//TODO: handleUserCreation(uname: String, pword: String, callback:UICallback): void
	public void handleUserCreation(String uname, String pword, UICallback callback){
		return;
	}
	//TODO: handleCharSelection(choices: ArrayList<String>, callback:UICallback): void
	public void handleCharSelection(ArrayList<String> choices, UICallback callback){
		return;
	}
	//TODO: isLoggedIn(): boolean
	public boolean isLoggedIn(){
		return false;
	}
	//TODO: installHintTimer(hintCallback: UICallback, time:int):void 
	public void installHintTimer(UICallback hintCallBack, int time){
		return;
	}
	//TODO: mangeHintTimer(hintCallback:UICallback)
	//TODO: manage or mange, potentially a typo
	public void mangeHintTimer(UICallback hintCallback){
		return;
	};
}