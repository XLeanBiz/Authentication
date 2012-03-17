package co.uniqueid.authentication.client.login.github;

import co.uniqueid.authentication.client.login.LoginService;
import co.uniqueid.authentication.client.login.LoginServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GithubLoginVerifyer {

	public static void authenticate(final String authenticationCode) {

		final LoginServiceAsync loginService = GWT.create(LoginService.class);

		if (!(authenticationCode == null || "".equals(authenticationCode))) {

			loginService.githubLogin(authenticationCode,
					new AsyncCallback<String>() {

						public void onFailure(final Throwable caught) {
							System.out.println(caught);
						}

						public void onSuccess(final String jsonResults) {

							SetLoggedIn.authenticated(jsonResults);
						}
					});

		}
	}
}
