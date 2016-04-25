package codingcareers.webapp.client.PageComponents;

import codingcareers.webapp.client.Constants;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.apache.bcel.classfile.Constant;

/**
 * Created by ian on 4/21/16.
 */
public class ProgressPanel extends VerticalPanel {

    private Label taskLabel;
    private Label tasksCompleteLabel;
    private ProgressBar progressBar;

    private final String TASK_COMPLETED_LABEL = "Completed: ";

    public ProgressPanel(String taskName, int taskCompletion) {
        taskLabel = new Label();
        taskLabel.setText(taskName);
        taskLabel.addStyleName("task-subject-header");
        add(taskLabel);

        tasksCompleteLabel = new Label();
        progressBar = new ProgressBar(taskCompletion, Constants.TOTAL_LESSONS_IN_SUBJECT);
        updateTaskCompletion(taskCompletion);

        add(tasksCompleteLabel);
        add(progressBar);
    }

    public void updateTaskCompletion(int taskCompletion) {
        tasksCompleteLabel.setText(TASK_COMPLETED_LABEL + Integer.toString(taskCompletion)
                + "/" + Integer.toString(Constants.TOTAL_LESSONS_IN_SUBJECT));

        progressBar.setProgress(taskCompletion);
    }
}
