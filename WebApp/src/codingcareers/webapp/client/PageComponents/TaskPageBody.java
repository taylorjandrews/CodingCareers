package codingcareers.webapp.client.PageComponents;

import java.util.ArrayList;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.TextArea;

public class TaskPageBody extends PageBody {

	public TaskPageBody() {
		TextArea testbox = new TextArea();
		TextArea testbox2 = new TextArea();
		TextArea testbox3 = new TextArea();
		testbox.setText("Lorem ipsum dolor sit amet. Nunc vulputate justo ac purus gravida, vitae scelerisque tortor scelerisque. Nunc finibus magna urna, non sollicitudin felis ullamcorper eu. Phasellus dolor ante, convallis sed ornare quis, ultrices vitae augue. Aliquam porttitor, massa quis dignissim luctus, arcu ante auctor quam, interdum aliquet dolor eros id purus. Suspendisse rhoncus, mi molestie consectetur ultricies, dui eros tempus dolor, vitae faucibus turpis dui vel sapien.");
		testbox2.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer enim urna, cursus non luctus eu, porttitor a velit. Quisque at eros quis erat blandit finibus. Mauris nec est velit. Donec lobortis nibh metus, at sollicitudin risus iaculis sed. Suspendisse elementum dolor venenatis lobortis sagittis. Maecenas lobortis, diam eu vestibulum consequat, erat dolor eleifend erat, condimentum pretium tellus tellus maximus lectus. Phasellus at magna vel libero facilisis consequat sed id ligula. Phasellus pellentesque, nibh at rutrum ultricies, nisi erat eleifend odio, et egestas dolor diam vitae nisl. Sed sagittis volutpat erat, quis interdum ligula condimentum sit amet. Aenean nisi urna, volutpat at orci sed, convallis sodales sapien. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent aliquet porta mi at sollicitudin. Nam quis eros vel ante mattis egestas.Curabitur egestas malesuada est, at venenatis ligula semper ut. Ut nec tincidunt odio, nec tempor nulla. Duis odio massa, tempus eu metus ut, aliquam porttitor nulla. Mauris et rutrum lorem. Mauris ullamcorper tempor accumsan. Cras rhoncus nulla non massa facilisis, nec vestibulum ex hendrerit. Fusce tortor orci, blandit ut dolor ac, commodo mollis turpis. Nam gravida sollicitudin mollis.Etiam rhoncus bibendum metus, eget consectetur massa pulvinar vitae. Nam pretium urna sagittis, luctus quam a, tincidunt erat. Mauris enim lacus, auctor sit amet ultrices at, ultricies ac turpis. Duis sed augue sit amet nisi pharetra rutrum id sed leo. Nunc imperdiet ex nec ante porttitor viverra. Sed eu turpis sapien. In bibendum dolor at dignissim pharetra. Fusce elementum aliquam feugiat. Morbi molestie justo eget ipsum mattis, id sollicitudin dolor fringilla. Mauris congue elit ut tempus finibus. Ut in aliquam massa. Quisque imperdiet bibendum scelerisque. Proin quis vehicula odio. Aliquam erat volutpat. Ut nec sodales felis. Vivamus mauris nisl, tristique eu urna vel, sagittis bibendum felis. Morbi ornare diam et diam lobortis, non porta orci finibus. In hac habitasse platea dictumst. Aenean quam lacus, blandit vel malesuada id, fringilla ut ex. Maecenas nisi elit, viverra ut tincidunt eget, posuere id arcu. Maecenas vel est non sem hendrerit tristique ut a dui. Quisque ac justo erat. Maecenas faucibus nisl in ullamcorper imperdiet. Quisque nec ligula tempus, hendrerit libero vitae, pharetra nibh. In non ipsum eu mi maximus tincidunt. Curabitur iaculis quam et tellus finibus feugiat at non nibh. Nunc vulputate justo ac purus gravida, vitae scelerisque tortor scelerisque. Nunc finibus magna urna, non sollicitudin felis ullamcorper eu. Phasellus dolor ante, convallis sed ornare quis, ultrices vitae augue. Aliquam porttitor, massa quis dignissim luctus, arcu ante auctor quam, interdum aliquet dolor eros id purus. Suspendisse rhoncus, mi molestie consectetur ultricies, dui eros tempus dolor, vitae faucibus turpis dui vel sapien.");
		testbox3.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer enim urna, cursus non luctus eu, porttitor a velit. Quisque at eros quis erat blandit finibus. Mauris nec est velit. Donec lobortis nibh metus, at sollicitudin risus iaculis sed. Suspendisse elementum dolor venenatis lobortis sagittis. Maecenas lobortis, diam eu vestibulum consequat, erat dolor eleifend erat, condimentum pretium tellus tellus maximus lectus. Phasellus at magna vel libero facilisis consequat sed id ligula. Phasellus pellentesque, nibh at rutrum ultricies, nisi erat eleifend odio, et egestas dolor diam vitae nisl. Sed sagittis volutpat erat, quis interdum ligula condimentum sit amet. Aenean nisi urna, volutpat at orci sed, convallis sodales sapien. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent aliquet porta mi at sollicitudin. Nam quis eros vel ante mattis egestas.Curabitur egestas malesuada est, at venenatis ligula semper ut. Ut nec tincidunt odio, nec tempor nulla. Duis odio massa, tempus eu metus ut, aliquam porttitor nulla. Mauris et rutrum lorem. Mauris ullamcorper tempor accumsan. Cras rhoncus nulla non massa facilisis, nec vestibulum ex hendrerit. Fusce tortor orci, blandit ut dolor ac, commodo mollis turpis. Nam gravida sollicitudin mollis.Etiam rhoncus bibendum metus, eget consectetur massa pulvinar vitae. Nam pretium urna sagittis, luctus quam a, tincidunt erat. Mauris enim lacus, auctor sit amet ultrices at, ultricies ac turpis. Duis sed augue sit amet nisi pharetra rutrum id sed leo. Nunc imperdiet ex nec ante porttitor viverra. Sed eu turpis sapien. In bibendum dolor at dignissim pharetra. Fusce elementum aliquam feugiat. Morbi molestie justo eget ipsum mattis, id sollicitudin dolor fringilla. Mauris congue elit ut tempus finibus. Ut in aliquam massa. Quisque imperdiet bibendum scelerisque. Proin quis vehicula odio. Aliquam erat volutpat. Ut nec sodales felis. Vivamus mauris nisl, tristique eu urna vel, sagittis bibendum felis. Morbi ornare diam et diam lobortis, non porta orci finibus. In hac habitasse platea dictumst. Aenean quam lacus, blandit vel malesuada id, fringilla ut ex. Maecenas nisi elit, viverra ut tincidunt eget, posuere id arcu. Maecenas vel est non sem hendrerit tristique ut a dui. Quisque ac justo erat. Maecenas faucibus nisl in ullamcorper imperdiet. Quisque nec ligula tempus, hendrerit libero vitae, pharetra nibh. In non ipsum eu mi maximus tincidunt. Curabitur iaculis quam et tellus finibus feugiat at non nibh. Nunc vulputate justo ac purus gravida, vitae scelerisque tortor scelerisque. Nunc finibus magna urna, non sollicitudin felis ullamcorper eu. Phasellus dolor ante, convallis sed ornare quis, ultrices vitae augue. Aliquam porttitor, massa quis dignissim luctus, arcu ante auctor quam, interdum aliquet dolor eros id purus. Suspendisse rhoncus, mi molestie consectetur ultricies, dui eros tempus dolor, vitae faucibus turpis dui vel sapien.");
	
		HorizontalPanel instructions = new HorizontalPanel();
		instructions.add(testbox);
		instructions.setWidth("500px");
		instructions.setHeight("500px");

		HorizontalPanel input = new HorizontalPanel();
		input.setWidth("500px");
		input.setHeight("500px");

		VerticalPanel code = new VerticalPanel();
		code.setWidth("500px");
		code.setHeight("250px");
		code.add(testbox2);
		VerticalPanel grade = new VerticalPanel();
		grade.setWidth("500px");
		grade.setHeight("250px");
		code.add(testbox3);

		input.add(code);
		input.add(grade);

		add(instructions, DockPanel.WEST);
		add(input, DockPanel.EAST);
	}
	
	//TODO setInstructions
	private void setInstructions(String instructions){
		return;
	}
	
	//TODO setTests
	private void setTests(ArrayList<String> tests){
		return;
	}
	
	//TODO showResults
	private void showResults(boolean visible){
		return;
	}
	//TODO showNextPagePrompt
	private void showNextPagePrompt(boolean visible){
		return;
	}
	//TODO - getInputtedCode(): String
	private String getInputtedCode(){
		return "getInputtedCode";
	}
	//TODO - getTests(): ArrayList<String>
	private ArrayList<String> getTests(){
		return new ArrayList<String>();
	}
	//TODO - getTestId(): int
	private int getTestId(){
		return 0;
	}
	//TODO -- handleSubmitClick(): void
	private void handleSubmitClick(){
		return; 
	}
	//TODO - handleNextTaskClick(): void
	private void handleNextTaskClick(){
		return;
	}


	@Override
	public void attachHandlers() {
		// STUB
	}
}
