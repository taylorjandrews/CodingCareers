package codingcareers.webapp.client.PageComponents;

import codingcareers.webapp.client.Constants;
import codingcareers.webapp.client.Controller;
import codingcareers.webapp.client.User;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.util.ArrayList;
import java.util.HashMap;

public class ProfilePageBody extends PageBody {

	Label usernameTitle;
	Label ranking;
    HashMap<String, ProgressPanel> progressBars;
    VerticalPanel progressPanel;
    User currUser;

    private final String USERNAME_FIELD = "Username: ";
    private final String RANK_FIELD = "Current Rank: ";
    private final String[] RANKINGS = {"Newbie", "Novice", "Proficient", "Expert", "Start Coder"};


	public ProfilePageBody(User user) {
        assert(user != null);
        currUser = user;

        DockPanel topPanel = new DockPanel();

		VerticalPanel infoPanel = new VerticalPanel();
		usernameTitle = new Label();
        usernameTitle.setText(USERNAME_FIELD + user.getUsername());
        usernameTitle.addStyleName("profile-username");

		infoPanel.add(usernameTitle);
		ranking = new Label();
        ranking.setText(RANK_FIELD + getRank());
        ranking.addStyleName("profile-rank");
        infoPanel.add(ranking);

        topPanel.add(infoPanel, DockPanel.EAST);
        add(topPanel, DockPanel.NORTH);

        progressPanel = new VerticalPanel();
        progressBars = constructProgressBars();
        for (String task : Constants.TASK_SUBJECTS) {
            progressPanel.add(progressBars.get(task));
        }

        add(progressPanel, DockPanel.CENTER);

	}

    private String getRank() {
        int totalComplete = 0;
        for (String task : Constants.TASK_SUBJECTS) {
            totalComplete += getTaskCompleteness(task);
        }
        int rankIndex = (int) Math.ceil(totalComplete/5.0) - 1;
        if (rankIndex < 0) {
            rankIndex = 0;
        }
        return RANKINGS[rankIndex];
    }

    private HashMap<String, ProgressPanel> constructProgressBars() {
        HashMap<String, ProgressPanel> progressBarCollection = new HashMap<>();
        for (String task : Constants.TASK_SUBJECTS) {
            progressBarCollection.put(task, new ProgressPanel(task, getTaskCompleteness(task)));
        }
        return progressBarCollection;
    }

    private int getTaskCompleteness(String task) {
        if (currUser == null) {
            return 0;
        } else {
            int toReturn = 0;
            try {
                toReturn = currUser.getTaskTotalCompletion(task);
            } catch (NullPointerException e) {
                toReturn = 0;
            }
            return toReturn;
        }
    }

	@Override
	public void attachHandlers() {
		// STUB
	}
}
