package co.uniqueid.authentication.client.companies;

import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.uniqueid.UniqueIDService;
import co.uniqueid.authentication.client.uniqueid.UniqueIDServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetCompany {

	public static void get(final String uniqueID, final String redirect_URL,
			final boolean toRedirect) {

		final UniqueIDServiceAsync uniqueIDService = GWT
				.create(UniqueIDService.class);

		uniqueIDService.getUniqueID(uniqueID, new AsyncCallback<String>() {

			public void onFailure(final Throwable caught) {
				System.out.println(caught);
			}

			public void onSuccess(final String jsonResults) {

				if (jsonResults != null) {

					JSONObject obj = (JSONObject) JSONParser
							.parseStrict(jsonResults);

					if (obj != null) {

						UniqueIDGlobalVariables.companyUniqueID = obj;

						new CompanyIcon(obj, redirect_URL);
					}
				}

				if (toRedirect) {

					Location.assign(redirect_URL);
				}
			}
		});
	}

}
