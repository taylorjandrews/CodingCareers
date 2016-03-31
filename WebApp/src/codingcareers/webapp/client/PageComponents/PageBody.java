package codingcareers.webapp.client.PageComponents;

import codingcareers.webapp.client.Constants;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.RootPanel;


public abstract class PageBody extends DockPanel implements PageComponent {

    public void load() {
        RootPanel.get(Constants.BODY_ID).add(this);
	}
}
