package co.uniqueid.authentication.server.uniqueID;


import org.json.JSONObject;

import co.uniqueid.authentication.server.utilities.JSONUtilities;
import co.uniqueid.authentication.server.utilities.URLUtilities;

public class SaveUnoUser {

	private static String saveUnoUserUrl = "http://jsonpfy.unoidme.appspot.com/SaveDataService";

	public static void save(JSONObject unoUserJson) {

		String unoUserID = JSONUtilities.getString(unoUserJson, "ID");
		String parameters = "kind=Entity&ID=" + unoUserID;

		String email = JSONUtilities.getString(unoUserJson, "email");
		if (email != null) {
			parameters += "&fieldsKind=String&fieldsName=email&fieldsValue="
					+ URLUtilities.encode(email);
		}

		String image = JSONUtilities.getString(unoUserJson, "image");
		if (image != null) {
			parameters += "&fieldsKind=String&fieldsName=image&fieldsValue="
					+ URLUtilities.encode(image);
		}

		String facebookLogin = JSONUtilities.getString(unoUserJson,
				"facebookLogin");
		if (facebookLogin != null) {
			parameters += "&fieldsKind=String&fieldsName=facebookLogin&fieldsValue="
					+ URLUtilities.encode(facebookLogin);
		}

		String firstName = JSONUtilities.getString(unoUserJson, "firstName");
		if (firstName != null) {
			parameters += "&fieldsKind=String&fieldsName=firstName&fieldsValue="
					+ URLUtilities.encode(firstName);
		}

		String lastName = JSONUtilities.getString(unoUserJson, "lastName");
		if (lastName != null) {
			parameters += "&fieldsKind=String&fieldsName=lastName&fieldsValue="
					+ URLUtilities.encode(lastName);
		}

		String gender = JSONUtilities.getString(unoUserJson, "gender");
		if (gender != null) {
			parameters += "&fieldsKind=String&fieldsName=gender&fieldsValue="
					+ URLUtilities.encode(gender);
		}

		String birthday = JSONUtilities.getString(unoUserJson, "birthday");
		if (birthday != null) {
			parameters += "&fieldsKind=String&fieldsName=birthday&fieldsValue="
					+ URLUtilities.encode(birthday);
		}

		String maritalStatus = JSONUtilities.getString(unoUserJson,
				"maritalStatus");
		if (maritalStatus != null) {
			parameters += "&fieldsKind=String&fieldsName=maritalStatus&fieldsValue="
					+ URLUtilities.encode(maritalStatus);
		}

		String city = JSONUtilities.getString(unoUserJson, "image");
		if (city != null) {
			parameters += "&fieldsKind=String&fieldsName=city&fieldsValue="
					+ URLUtilities.encode(city);
		}

		URLUtilities.fetchURLPost(saveUnoUserUrl, parameters);
	}
}
