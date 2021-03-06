package co.uniqueid.authentication.client;

import co.uniqueid.authentication.client.login.LoginButtons;
import co.uniqueid.authentication.client.login.facebook.FacebookAppsProperties;
import co.uniqueid.authentication.client.login.facebook.FacebookLoginVerifyer;
import co.uniqueid.authentication.client.login.github.GithubLoginVerifyer;
import co.uniqueid.authentication.client.uniqueid.GetUniqueIDTest;
import co.uniqueid.authentication.client.utilities.EncryptText;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 * 
 * @Architecture
 */
public class GWTEntryPoint implements EntryPoint {

	public static VerticalPanel vpMain = new VerticalPanel();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		// Cookies.setCookie("UnoUser",
		// EncryptText.encrypt(UnoUserTest.unoUserJsonString()));

		RootPanel.get().add(vpMain);

		String unoUser = EncryptText.decrypt(Cookies.getCookie("UnoUser"));

		if (unoUser == null || unoUser.equals("null")) {

			String authenticationCode = Location.getParameter("code");

			final String error = Location.getParameter("error_reason");

			if ((null != error && error.equals("user_denied"))
					|| (authenticationCode == null || ""
							.equals(authenticationCode))) {

				vpMain.add(new LoginButtons());

			} else {

				final String loginApp = Location.getParameter("login");

				if ("github".equals(loginApp)) {

					GithubLoginVerifyer.authenticate(authenticationCode);

				} else {

					FacebookLoginVerifyer.authenticate(
							FacebookAppsProperties.testFacebookID,
							authenticationCode,
							FacebookAppsProperties.test_REDIRECT_URL, null,
							false);
				}
			}

		} else {

			GetUniqueIDTest.get(unoUser);
		}
	}
}
