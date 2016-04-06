package codingcareers.webapp.client.PageComponents;

/**
 * Created by ian on 4/5/16.
 */
public class InvalidPageException extends Exception {
    public InvalidPageException() {}

    public InvalidPageException(String message) {
        super(message);
    }
}
