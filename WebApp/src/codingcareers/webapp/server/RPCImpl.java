package codingcareers.webapp.server;

import codingcareers.webapp.client.Constants;
import codingcareers.webapp.client.RPC;
import java.lang.Exception;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.sql.*;
import org.json.simple.JSONObject;

public class RPCImpl extends RemoteServiceServlet implements RPC {

    private final int USERNAME_INDEX = 0;
    private final int PASSWORD_INDEX = 1;

    private ResultSet callMySQL(String cmd) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/CodingCareers", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(cmd);
            return rs;
        } catch(SQLException e) {
            return null;
        }
    }

    private String lookupTaskInfo(String param) {
        String cmd = "SELECT instructions, code_template, test_code FROM Task" +
            " where task_id = " + param + ";";
        ResultSet rs = callMySQL(cmd);
        JSONObject obj = new JSONObject();
        try {
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

    private String lookupUser(String credentials) throws Exception {
        // Parse user and password
        String[] args = credentials.split(" ");
        String cmd;
        try {
            cmd = "SELECT user_id"
                    + " FROM User"
                    + " WHERE username = \"" + args[USERNAME_INDEX] + "\" AND password = \"" + args[PASSWORD_INDEX] + "\";";
        } catch(IndexOutOfBoundsException e) {
            throw new Exception("No password given.");
        }
        ResultSet rs = callMySQL(cmd);
        JSONObject obj = new JSONObject();
        try {
            if(rs.first()) {
//                obj.put("user_id", Integer.toString(rs.getInt(0)));
//                obj.put("username", args[USERNAME_INDEX]);
//                return obj.toString();
                obj.put("user_id", "Dummy ID");
                obj.put("username", args[USERNAME_INDEX]);
                return obj.toString();
            }
        } catch (NullPointerException e) {
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
            default:
                throw new Exception("Command not found");
        }
    }
}
