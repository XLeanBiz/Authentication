package co.uniqueid.authentication.client.login.facebook;

import java.util.logging.Level;
import java.util.logging.Logger;

import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.companies.GetFirstCompany;
import co.uniqueid.authentication.client.companies.ListCompanies;
import co.uniqueid.authentication.client.login.LoginService;
import co.uniqueid.authentication.client.login.LoginServiceAsync;
import co.uniqueid.authentication.client.utilities.ConvertJson;
import co.uniqueid.authentication.client.utilities.EncryptText;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class FacebookLoginVerifyer {

	private static Logger logger = Logger.getLogger("UnoIDMe");

	public static void authenticate(final String AppID,
			final String authenticationCode, final String redirect_URL,
			final String newLocation, final boolean initCompanies) {

		FacebookLoginPanel.hpFacebookLogin.clear();

		final LoginServiceAsync loginService = GWT.create(LoginService.class);

		if (!(authenticationCode == null || "".equals(authenticationCode))) {

			loginService.facebookLogin(AppID, authenticationCode, redirect_URL,
					new AsyncCallback<String>() {

						public void onFailure(final Throwable caught) {
							System.out.println(caught);
							logger.log(Level.INFO, "caught=" + caught);
						}

						public void onSuccess(String uniqueIDJsonString) {

							// uniqueIDJsonString = UserTest.get();
							// logger.log(Level.INFO, "uniqueIDJsonString="
							// + uniqueIDJsonString);

							if (uniqueIDJsonString != null) {

								JSONObject obj = (JSONObject) JSONParser
										.parseStrict(uniqueIDJsonString);

								String ID = ConvertJson.getStringValue(obj,
										"ID");

								Cookies.setCookie("UniqueID",
										EncryptText.encrypt(ID));

								UniqueIDGlobalVariables.uniqueID = obj;

								FacebookLoginPanel.setLoggedUser();

								if (newLocation != null) {

									Location.assign(newLocation);
								}

								if (initCompanies) {

									ListCompanies.list();
									GetFirstCompany.get(null, redirect_URL);
								}
							}
						}
					});

		}
	}
}
