package codingcareers.webapp.client.PageComponents;

import codingcareers.webapp.client.Constants;
import codingcareers.webapp.client.Controller;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockPanel;

import java.util.ArrayList;

public class TaskSelectionPageBody extends PageBody{

	public TaskSelectionPageBody() {
		Button testButton = new Button("Task Selection!");
		testButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Controller.getInstance().loadTaskPage(25);
			}
		});
		add(testButton, DockPanel.CENTER);
	}
	//TODO - setProgress(completedTasks: ArrayList<Integer>): void
	private void setProgress(ArrayList<Integer> completedTasks){
		return;
	}

	@Override
	public void attachHandlers() {
		// STUB
	}
}
