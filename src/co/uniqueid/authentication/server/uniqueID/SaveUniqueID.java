package co.uniqueid.authentication.server.uniqueID;

import org.json.JSONObject;

import co.uniqueid.authentication.server.utilities.JSONUtilities;
import co.uniqueid.authentication.server.utilities.URLUtilities;

public class SaveUniqueID {

	private static String saveUnoUserUrl = "http://jsonpfy.unoidme.appspot.com/SaveDataService";

	public static void save(JSONObject unoUserJson) {

		String unoUserID = JSONUtilities.getString(unoUserJson, "ID");
		String parameters = "kind=Entity&ID=" + unoUserID;

		parameters += addParameter(unoUserJson, "email");

		parameters += addParameter(unoUserJson, "image");

		parameters += addParameter(unoUserJson, "firstName");

		parameters += addParameter(unoUserJson, "lastName");

		parameters += addParameter(unoUserJson, "gender");

		parameters += addParameter(unoUserJson, "birthday");

		parameters += addParameter(unoUserJson, "maritalStatus");

		parameters += addParameter(unoUserJson, "city");

		parameters += addParameter(unoUserJson, "facebookLogin");

		parameters += addParameter(unoUserJson, "twitterID");

		parameters += addParameter(unoUserJson, "linkedinID");

		parameters += addParameter(unoUserJson, "aboutmeURL");

		parameters += addParameter(unoUserJson, "blogURL");

		parameters += addParameter(unoUserJson, "githubLogin");

		URLUtilities.fetchURLPost(saveUnoUserUrl, parameters);
	}

	private static String addParameter(JSONObject json, String parameter) {

		String parameterValue = JSONUtilities.getString(json, parameter);
		if (parameterValue != null) {
			return "&fieldsKind=String&fieldsName=" + parameter
					+ "&fieldsValue=" + URLUtilities.encode(parameterValue);
		} else {

			return "";
		}
	}
}
