package codingcareers.webapp.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RPCAsync {
	void invokeServer(String cmd, AsyncCallback<String> callback)
		throws IllegalArgumentException;
}
