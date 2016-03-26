package codingcareers.webapp.client.PageComponents;

import codingcareers.webapp.client.Constants;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;

public abstract class PageFooter extends HorizontalPanel implements PageComponent {
	// TODO PageFooter load()
	public void load(){
		RootPanel.get(Constants.FOOTER_ID).add(this);
	};
}
