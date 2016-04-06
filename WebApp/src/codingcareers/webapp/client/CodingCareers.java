package codingcareers.webapp.client;

import codingcareers.webapp.client.PageComponents.*;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CodingCareers implements EntryPoint {
  /**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   */
  private static final String SERVER_ERROR = "An error occurred while "
      + "attempting to contact the server. Please check your network "
      + "connection and try again.";

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

    private PageBodyFactory bodyFactory = new PageBodyFactory();

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
//      PageBody content = new LoginPageBody();
//      PageHeader header = new BasicHeader();
//      PageFooter footer = new BasicFooter();
//
//      PageComposite assembled = new PageComposite(header, content, footer);
//      assembled.load();

      PageBody content;
      try {
          content = bodyFactory.buildPageBody(Constants.LOGIN_PAGE);
      } catch(InvalidPageException e) {
          System.out.println("Exception thrown:" + e);
          return;
      }
      PageCompositeFlyweightFactory.getInstance().buildPage(content).load();
  }
}
