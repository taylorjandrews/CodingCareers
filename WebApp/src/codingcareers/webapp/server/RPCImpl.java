package codingcareers.webapp.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import codingcareers.webapp.client.RPC;

public class RPCImpl extends RemoteServiceServlet implements RPC {
	public String invokeServer(String cmd) {
		return
			"if f(5) == 5 and f(10) == 55 and f(0) == 0:\n" +
			" print(PY_TEST_PREFIX + '3/3 tests passed!')\n" +
			"else:\n" +
			" print(PY_TEST_PREFIX + '< 3/3 tests passed')\n";
	}
}
