package codingcareers.webapp.client;

public final class Constants {
	private Constants() {
		System.out.println("Constants constructor should not have been called!");
	}
	
	public static final String TITLE = "Coding Careers";

	// HTML ids
	public static String HEADER_ID = "header";
	public static String BODY_ID = "body";
	public static String FOOTER_ID = "footer";
    public static String CONTENT_ID = "content";
    
    public static String ABOUT_PAGE_INFO = "Coding Careers is a website that teaches Python coding. Python is a fairly common programming language that is very friendly to beginners while maintaining a high degree of power. Everything from basic scripts to high powered scientific computing can use Python. Pretty cool right?                    Through our interactive tutorials you will develop your coding skills until you're a Python expert. Coding Careers doesn't just focus on generic problems; we also want to teach you about all the awesome careers a computer scientist can have! It isn't all just working for Google or Facebook. Curious about NASA? You can program a rocket launch! What about working for the FBI? You could do computer forensics. Passionate about healthcare? Hospitals need computer scientists too! Coding Careers is the best way to explore everything computer science has to offer. Don't believe us? Click Try it Now!";
	/*
	public String LOOK_UP_HINT;
	public String LAST_ATTEMPT;
	public String LAST_SCORE;
	public String GET_PROGRESS;
	
	//LESSON CONSTANT
	public String START_LESSON;
	public String HOVER_LESSON;
	public String VIEW_LESSONS;
	*/
	
	//PAGE CONSTANT
	public static final String ABOUT_PAGE = "about";
	public static final String CHARACTER_CREATION_PAGE = "character creation";
	public static final String LANDING_PAGE = "landing";
	public static final String LOGIN_PAGE = "login";
	public static final String PROGRESS_PAGE = "progress";
	public static final String TASK_PAGE = "task";
	public static final String TASK_SELECTION_PAGE = "task selection";
	public static final String PROFILE_PAGE = "profile";
	public static final String PROFILE_CREATION = "profile creation";

	// Model/Database constants
	public static final String LOOKUP_USER = "model lookupuser";
	public static final String CREATE_USER = "model createuser";
	public static final String LOGIN_USER = "model loginuser";
	public static final String LOGOUT_USER = "model logoutuser";
	public static final String UPDATE_PROGRESS = "model updateprogress";
	public static final String LOOKUP_TASK_INFO = "model lookuptaskinfo";
	public static final String SELECT_CHARACTER = "model selectcharacter";

	// Task info
	public static final String[] TASK_SUBJECTS = {"Introduction", "NASA", "The FBI", "iOS-Developer"};
	public static final int TOTAL_LESSONS_IN_SUBJECT = 5;
}
