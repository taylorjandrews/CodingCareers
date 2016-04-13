package codingcareers.webapp.client.PageComponents;

import codingcareers.webapp.client.Constants;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Anchor;
public class BasicHeader extends PageHeader {

	public BasicHeader() {
       
       Anchor aboutBtn = generateLabel("About");
       Anchor lessonBtn = generateLabel("Lessons");
       Anchor profileBtn = generateLabel("Profile");
       Anchor loginBtn= generateLabel("Login");
       
       //TODO: eventHandler for all Hyperlink
       add(aboutBtn);
       add(lessonBtn);
       add(profileBtn);
       add(loginBtn);
       aboutBtn.addClickHandler(new ClickHandler() {
   	    public void onClick(ClickEvent event) {
   	        // handle the click event
   	    	
   	    	if(((Anchor)event.getSource()).getText() == "About"){
   	    		((Anchor)event.getSource()).setText("Bout");
   	    	}else{
   	    		((Anchor)event.getSource()).setText("About");
   	    	}
   	      }
   	    }); 
       
	}
	public Anchor generateLabel(String text){
		Anchor hl = new Anchor();
		hl.addStyleName("navhyperlink");
		hl.setText(text);
		return hl;
	}
	@Override
	public void setLoginState(boolean loggedIn) {
		// STUB
		return;
	}

	@Override
	public void setUsername(String username) {
		// STUB
		return;
	}

    @Override
    public void attachHandlers() {
        // STUB
    }
}
