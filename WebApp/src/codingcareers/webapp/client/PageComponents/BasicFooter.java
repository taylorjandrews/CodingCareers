package codingcareers.webapp.client.PageComponents;

import com.google.gwt.user.client.ui.Label;

public class BasicFooter extends PageFooter{
	
	public BasicFooter() {
        Label credits = new Label();
        credits.setText("Peoples names");
        add(credits);
    }

	@Override
	public void attachHandlers() {
		// STUB
		return;
	}
}
