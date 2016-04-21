package codingcareers.webapp.client;

import java.util.HashMap;

/**
 * Created by ian on 4/16/16.
 */
public class User {
    private final String user_id;
    private final String username;
    private String session_id;
    private boolean loggedIn;
    private HashMap<String, int[]> taskProgress;

    public final static String INVALID_VALUE = "not_valid";

    public User(String user_id, String username, String session_id) {
        this.user_id = user_id;
        this.username = username;
        this.session_id = session_id;
        loggedIn = true;
    }

    public String getUser_id() {
        if (loggedIn) {
            return user_id;
        } else {
            return INVALID_VALUE;
        }
    }

    public String getUsername() {
        if (loggedIn) {
            return username;
        } else {
            return INVALID_VALUE;
        }
    }

    public String getSession_id() {
        if (loggedIn) {
            return session_id;
        } else {
            return INVALID_VALUE;
        }
    }

    public int getTaskTotalCompletion(String taskName) {
        int[] bitVector = getTaskBitVector(taskName);
        int sum = 0;
        for (int i = 0; i < Constants.TOTAL_LESSONS_IN_SUBJECT; i++) {
            sum += bitVector[i];
        }
        return sum;
    }

    // Lazy loading so if we haven't looked it up yet it will be looked up now
    public int[] getTaskBitVector(String taskName) {
        if (taskProgress == null) {
            taskProgress = loadInTaskProgress();
        }
        return taskProgress.get(taskName);

    }

    private HashMap<String, int[]> loadInTaskProgress() {
        HashMap<String, int[]> initialized = new HashMap<>();
        for (String task : Constants.TASK_SUBJECTS) {
            int[] bitMap = new int[Constants.TOTAL_LESSONS_IN_SUBJECT];
            for (int i = 0; i < Constants.TOTAL_LESSONS_IN_SUBJECT; i++) {
                bitMap[i] = 0;
            }
            initialized.put(task, bitMap);
        }
        // TODO: Load in information from database
        return initialized;
    }

    public void logout() {
        loggedIn = false;
        session_id = null;
    }
}
