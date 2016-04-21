package codingcareers.webapp.client.PageComponents;

import java.util.ArrayList;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.core.client.Callback;
import com.google.gwt.dom.client.LinkElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.Window;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import codingcareers.webapp.client.ace.*;
import codingcareers.webapp.client.Controller;

public class TaskPageBody extends PageBody {

	private final TextArea instructionBox;
	private final AceEditor editor;
	private final TextArea outputBox;
	private final Button codeSubmit;
	private final Button codeReset;

	private String tests;

	private static String py_test_prelude =
		"class CodingCareers__():\n" +
		"    def __init__(self):\n" +
		"        self.correct = 0\n" +
		"        self.total = 0\n" +
		"    def test_pass(self):\n" +
		"        self.correct += 1\n" +
		"        self.total += 1\n" +
		"    def test_fail(self):\n" +
		"        self.total += 1\n" +
		"    def expect(self, b):\n" +
		"        if b:\n" +
		"            self.test_pass()\n" +
		"        else:\n" +
		"            self.test_fail()\n" +
		"    def report(self):\n" +
		"        print('{}{}/{}'.format(PY_TEST_PRINT_PREFIX, self.correct, self.total))\n\n";


	// TODO randomly generate this on first use
	private static final String PY_TEST_PRINT_PREFIX = "nf328ijask";

	// TODO Move all interpreter stuff to the Controller as in class diagram

	// TODO change public methods for python interpreter to private if possible

	// TODO decide whether to run python tests or regex on output (maybe use
	// strategy pattern if implemented)
	public void outf(String text) {
		String appendOutput = "";
		if(text.length() >= PY_TEST_PRINT_PREFIX.length()) {
			// Assume any use of PY_TEST_PRINT_PREFIX will contain additional text. If this
			// is not the case, the tests have provided no information.
			String result = text.substring(PY_TEST_PRINT_PREFIX.length(), text.length());
			String[] testStats = result.split("/", 2);
			int testsPassed = Integer.parseInt(testStats[0]);
			int testsTotal = Integer.parseInt(testStats[1]);
			Controller.getInstance().logTaskProgress(testsPassed, testsTotal);
			appendOutput = "==============================\n" + result;
			// TODO parse result and send to server
		} else {
			appendOutput = text;
		}
		outputBox.setText(outputBox.getText() + appendOutput);
	}

	private native void exportOutf() /*-{
		var that = this;
		$wnd.outf = $entry(function(text) {
			that.@codingcareers.webapp.client.PageComponents.TaskPageBody::outf(Ljava/lang/String;)(text);
		});
	}-*/;

	public void clearOutput() {
		//outputBox.setText("");
	}

	private native void exportClearOutput() /*-{
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

	private native void runCode(String prog) /*-{
		$wnd.clearOutput();
		Sk.pre = "output";
		Sk.configure({output:$wnd.outf, read:$wnd.builtinRead});
		var myPromise = Sk.misceval.asyncToPromise(function() {
			return Sk.importMainWithBody("<stdin>", false, prog, true);
		});
		myPromise.then(function(mod) {
			console.log('code run successfully');
		}, function(err) {
			console.log(err);
		});
	}-*/;

	private void runWithPyTests(String prog, String tests) {
		String code = prog +
			"\n\nPY_TEST_PRINT_PREFIX = '" + PY_TEST_PRINT_PREFIX + "'\n" +
			py_test_prelude + tests;
		runCode(code);
	}

	private void runWithCodeBox(String tests) {
		runWithPyTests(editor.getText(), tests);
	}

	private void run() {
		runWithCodeBox(tests);
	}

	private static void loadCSS(String url) {
		LinkElement link = Document.get().createLinkElement();
		link.setRel("stylesheet");
		link.setHref(url);
		appendHead(link);
	}

	private static native void appendHead(JavaScriptObject elem) /*-{
		$doc.getElementsByTagName("head")[0].appendChild(elem);
	}-*/;

	public TaskPageBody(String instructions, String tests) {
		this.tests = tests;

		instructionBox = new TextArea();
		editor = new AceEditor();
		outputBox = new TextArea();
		codeSubmit = new Button("Submit");
		codeReset = new Button("Reset");

		instructionBox.setCharacterWidth(30);
		editor.setWidth("500px");
		outputBox.setCharacterWidth(30);

		instructionBox.setHeight("400px");
		editor.setHeight("410px");
		outputBox.setHeight("400px");

		instructionBox.setText(instructions);

		codeSubmit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				run();
			}
		});

		codeReset.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				editor.setText("");
			}
		});

		VerticalPanel instructionPanel = new VerticalPanel();
		instructionPanel.add(instructionBox);

		VerticalPanel code = new VerticalPanel();
		code.add(editor);
		code.add(codeReset);

		VerticalPanel output = new VerticalPanel();
		output.add(outputBox);
		output.add(codeSubmit);

		add(instructionPanel, DockPanel.WEST);
		add(code, DockPanel.CENTER);
		add(output, DockPanel.EAST);

		editor.startEditor();
		editor.setMode(AceEditorMode.PYTHON);
		editor.setAutocompleteEnabled(true);
		editor.setText(
				"def f(n):\n" +
				" if n < 2:\n" +
				"  return n\n" +
				" else:\n" +
				"  return f(n - 1) + f(n - 2)\n");

		exportOutf();
		exportClearOutput();
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
