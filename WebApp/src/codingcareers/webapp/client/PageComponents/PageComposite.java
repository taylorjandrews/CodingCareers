package codingcareers.webapp.client.PageComponents;


import codingcareers.webapp.client.Constants;
import com.gargoylesoftware.htmlunit.Page;
import com.google.gwt.user.client.ui.HeaderPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class PageComposite implements PageComponent {

    private final int HEADER = 0;
    private final int BODY = 1;
    private final int FOOTER = 2;
    private final int TOTAL_COMPONENTS = 3;

    private PageComponent[] components = new PageComponent[TOTAL_COMPONENTS];

	public PageComposite() {
        return;
    }

    public PageComposite(PageHeader header, PageBody body, PageFooter footer) {
		components[HEADER] = header;
        components[BODY] = body;
        components[FOOTER] = footer;
	}

    public void setPageHeader(PageHeader header) {
        components[HEADER] = header;
    }

    public void setPageBody(PageBody body) {
        components[BODY] = body;
    }

    public void setPageFooter(PageFooter footer) {
        components[FOOTER] = footer;
    }

    @Override
    public void load() {
        for (PageComponent component : components) {
            component.load();
        }
    }

    @Override
    public void attachHandlers() {
        // STUB
    }
}
