package co.uniqueid.authentication.client.uniqueid;

import co.uniqueid.authentication.client.GWTEntryPoint;
import co.uniqueid.authentication.client.me.MyPanel;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetUniqueIDTest {

	public static void get(final String unoUser) {

		JSONObject obj = (JSONObject) JSONParser.parseStrict(unoUser);

		String unoUserID = ConvertJson.getStringValue(obj, "ID");

		getFromID(unoUserID);

	}

	public static void getFromID(final String unoUserID) {

		final UniqueIDServiceAsync unoIDService = GWT.create(UniqueIDService.class);

		unoIDService.getUniqueID(unoUserID, new AsyncCallback<String>() {

			public void onFailure(final Throwable caught) {
				System.out.println(caught);
			}

			public void onSuccess(final String jsonResults) {

				JSONObject obj = (JSONObject) JSONParser
						.parseStrict(jsonResults);

				GWTEntryPoint.vpMain.clear();
				GWTEntryPoint.vpMain.add(new MyPanel(obj));
			}
		});

	}
}
