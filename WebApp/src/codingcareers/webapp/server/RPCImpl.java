package codingcareers.webapp.server;

import codingcareers.webapp.client.Constants;
import codingcareers.webapp.client.RPC;
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

    private String lookupUser(String credentials) {
        // Parse user and password
        String[] args = credentials.split(" ");
        String cmd = "SELECT user_id"
                + "FROM User"
                + "WHERE username = " + args[USERNAME_INDEX] + " AND password = " + args[PASSWORD_INDEX];
        ResultSet rs = callMySQL(cmd);
        JSONObject obj = new JSONObject();
        try {
            if(rs.first()) {
                obj.put("user_id", rs.getString(1));
                obj.put("username", rs.getString(2));
                return obj.toString();
            }
        } catch(SQLException e) {
            return "";
        }
        return "";

    }

    public String invokeServer(String cmd) {
        String[] args = cmd.split("-", 2);
        String command;
        String params;

        try {
            command = args[0];
            params = args[1];
        } catch (IndexOutOfBoundsException e) {
            return "";
        }

        switch (command) {
            case Constants.LOOKUP_TASK_INFO:
                return lookupTaskInfo(params);
            case Constants.LOOKUP_USER:
                return lookupUser(params);
            default:
                return "";
        }
    }
}
