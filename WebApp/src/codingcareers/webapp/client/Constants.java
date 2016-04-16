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
    
    public static String ABOUT_PAGE_INFO="Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui.";

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

	// Model/Database constants
	public static final String LOOKUP_USER = "model lookupuser";
	public static final String CREATE_USER = "model createuser";
	public static final String LOGIN_USER = "model loginuser";
	public static final String UPDATE_PROGRESS = "model updateprogress";
	public static final String LOOKUP_TASK_INFO = "model lookuptaskinfo";
	public static final String SELECT_CHARACTER = "model selectcharacter";
}
