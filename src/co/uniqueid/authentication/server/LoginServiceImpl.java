package co.uniqueid.authentication.server;

import co.uniqueid.authentication.client.login.LoginService;
import co.uniqueid.authentication.server.facebook.FacebookLogin;
import co.uniqueid.authentication.server.github.GithubLogin;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class LoginServiceImpl extends RemoteServiceServlet implements
		LoginService {

	private static final long serialVersionUID = -8355612980477933670L;

	public String facebookLogin(final String AppID, final String authCode,
			final String redirect_URL) {

		String SECRET_Test_facebook = "5a2a037588b453a3df4058c836850da1"; // Testing
		String SECRET_LiveSource_facebook = "110a3c23f4c80ac47ddcc5c9fd9fb032";
		String SECRET_XLeanBiz_facebook = "d869623627c4eada8c1882539fe983e2";
		String SECRET_UniqueID_facebook = "e1a32038d474da96b354f06793e6f268";
		String SECRET_CustDevFramework_facebook = "21f0d098071af42da2896512af8b2075";
		

		return FacebookLogin.login(AppID, SECRET_CustDevFramework_facebook, authCode,
				redirect_URL);
	}

	public String githubLogin(final String authenticationCode) {

		return GithubLogin.githubLogin(authenticationCode).toString();
	}

}
