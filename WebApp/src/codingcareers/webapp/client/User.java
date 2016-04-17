package codingcareers.webapp.client;

/**
 * Created by ian on 4/16/16.
 */
public class User {
    private final String user_id;
    private final String username;
    private boolean loggedIn;

    public final static String INVALID_VALUE = "not_valid";

    public User(String user_id, String username) {
        this.user_id = user_id;
        this.username = username;
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

    public void logout() {
        loggedIn = false;
    }
}
