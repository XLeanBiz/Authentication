package co.uniqueid.authentication.server.facebook;

import co.uniqueid.authentication.server.utilities.JSONUtilities;
import co.uniqueid.authentication.server.utilities.URLUtilities;

import com.google.appengine.repackaged.org.json.JSONObject;

public class SaveFacebookInfo {

	private static String saveUnoUserUrl = "http://jsonpfy.unoidme.appspot.com/SaveDataService";

	public static void save(JSONObject unoUserJson) {

		String unoUserID = JSONUtilities.getString(unoUserJson, "ID");
		String parameters = "kind=FacebookInfo&ID=" + unoUserID;

		parameters += URLUtilities.addSaveParameterString(unoUserJson,
				"facebook_id");

		parameters += URLUtilities.addSaveParameterString(unoUserJson,
				"username");

		parameters += URLUtilities.addSaveParameterString(unoUserJson,
				"facebook_email");

		parameters += URLUtilities.addSaveParameterString(unoUserJson,
				"first_name");

		parameters += URLUtilities.addSaveParameterString(unoUserJson,
				"last_name");

		parameters += URLUtilities
				.addSaveParameterString(unoUserJson, "gender");

		parameters += URLUtilities.addSaveParameterString(unoUserJson,
				"birthday");

		parameters += URLUtilities.addSaveParameterString(unoUserJson,
				"relationship_status");

		// parameters += addParameter(unoUserJson, "city");

		URLUtilities.fetchURLPost(saveUnoUserUrl, parameters);
	}

}
