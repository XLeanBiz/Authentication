package co.uniqueid.authentication.client.login.facebook;

import java.util.logging.Level;
import java.util.logging.Logger;

import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.login.LoginService;
import co.uniqueid.authentication.client.login.LoginServiceAsync;
import co.uniqueid.authentication.client.utilities.EncryptText;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class FacebookLoginVerifyer {

	private static Logger logger = Logger.getLogger("UnoIDMe");

	public static void authenticate(final String authenticationCode) {

		final LoginServiceAsync loginService = GWT.create(LoginService.class);

		if (!(authenticationCode == null || "".equals(authenticationCode))) {

			loginService.facebookLogin(authenticationCode,
					new AsyncCallback<String>() {

						public void onFailure(final Throwable caught) {
							System.out.println(caught);
							logger.log(Level.INFO, "caught=" + caught);
						}

						public void onSuccess(final String unoUserJsonString) {

							Cookies.setCookie("UnoUser",
									EncryptText.encrypt(unoUserJsonString));

							JSONObject obj = (JSONObject) JSONParser
									.parseStrict(unoUserJsonString);

							UniqueIDGlobalVariables.uniqueID = obj;

							FacebookLoginPanel.setLoggedUser();
						}
					});

		}
	}
}
