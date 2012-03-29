package co.uniqueid.authentication.client.login;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("authentication")
public interface LoginService extends RemoteService {
	
	public String githubLogin(String authenticationCode);
	
	public String facebookLogin(final String AppID, final String authCode,
			final String redirect_URL);
}
