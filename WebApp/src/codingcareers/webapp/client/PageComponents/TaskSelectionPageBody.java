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
        this.addStyleName("pp");
	    VerticalPanel vp = new VerticalPanel();
		Label title1 = new Label("Lesson 1: Help through Code");
		Label title2 = new Label("Lesson 2: NASA");
		Label title3 = new Label("Lesson 3: The FBI");
		Label title4 = new Label("Lesson 4: iOS-Developer");


	    FlowPanel fp = new FlowPanel();
	    FlowPanel fp2 = new FlowPanel();
	    FlowPanel fp3 = new FlowPanel();
	    FlowPanel fp4 = new FlowPanel();


	    Image image1 = genImage("https://pbs.twimg.com/profile_images/454613053103828993/nxzP0n4r.jpeg");
	    Image image2 = genImage("https://pbs.twimg.com/profile_images/454613053103828993/nxzP0n4r.jpeg");
	    Image image3 = genImage("https://pbs.twimg.com/profile_images/454613053103828993/nxzP0n4r.jpeg");
	    Image image4 = genImage("https://pbs.twimg.com/profile_images/454613053103828993/nxzP0n4r.jpeg");
	    Image image5 = genImage("https://pbs.twimg.com/profile_images/454613053103828993/nxzP0n4r.jpeg");
	    Image image6 = genImage("https://pbs.twimg.com/profile_images/454613053103828993/nxzP0n4r.jpeg");
	    Image image7 = genImage("https://pbs.twimg.com/profile_images/454613053103828993/nxzP0n4r.jpeg");
	    Image image8 = genImage("https://pbs.twimg.com/profile_images/454613053103828993/nxzP0n4r.jpeg");



        title1.addStyleName("lessonTitle");
        title2.addStyleName("lessonTitle");
        title3.addStyleName("lessonTitle");
        title4.addStyleName("lessonTitle");

	    fp.add(image1);
	    fp.add(image2);
	    fp2.add(image3);
	    fp2.add(image4);
	    fp3.add(image5);
	    fp3.add(image6);
	    fp4.add(image7);
	    fp4.add(image8);

        vp.add(title1);
	    vp.add(fp);
	    vp.add(title2);
        vp.add(fp2);
	    vp.add(title3);
        vp.add(fp3);
	    vp.add(title4);
        vp.add(fp4);


		add(vp, DockPanel.NORTH);



	}
	//TODO - setProgress(completedTasks: ArrayList<Integer>): void
	private void setProgress(ArrayList<Integer> completedTasks){
		return;
	}
    private Image genImage(String addr){
        Image img = new Image();
        img.setUrl(addr);
        img.setPixelSize(100,100);
        return img;


    }
	@Override
	public void attachHandlers() {
		// STUB
	}
}
