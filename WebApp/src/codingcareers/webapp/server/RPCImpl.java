package codingcareers.webapp.server;

import codingcareers.webapp.client.Constants;
import codingcareers.webapp.client.RPC;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.sql.*;
import org.json.simple.JSONObject;

public class RPCImpl extends RemoteServiceServlet implements RPC {

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

    private boolean matchesPrefix(String cmd, String prefix) {
        return cmd.length() >= prefix.length() &&
            cmd.substring(0, prefix.length()).equals(prefix);
    }

    private String getParam(String cmd, String prefix) {
        if(matchesPrefix(cmd, prefix)) {
            return cmd.substring(prefix.length(), cmd.length());
        }
        return null;
    }

    public String invokeServer(String cmd) {
        String param = getParam(cmd, Constants.LOOKUP_TASK_INFO);
        if(param != null) {
            return lookupTaskInfo(param);
        }
        return "";
    }
}
