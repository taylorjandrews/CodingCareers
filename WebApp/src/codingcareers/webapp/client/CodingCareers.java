package codingcareers.webapp.client;

import codingcareers.webapp.client.PageComponents.*;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import org.apache.bcel.classfile.Constant;
//import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.core.client.Callback;
import com.google.gwt.user.client.Window;

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

  private final PageBodyFactory bodyFactory = new PageBodyFactory();

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    Controller controller = Controller.getInstance();
    controller.loadPage(Constants.ABOUT_PAGE);

    ScriptInjector.fromUrl(GWT.getModuleBaseForStaticFiles() +
        "skulpt.min.js").setCallback(new Callback() {
      public void onFailure(Object reason) {
        Window.alert("Script load failed");
      }
      public void onSuccess(Object result) {
      }
    }).inject();

    ScriptInjector.fromUrl(GWT.getModuleBaseForStaticFiles() +
        "skulpt-stdlib.js").setCallback(new Callback() {
      public void onFailure(Object reason) {
        Window.alert("Script load failed");
      }
      public void onSuccess(Object result) {
      }
    }).inject();

    PageBody content;
    try {
      content = bodyFactory.buildPageBody(Constants.TASK_PAGE);
    } catch(InvalidPageException e) {
      System.out.println("Exception thrown:" + e);
      return;
    }
    PageCompositeFlyweightFactory.getInstance().buildPage(content).load();
  }
}
