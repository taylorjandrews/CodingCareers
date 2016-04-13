package codingcareers.webapp.client.PageComponents;

import com.google.gwt.user.client.ui.Label;

public class BasicFooter extends PageFooter{
	
	public BasicFooter() {
        Label credits = new Label();
        credits.addStyleName("footText");
        credits.setText("Created by Taylor Andrews, Ian Char, Lauren Mitchell, Alan Moy, and Peilun Zhang");
        add(credits);
    }

	@Override
	public void attachHandlers() {
		// STUB
		return;
	}
}
