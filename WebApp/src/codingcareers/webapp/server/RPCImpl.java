package codingcareers.webapp.server;

import codingcareers.webapp.client.Constants;
import codingcareers.webapp.client.RPC;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.lang.Exception;
import java.security.MessageDigest;
import java.sql.*;
import java.util.UUID;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
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

    private void update(String cmd) throws SQLException {
        Statement s = connectDB();
        s.executeUpdate(cmd);
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
        String[] args = credentials.split(" ");
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        args[PASSWORD_INDEX] = new HexBinaryAdapter()
            .marshal(md.digest(args[PASSWORD_INDEX].getBytes()));
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
                return obj.toString();
            }
        } catch (NullPointerException | SQLException e) {
            throw new Exception("Error with SQL statement.");
        }
        throw new Exception("Invalid user credentials.");
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
            default:
                throw new Exception("Command not found");
        }
    }
}
