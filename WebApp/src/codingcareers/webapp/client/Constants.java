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
    
    public static String ABOUT_PAGE_INFO = "Welcome to Coding Careers, the interactive coding tutorial through the world of software engineering. Before we begin let’s explain what coding is. I sure at this point you’ve heard or read somewhere that everyone needs to learn coding, right? Well, people say that for a reason! Whether you’re looking for a job, wanting to create your own game, or starting a new hobby, you can benefit from learning coding. Coding is what makes it possible to create computer software, apps on your cell phone, the games you play on your Xbox, the tools your doctors use to check if you’re sick, and so much more. Pretty cool right? But why is it so important? Learning coding empowers you to do many things you wouldn’t otherwise be able to do. These things include: hand-crafting your own websites, becoming a career coder, or even starting a technology company. Most importantly, you’ll understand how the world is changing around us because of technology! The programming language you will be learning in this tutorial is called Python. Many software engineers consider python to be a great introductory language because of it is simple yet power.";
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
	public static final String LOOKUP_COMPLETED_TASKS = "model lookupucompletedtasks";
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
