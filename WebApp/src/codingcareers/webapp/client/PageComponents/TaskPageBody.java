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
	private String pyStdout;
	private String pass1Results;

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
		"    def report(self, cmd):\n" +
		"        print('{} {} {}/{}'.format(PY_TEST_PRINT_PREFIX, cmd, self.correct, self.total))\n\n";


	// TODO randomly generate this on first use
	private static final String PY_TEST_PRINT_PREFIX = "nf328ijask";

	// TODO Move all interpreter stuff to the Controller as in class diagram

	// TODO change public methods for python interpreter to private if possible

	// This is a huge mess because I don't know of an easy way to go from
	// javascript -> running python instance. I can't believe this actually
	// works. What it does:
	// Whenever we print something, log it to pyStdout
	// Wait until we see a PY_TEST_PRINT_PREFIX string with "pass1" argument 1
	// save argument 2 to pass1Results. This is a "n/m" string detailing
	//   passing tests for the first pass
	// Start another instance of the Python interpreter running just the test
	//   code except with CCStdout set to what we logged during the first pass
	// Wait until we see a PY_TEST_PRINT_PREFIX string with "pass2" argument 1
	// get argument 2, another "n/m" string. Parse the results and add pass 2
	//   test stats to pass 1 test stats to get overall test stats.
	//
	// Effectively, we run our test code twice. The first time we also run
	// user-inputted code. The second time we only run the test code. In the
	// first run, CCStdout == None. In the second run, CCStdout is set to the
	// stdout we logged. Accordingly, the python tests in the database should
	// check if CCStdout == None to determine which time it's being run. The
	// first time, check the return values of function calls and whatnot. The
	// second time, check stdout is what we expected it to be. After the first
	// pass, call cc.report('pass1). After the second pass, call
	// cc.report('pass2').
	public void outf(String text) {
		String appendOutput = "";
		if(text.length() >= PY_TEST_PRINT_PREFIX.length() && text.substring(0,
					PY_TEST_PRINT_PREFIX.length()) == PY_TEST_PRINT_PREFIX) {
			// Assume any use of PY_TEST_PRINT_PREFIX is formatted like:
			// PY_TEST_PRINT_PREFIX pass1|pass2 n/m
			String[] args = text.split(" ", 3);
			if(args[1].equals("pass1")) {
				pass1Results = args[2];
				runWithPyTests("CCStdout = '''" + pyStdout + "'''\n", tests);
			} else if(args[1].equals("pass2")) {
				String pass2Results = args[2];
				String[] pass1Split = pass1Results.split("/", 2);
				String[] pass2Split = pass2Results.split("/", 2);
				int testsPassed = Integer.parseInt(pass1Split[0]) + Integer.parseInt(pass2Split[0]);
				int testsTotal = Integer.parseInt(pass1Split[1]) + Integer.parseInt(pass2Split[1]);
				Controller.getInstance().logTaskProgress(testsPassed, testsTotal);
				appendOutput = "==============================\n" +
					String.valueOf(testsPassed) + "/" + String.valueOf(testsTotal) + "\n";
			}
		} else {
			pyStdout += text;
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
			$wnd.outf("==============================\nEncountered error\n");
		});
	}-*/;

	private void runWithPyTests(String prog, String tests) {
		String code = prog +
			"\n\nPY_TEST_PRINT_PREFIX = '" + PY_TEST_PRINT_PREFIX + "'\n" +
			py_test_prelude + tests;
		runCode(code);
	}

	private void runWithCodeBox(String tests) {
		pyStdout = "";
		runWithPyTests(editor.getText(), "CCStdout = None\n" + tests);
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
