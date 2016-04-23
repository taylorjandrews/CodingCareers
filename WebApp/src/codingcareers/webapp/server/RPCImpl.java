package codingcareers.webapp.server;

import codingcareers.webapp.client.Constants;
import codingcareers.webapp.client.RPC;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.lang.Exception;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import org.apache.http.auth.InvalidCredentialsException;
import org.json.simple.JSONObject;

public class RPCImpl extends RemoteServiceServlet implements RPC {

    private final int USERNAME_INDEX = 0;
    private final int PASSWORD_INDEX = 1;

    private Statement connectDB() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/CodingCareers", "root", "");
        return conn.createStatement();
    }

    private ResultSet query(String cmd) throws SQLException {
        Statement s = connectDB();
        return s.executeQuery(cmd);
    }

    private int update(String cmd) throws SQLException {
        Statement s = connectDB();
        return s.executeUpdate(cmd);
    }

    private String lookupTaskInfo(String param) {
        String cmd = "SELECT instructions, code_template, test_code FROM Task" +
            " WHERE task_id = " + param + ";";
        JSONObject obj = new JSONObject();
        try {
            ResultSet rs = query(cmd);
            if(rs.first()) {
                obj.put("instructions", rs.getString(1));
                obj.put("code_template", rs.getString(2));
                obj.put("test_code", rs.getString(3));
                return obj.toString();
            }
        } catch(SQLException e) {
            return "";
        }
        return "";
    }

    private void updateUserSessionID(String sessionID, String userName)
            throws SQLException {
        String cmd = "UPDATE User SET session_id = \"" + sessionID +
            "\" WHERE username = \"" + userName + "\";";
        update(cmd);
    }

    private void logoutUser(String userName) throws SQLException {
        String cmd = "UPDATE User SET session_id = NULL WHERE username = \"" +
            userName + "\";";
        update(cmd);
    }

    private String lookupUser(String credentials) throws Exception {
        // Parse user and password
        String[] args = parseCredentials(credentials);
        String cmd;
        try {
            cmd = "SELECT user_id"
                    + " FROM User"
                    + " WHERE username = \"" + args[USERNAME_INDEX] + "\" AND password = \"" + args[PASSWORD_INDEX] + "\";";
        } catch(IndexOutOfBoundsException e) {
            throw new Exception("No password given.");
        }
        JSONObject obj = new JSONObject();
        try {
            ResultSet rs = query(cmd);
            if(rs.first()) {
                String userID = Integer.toString(rs.getInt(1));
                obj.put("user_id", userID);
                obj.put("username", args[USERNAME_INDEX]);
                String sessionID = UUID.randomUUID().toString();
                updateUserSessionID(sessionID, args[USERNAME_INDEX]);
                obj.put("session_id", sessionID);
                obj.put("task_list", lookupUserProgress(userID));
                return obj.toString();
            }
        } catch (NullPointerException | SQLException e) {
            throw new Exception("Error with SQL statement.");
        }
        throw new InvalidCredentialsException("Invalid user credentials.");
        // Look up the tasks the user has completed
    }

    private String createUser(String credentials) throws Exception {
        try {
            lookupUser(credentials);
            throw new Exception("Non-unique credentials.");
        } catch (InvalidCredentialsException e) {
            String[] args = parseCredentials(credentials);
            String cmd = "INSERT INTO User (username, password)"
                    + "VALUES (\"" + args[USERNAME_INDEX] + "\", \"" + args[PASSWORD_INDEX] + "\");";
            update(cmd);
            return lookupUser(credentials);
        }
    }

    private String[] parseCredentials(String credentials) {
        String[] args = credentials.split(" ");
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        args[PASSWORD_INDEX] = new HexBinaryAdapter()
                .marshal(md.digest(args[PASSWORD_INDEX].getBytes()));
        return args;
    }

    // TODO only update progress if better than previous progress
    private void insertTaskProgress(String taskID, String userID,
            String testsPassed, String testsTotal) throws SQLException {
        String cmd = "INSERT INTO TaskProgress (user_id, task_id, " +
            " tests_passed, tests_total) values (" + userID + ", " + taskID +
            ", " + testsPassed + ", " + testsTotal + ") ON DUPLICATE KEY " +
            "UPDATE tests_passed = " + testsPassed + ", tests_total = " +
            testsTotal + ";";
        update(cmd);
    }

    private String getUserIDFromSessionID(String sessionID) throws SQLException {
        String cmd = "SELECT user_id FROM User WHERE session_id = \"" +
            sessionID + "\";";
        ResultSet rs = query(cmd);
        if(rs.first()) {
            return rs.getString(1);
        }
        return null;
    }

    private String updateProgress(String params) {
        String[] args = params.split(" ", 4);
        String taskID = args[0];
        String sessionID = args[1];
        String testsPassed = args[2];
        String testsTotal = args[3];
        // TODO get userID from sessionID
        try {
            String userID = getUserIDFromSessionID(sessionID);
            if(userID == null)
                return "Failure";

            insertTaskProgress(taskID, userID, testsPassed, testsTotal);

            return "Success";
        } catch (SQLException e) {
            return "Failure";
        }
    }

    private String lookupUserProgress(String userId) throws Exception {
        String cmd = "SELECT task_id FROM TaskProgress WHERE user_id = " + userId + " AND tests_passed = tests_total;";
        String results = "";
        try {
            ResultSet rs = query(cmd);
            if (rs.first()) {
                do {
                    results += Integer.toString(rs.getInt(1)) + ", ";
                } while (rs.next());
            }

        } catch (NullPointerException | SQLException e) {
            throw new Exception("Error with SQL statement." + cmd + "   " + userId);
        } catch (Exception e) {
            throw new Exception("The exception was here!!!");
        }
        return results;
    }

    public String invokeServer(String cmd) throws Exception {
        String[] args = cmd.split("-", 2);
        String command;
        String params;

        try {
            command = args[0];
            params = args[1];
        } catch (IndexOutOfBoundsException e) {
            throw new Exception("Command and params parsed incorrectly.");
        }

        switch (command) {
            case Constants.LOOKUP_TASK_INFO:
                return lookupTaskInfo(params);
            case Constants.LOGIN_USER:
                return lookupUser(params);
            case Constants.LOGOUT_USER:
                logoutUser(params);
                return "";
            case Constants.CREATE_USER:
                return createUser(params);
            case Constants.UPDATE_PROGRESS:
                return updateProgress(params);
            default:
                throw new Exception("Command not found");
        }
    }
}
