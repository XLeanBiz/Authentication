package co.uniqueid.authentication.client.login.facebook;

import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.companies.GetFirstCompany;
import co.uniqueid.authentication.client.companies.ListCompanies;
import co.uniqueid.authentication.client.uniqueid.UniqueIDService;
import co.uniqueid.authentication.client.uniqueid.UniqueIDServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class InitializeFacebookLogin {

	public InitializeFacebookLogin(final String uniqueID, final String appID,
			final String redirectURL, final String companyID) {

		if (uniqueID == null) {

			FacebookLoginPanel.setPanel(appID, redirectURL);

		} else {

			final UniqueIDServiceAsync unoIDService = GWT
					.create(UniqueIDService.class);

			unoIDService.getUniqueID(uniqueID, new AsyncCallback<String>() {

				public void onFailure(final Throwable caught) {
					System.out.println(caught);
				}

				public void onSuccess(final String jsonResults) {

					if (jsonResults != null) {
						
						JSONObject obj = (JSONObject) JSONParser
								.parseStrict(jsonResults);

						UniqueIDGlobalVariables.uniqueID = obj;

						FacebookLoginPanel.setPanel(appID, redirectURL);

						if (UniqueIDGlobalVariables.uniqueID != null) {

							ListCompanies.list();
						}

						GetFirstCompany.get(companyID);
					}
				}
			});
		}
	}
}
