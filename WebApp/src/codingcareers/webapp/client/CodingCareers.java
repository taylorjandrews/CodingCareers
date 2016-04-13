package codingcareers.webapp.client;

import codingcareers.webapp.client.PageComponents.*;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
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

    ScriptInjector.fromUrl(GWT.getModuleBaseForStaticFiles() +
        "skulpt.min.js").setCallback(new Callback() {
      public void onFailure(Object reason) {
        Window.alert("Script load failed (skulpt)");
      }
      public void onSuccess(Object result) {
        ScriptInjector.fromUrl(GWT.getModuleBaseForStaticFiles() +
            "skulpt-stdlib.js").setCallback(new Callback() {
          public void onFailure(Object reason) {
            Window.alert("Script load failed (skulpt lib)");
          }
          public void onSuccess(Object result) {
          }
        }).inject();
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
