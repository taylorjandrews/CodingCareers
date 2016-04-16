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

  private PageBodyFactory bodyFactory = new PageBodyFactory();

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
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
              Controller controller = Controller.getInstance();
              controller.loadPage(Constants.ABOUT_PAGE);
          }
        }).inject();
      }
    }).inject();

  }
}
