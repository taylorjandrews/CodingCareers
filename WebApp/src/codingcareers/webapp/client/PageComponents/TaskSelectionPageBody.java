package codingcareers.webapp.client.PageComponents;

import codingcareers.webapp.client.Constants;
import codingcareers.webapp.client.Controller;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Image;

import java.util.ArrayList;

public class TaskSelectionPageBody extends PageBody{

	public TaskSelectionPageBody() {
	    VerticalPanel vp = new VerticalPanel();
		Label title1 = new Label("Lesson 1: Help through Code");
		Label title2 = new Label("Lesson 2: NASA"); 
		Label title3 = new Label("Lesson 3: The FBI"); 
		Label title4 = new Label("Lesson 4: iOS-Developer"); 

	    FlowPanel fp = new FlowPanel();
	    Image image1 = genImage("http://www.tutorialspoint.com/images/gwt-mini.png"); 
	    Image image2 = genImage("http://www.tutorialspoint.com/images/gwt-mini.png"); 
	    Image image3 = genImage("http://www.tutorialspoint.com/images/gwt-mini.png"); 
	    Image image4 = genImage("http://www.tutorialspoint.com/images/gwt-mini.png"); 

	    fp.add(image1); 
	    fp.add(image2); 
	    fp.add(image4); 
        fp.insert(image3, 3); 

        vp.add(title1);
	    vp.add(fp);
	    vp.add(title2);
	    vp.add(title3);
	    vp.add(title4);
		
		
		add(vp, DockPanel.NORTH);



	}
	//TODO - setProgress(completedTasks: ArrayList<Integer>): void
	private void setProgress(ArrayList<Integer> completedTasks){
		return;
	}
    private Image genImage(String addr){
        Image img = new Image();
        img.setUrl(addr);
        return img;
        

    }
	@Override
	public void attachHandlers() {
		// STUB
	}
}
