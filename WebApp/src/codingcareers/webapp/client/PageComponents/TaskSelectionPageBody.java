package codingcareers.webapp.client.PageComponents;

import codingcareers.webapp.client.Constants;
import codingcareers.webapp.client.Controller;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.core.client.GWT;

import java.util.ArrayList;

public class TaskSelectionPageBody extends PageBody{

    private int titleNumber = 4;

    private int lessonNumber = 20;
    private ArrayList<PushButton> pbs;

	public TaskSelectionPageBody() {
        this.addStyleName("pp");
        pbs = new ArrayList<PushButton>();

	    VerticalPanel vp = new VerticalPanel();
	    HorizontalPanel hp0 = new HorizontalPanel();
	    HorizontalPanel hp1 = new HorizontalPanel();
	    HorizontalPanel hp2 = new HorizontalPanel();
	    HorizontalPanel hp3 = new HorizontalPanel();

        //currently hardcode the lesson title
        Label title1 = new Label("Lesson 1: Help through Code");
        Label title2 = new Label("Lesson 2: NASA");
        Label title3 = new Label("Lesson 3: The FBI");
        Label title4 = new Label("Lesson 4: iOS-Developer");
        title1.addStyleName("lessonTitle");
        title2.addStyleName("lessonTitle");
        title3.addStyleName("lessonTitle");
        title4.addStyleName("lessonTitle");

        for(int i = 1; i < titleNumber+1; i++){
            for(int j = 1; j < 6; j++){
                Image image = genImage("images/lessonpictures/"+Integer.toString(i) +"."+Integer.toString(j)+".png");
                PushButton pb = new PushButton(image);
                pb.setPixelSize(100,100);
                pbs.add(pb);
            }
        }
        attachHandlers();

        for(int ii = 0; ii < titleNumber; ii++ ){
            hp0.add(pbs.get(ii));
            hp1.add(pbs.get(ii+5));
            hp2.add(pbs.get(ii+10));
            hp3.add(pbs.get(ii+15));
        }


        vp.add(title1);
        vp.add(hp0);
	    vp.add(title2);
        vp.add(hp1);
	    vp.add(title3);
        vp.add(hp2);
	    vp.add(title4);
        vp.add(hp3);


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
        for(int index = 0; index < pbs.size(); index++){
            final int ii = index;
            (pbs.get(index)).addClickHandler(new ClickHandler() {
                    public void onClick(ClickEvent event) {
                        Controller.getInstance().loadTaskPage(ii);
                    }
                });
        }

    }
}
