package codingcareers.webapp.client.PageComponents;

import java.util.ArrayList;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.Window;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class TaskPageBody extends PageBody {

	private final TextArea instructionBox;
	private final TextArea codeBox;
	private final TextArea outputBox;
	private final Button codeSubmit;

	private static boolean exportedFunctions = false;
	private static final String PY_TEST_PREFIX = "nf328ijask";

	// TODO Move all interpreter stuff to the Controller as in class diagram

	// TODO change public methods for python interpreter to private if possible

	// TODO decide whether to run python tests or regex on output (maybe use
	// strategy pattern if implemented)
	public void outf(String text) {
		String appendOutput = "";
		if(text.length() >= PY_TEST_PREFIX.length()) {
			// Assume any use of PY_TEST_PREFIX will contain additional text. If this
			// is not the case, the tests have provided no information.
			String result = text.substring(PY_TEST_PREFIX.length(), text.length());
			appendOutput = "==============================\n" + result;
			// TODO parse result and send to server
		} else {
			appendOutput = text;
		}
		outputBox.setText(outputBox.getText() + appendOutput);
	}

	public native void exportOutf() /*-{
		var that = this;
		$wnd.outf = $entry(function(text) {
			that.@codingcareers.webapp.client.PageComponents.TaskPageBody::outf(Ljava/lang/String;)(text);
		});
	}-*/;

	public void clearOutput() {
		outputBox.setText("");
	}

	public native void exportClearOutput() /*-{
		var that = this;
		$wnd.clearOutput = $entry(function() {
			that.@codingcareers.webapp.client.PageComponents.TaskPageBody::clearOutput()();
		});
	 }-*/;

	public native JavaScriptObject builtinRead(String file) /*-{
		if(Sk.builtinFiles === undefined || Sk.builtinFiles["files"][x] === undefined)
		throw "File not found: '" + x + "'";
		return Sk.builtinFiles["files"][x];
	}-*/;

	public native void runCode(String prog) /*-{
		$wnd.clearOutput();
		Sk.pre = "output";
		Sk.configure({output:$wnd.outf, read:$wnd.builtinRead});
		var myPromise = Sk.misceval.asyncToPromise(function() {
			return Sk.importMainWithBody("<stdin>", false, prog, true);
		});
		myPromise.then(function(mod) {
			console.log('success');
			//alert('success');
		}, function(err) {
			console.log(err.toString());
		});
	}-*/;

	public void runWithPyTests(String prog, String tests) {
		String code = prog + "\nPY_TEST_PREFIX = '" + PY_TEST_PREFIX + "'\n" + tests;
		runCode(code);
	}

	public TaskPageBody() {
		if(!exportedFunctions) {
			exportOutf();
			exportClearOutput();
			exportedFunctions = true;
		}

		instructionBox = new TextArea();
		codeBox = new TextArea();
		outputBox = new TextArea();
		codeSubmit = new Button("Submit");

		instructionBox.setCharacterWidth(30);
		codeBox.setCharacterWidth(30);
		outputBox.setCharacterWidth(30);

		instructionBox.setHeight("400px");
		codeBox.setHeight("400px");
		outputBox.setHeight("400px");

		codeSubmit.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
			// TODO get tests for this level from server
			String tests =
			"if f(5) == 5 and f(10) == 55 and f(0) == 0:\n" +
			" print(PY_TEST_PREFIX + '3/3 tests passed!')\n";
			runWithPyTests(codeBox.getText(), tests);
		}
		});

		instructionBox.setText("Write a function called 'f' that takes one integer parameter n and returns n factorial");
		codeBox.setText(
				"def f(n):\n" +
				" if n < 2:\n" +
				"  return n\n" +
				" else:\n" +
				"  return f(n - 1) + f(n - 2)\n");
	
		VerticalPanel instructions = new VerticalPanel();
		instructions.add(instructionBox);

		VerticalPanel code = new VerticalPanel();
		code.add(codeBox);

		VerticalPanel output = new VerticalPanel();
		output.add(outputBox);
		output.add(codeSubmit);

		add(instructions, DockPanel.WEST);
		add(code, DockPanel.CENTER);
		add(output, DockPanel.EAST);
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
