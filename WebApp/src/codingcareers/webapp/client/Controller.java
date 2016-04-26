package codingcareers.webapp.client;

import java.util.ArrayList;
import java.util.HashMap;

import codingcareers.webapp.client.PageComponents.*;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.core.java.lang.StackTraceElement_CustomFieldSerializer;

public class Controller {
    // TODO Decide on static data or singleton, both makes no sense
    private static PageComposite view;
    private static PageBodyFactory bodyFactory;
    private static History history;
    private static Controller instance;
    private static User currentUser;
    private static int lastTaskPage;

    public static native void log(String s) /*-{
        console.log(s);
    }-*/;

    private Controller() {
        //TODO: Iniditialize model and interpreter
        bodyFactory = new PageBodyFactory();

        // Initialize history information
        history = new History();
        // TODO prevent double page loading
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

    private native String getJSONVal(String obj, String key) /*-{
        var obj = JSON.parse(obj);
        return obj[key];
    }-*/;

    /*
        NOTE: This method should not be directly used if going to a task page. For all other pages it is fine.
     */
	public void loadPage(String pageType)
	{
        log("loadPage" + pageType);
		PageBody content;
        // TODO: Set page body information for the builder based on known information of controller
        bodyFactory.setUser(currentUser);
		try {
			content = bodyFactory.buildPageBody(pageType);
		} catch(InvalidPageException e) {
			log(e.toString());
			return;
		} catch (Exception e) {
            log(e.toString());
            return;
        }

        // Add to history. If TASK_PAGE then it should be added by loadTaskPage.
        if (!pageType.equals(Constants.TASK_PAGE)) {
            history.newItem(pageType);
        }

		view = PageCompositeFlyweightFactory.getInstance().buildPage(content);
		view.load();
	}

    public void loadTaskPage(final int taskID) {
        log("loadTaskPage" + String.valueOf(taskID));

        Model.lookupTaskInfo(taskID, new AsyncCallback<String>() {
            public void onFailure(Throwable caught) {
                Window.alert("Failed to load task information");
            }
            public void onSuccess(String result) {
                // TODO parse result for instructions, tasks, last attempt,
                // code template, etc.
                log(result);
                lastTaskPage = taskID;
                String instructions = getJSONVal(result, "instructions");
                bodyFactory.setInstructions(instructions);
                String tests = getJSONVal(result, "test_code");
                bodyFactory.setTestCases(tests);

                loadPage(Constants.TASK_PAGE);
                history.newItem(Constants.TASK_PAGE + String.valueOf(taskID));
            }
        });
    }

    public void logTaskProgress(int testsPassed, int testsTotal) {
        if(currentUser == null)
            return;

        String sessionID = currentUser.getSession_id();
        if(sessionID == User.INVALID_VALUE)
            return;

        if (testsPassed == testsTotal) {
            currentUser.updateTaskComplete(lastTaskPage);
        }

        Model.updateProgress(lastTaskPage, sessionID, testsPassed, testsTotal,
                new AsyncCallback<String>() {
            public void onFailure(Throwable caught) {
                log("Failed to save task progress");
            }
            public void onSuccess(String result) {
            }
        });
    }

    public void login(String username, String password, final UICallback loginFailure) {
        log("login " + username + password);

        Model.loginUser(username, password, new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable caught) {
                log(caught.toString());
                loginFailure.exec("Could not find username or password.");
            }

            @Override
            public void onSuccess(String result) {
                handleLogIn(result);
            }
        });
    }

    public void logout() {
        Model.logoutUser(currentUser.getUsername(), new AsyncCallback<String>() {
            public void onFailure(Throwable caught) {
                log(caught.toString());
            }
            public void onSuccess(String result) {
                currentUser.logout();
                currentUser = null;
                PageCompositeFlyweightFactory.getInstance().setLoggedInStatus(false);
                loadPage(Constants.LOGIN_PAGE);
            }
        });
    }

    public void createAccount(String username, String password, final UICallback creationFailure) {
        log("create " + username + password);

        Model.createUser(username, password, new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable caught) {
                log(caught.toString());
                creationFailure.exec("Pick unique credentials please!");
            }

            @Override
            public void onSuccess(String result) {
                handleLogIn(result);
            }
        });
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

    private void handleLogIn(String result) {
        log(result);
        String userID = getJSONVal(result, "user_id");
        String username = getJSONVal(result, "username");
        String sessionID = getJSONVal(result, "session_id");
        String taskList = getJSONVal(result, "task_list");
        currentUser = new User(userID, username, sessionID, taskList);
        PageCompositeFlyweightFactory.getInstance().setLoggedInStatus(true);
        loadPage(Constants.PROFILE_PAGE);
    }

}
