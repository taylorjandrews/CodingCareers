package codingcareers.webapp.client;

/**
 * Created by ian on 4/16/16.
 */
public class User {
    private final String user_id;
    private final String username;
    private String session_id;
    private boolean loggedIn;

    public final static String INVALID_VALUE = "not_valid";

    public User(String user_id, String username, String session_id) {
        this.user_id = user_id;
        this.username = username;
        this.session_id = session_id;
        loggedIn = true;
    }

    public String getUser_id() {
        if (loggedIn) {
            return user_id;
        } else {
            return INVALID_VALUE;
        }
    }

    public String getUsername() {
        if (loggedIn) {
            return username;
        } else {
            return INVALID_VALUE;
        }
    }

    public String getSession_id() {
        if (loggedIn) {
            return session_id;
        } else {
            return INVALID_VALUE;
        }
    }

    public void logout() {
        loggedIn = false;
        session_id = null;
    }
}
