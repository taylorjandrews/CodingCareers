package codingcareers.webapp.client;

import java.util.ArrayList;
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

    public User(String user_id, String username, String session_id, String taskList) {
        this.user_id = user_id;
        this.username = username;
        this.session_id = session_id;
        parseInTasks(taskList);
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
    public int[] getTaskBitVector(String taskName) throws NullPointerException {
        int[] toReturn;
        try {
            toReturn = taskProgress.get(taskName);
        } catch (NullPointerException e) {
            Controller.log("Task progress not updated in time!");
            throw e;
        }
        return toReturn;

    }

    public void updateTaskComplete(int taskId) {
        // Since we actually are starting at 0 increase the task by 1
        taskId++;

        String taskName = taskIdToTaskSubject(taskId);
        int[] bitMap = taskProgress.get(taskName);
        bitMap[(taskId - 1) % (Constants.TOTAL_LESSONS_IN_SUBJECT )] = 1;
        Controller.log(taskName + ", " + Integer.toString((taskId - 1) % (Constants.TOTAL_LESSONS_IN_SUBJECT + 1)));
        taskProgress.put(taskName, bitMap);
    }

    private void parseInTasks(String taskList) {
        // Here args is assumed to be a comma separated string of task ids
        String[] splitArgs = taskList.split(", ");
        ArrayList<Integer> testIds = new ArrayList<Integer>();
        for (String id : splitArgs) {
            try {
                testIds.add(Integer.parseInt(id));
            } catch (NumberFormatException e) {
                continue;
            }
        }
        taskProgress = new HashMap<>();

        // Fill taskProgress with blank bit maps
        for (String task : Constants.TASK_SUBJECTS) {
            int[] bitMap = new int[Constants.TOTAL_LESSONS_IN_SUBJECT];
            for (int i = 0; i < Constants.TOTAL_LESSONS_IN_SUBJECT; i++) {
                bitMap[i] = 0;
            }
            taskProgress.put(task, bitMap);
        }

        for (Integer id : testIds) {
            updateTaskComplete(id);
        }
    }

    private String taskIdToTaskSubject(int taskId) {
        int nameIndex = (taskId - 1)/Constants.TOTAL_LESSONS_IN_SUBJECT;
        if (nameIndex < 0) {
            nameIndex = 0;
        } else if (nameIndex >= Constants.TASK_SUBJECTS.length) {
            nameIndex = Constants.TASK_SUBJECTS.length - 1;
        }
        return Constants.TASK_SUBJECTS[nameIndex];
    }

    public void logout() {
        loggedIn = false;
        session_id = null;
    }
}
