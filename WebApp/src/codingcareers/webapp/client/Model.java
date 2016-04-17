package codingcareers.webapp.client;

import codingcareers.webapp.client.RPC;
import codingcareers.webapp.client.RPCAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import codingcareers.webapp.client.Constants;

public class Model {
    private static final RPCAsync rpc = GWT.create(RPC.class);

    public static void lookup(String val,
            AsyncCallback<String> callback) {
        rpc.invokeServer(val, callback);
    }

    public static void lookupUser(String user_id,
            AsyncCallback<String> callback) {
        rpc.invokeServer(Constants.LOOKUP_USER + "-" + user_id, callback);
    }

    public static void loginUser(String uname, String pwd,
            AsyncCallback<String> callback) {
        rpc.invokeServer(Constants.LOGIN_USER + "-" + uname + " " + pwd, callback);
    }

    public static void logoutUser(String uname,
            AsyncCallback<String> callback) {
        rpc.invokeServer(Constants.LOGOUT_USER + "-" + uname, callback);
    }

    public static void createUser(String uname, String pwd,
            AsyncCallback<String> callback) {
        rpc.invokeServer(Constants.CREATE_USER + "-" + uname + pwd, callback);
    }

    public static void updateProgress(String progress,
            AsyncCallback<String> callback) {
        rpc.invokeServer(Constants.UPDATE_PROGRESS + "-" + progress, callback);
    }

    public static void lookupTaskInfo(int taskID,
            AsyncCallback<String> callback) {
        rpc.invokeServer(Constants.LOOKUP_TASK_INFO + "-" + String.valueOf(taskID), callback);
    }

    public static void selectChar(String choice,
            AsyncCallback<String> callback) {
        rpc.invokeServer(Constants.SELECT_CHARACTER + "-" + choice, callback);
    }
}
