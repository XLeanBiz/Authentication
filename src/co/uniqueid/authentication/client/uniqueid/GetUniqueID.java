package co.uniqueid.authentication.client.uniqueid;

import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetUniqueID {

	public static void get(final String unoUser) {

		JSONObject obj = (JSONObject) JSONParser.parseStrict(unoUser);

		String unoUserID = ConvertJson.getStringValue(obj, "ID");

		getFromID(unoUserID);

	}

	public static void getFromID(final String unoUserID) {

		final UniqueIDServiceAsync unoIDService = GWT
				.create(UniqueIDService.class);

		unoIDService.getUnoUser(unoUserID, new AsyncCallback<String>() {

			public void onFailure(final Throwable caught) {
				System.out.println(caught);
			}

			public void onSuccess(final String jsonResults) {

				JSONObject obj = (JSONObject) JSONParser
						.parseStrict(jsonResults);

				UniqueIDGlobalVariables.uniqueID = obj;
			}
		});
	}

	public static void getFromFacebookID(final String facebookID) {

		final UniqueIDServiceAsync unoIDService = GWT
				.create(UniqueIDService.class);

		unoIDService.getUniqueIDByField("facebookLogin", facebookID,
				new AsyncCallback<String>() {

					public void onFailure(final Throwable caught) {
						System.out.println(caught);
					}

					public void onSuccess(final String jsonResults) {

						JSONObject obj = (JSONObject) JSONParser
								.parseStrict(jsonResults);

						UniqueIDGlobalVariables.uniqueID = obj;
					}
				});

	}
}
