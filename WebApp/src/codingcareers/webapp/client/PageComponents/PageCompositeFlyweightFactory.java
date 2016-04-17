package codingcareers.webapp.client.PageComponents;

import java.util.HashMap;

/**
 * Created by ian on 4/5/16.
 */
public class PageCompositeFlyweightFactory {

    private static PageCompositeFlyweightFactory instance = new PageCompositeFlyweightFactory();
    private PageComposite pageShell;

    private PageCompositeFlyweightFactory() {
        pageShell = new PageComposite();
        pageShell.setPageFooter(new BasicFooter());
        pageShell.setPageHeader(new BasicHeader());
    }

    public static PageCompositeFlyweightFactory getInstance() {
        return instance;
    }

    public PageComposite buildPage(PageBody pageType) {
        pageShell.setPageBody(pageType);
        return pageShell;
    }

    public void setLoggedInStatus(boolean loggedIn) {
        BasicHeader header = new BasicHeader();
        header.setLoginState(loggedIn);
        pageShell.setPageHeader(header);
    }


}
