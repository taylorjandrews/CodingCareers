package codingcareers.webapp.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("rpc")
public interface RPC extends RemoteService {
	String invokeServer(String cmd) throws Exception;
}
