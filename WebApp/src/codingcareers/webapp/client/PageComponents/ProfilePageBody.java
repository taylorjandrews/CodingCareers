package codingcareers.webapp.client.PageComponents;

import codingcareers.webapp.client.Constants;
import codingcareers.webapp.client.User;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.util.ArrayList;

public class ProfilePageBody extends PageBody {

	Label usernameTitle;
	Label ranking;
    ArrayList<ProgressPanel> progressBars;
    User currUser;

    private final String USERNAME_FIELD = "Username: ";
    private final String RANK_FIELD = "Current Rank: ";
    private final String[] RANKINGS = {"Newbie", "Novice", "Proficient", "Expert", "Start Coder"};


	public ProfilePageBody() {
        DockPanel topPanel = new DockPanel();

		VerticalPanel infoPanel = new VerticalPanel();
		usernameTitle = new Label();
		usernameTitle.setText("Username: NO USER SELECTED");
		infoPanel.add(usernameTitle);
		ranking = new Label();
		ranking.setText("Current Rank: NO RANK");
        infoPanel.add(ranking);
        topPanel.add(infoPanel, DockPanel.EAST);

        add(topPanel, DockPanel.NORTH);
        VerticalPanel progressPanel = new VerticalPanel();
        progressBars = constructProgressBars();
        for (VerticalPanel vp : progressBars) {
            progressPanel.add(vp);
        }

        add(progressPanel, DockPanel.CENTER);

	}

	public void setUser(User user) {
        currUser = user;

        //Update user info on page
		usernameTitle.setText(USERNAME_FIELD + user.getUsername());
        ranking.setText(RANK_FIELD + getRank());
	}

    private String getRank() {
        int totalComplete = 0;
        for (String task : Constants.TASK_SUBJECTS) {
            totalComplete += getTaskCompleteness(task);
        }
        return RANKINGS[(int) Math.ceil(totalComplete/5.0) - 1];
    }

    private ArrayList<ProgressPanel> constructProgressBars() {
        ArrayList<ProgressPanel> progressBarCollection = new ArrayList<>();
        for (String task : Constants.TASK_SUBJECTS) {
            progressBarCollection.add(new ProgressPanel(task, getTaskCompleteness(task)));
        }
        return progressBarCollection;
    }

    private int getTaskCompleteness(String task) {
        if (currUser == null) {
            return 0;
        } else {
            return currUser.getTaskTotalCompletion(task);
        }
    }

	@Override
	public void attachHandlers() {
		// STUB
	}
}
