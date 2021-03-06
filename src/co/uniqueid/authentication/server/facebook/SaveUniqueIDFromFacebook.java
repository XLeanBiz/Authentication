package co.uniqueid.authentication.server.facebook;

import co.uniqueid.authentication.server.uniqueID.SaveUniqueID;
import co.uniqueid.authentication.server.utilities.JSONUtilities;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

public class SaveUniqueIDFromFacebook {

	public static void save(JSONObject unoUserJson, final JSONObject facebookMe) {

		updateValue(unoUserJson, facebookMe, "facebook_email", "email");

		updateValue(unoUserJson, facebookMe, "facebook_id", "id");

		updateFacebookValue(unoUserJson, facebookMe, "username");

		updateFacebookValue(unoUserJson, facebookMe, "first_name");

		updateFacebookValue(unoUserJson, facebookMe, "last_name");

		updateFacebookValue(unoUserJson, facebookMe, "gender");

		updateFacebookValue(unoUserJson, facebookMe, "birthday");

		updateFacebookValue(unoUserJson, facebookMe, "relationship_status");

		// JSONObject hometown = facebookMe.getJSONObject("hometown");
		// String image = facebookMe.getString("id");

		SaveFacebookInfo.save(unoUserJson);

		unoUserJson = updateName(unoUserJson);
		
		unoUserJson = updateImage(unoUserJson);
		
		SaveUniqueID.save(unoUserJson);

	}

	private static void updateValue(JSONObject unoUserJson,
			final JSONObject facebookMe, final String unoUserKey,
			final String facebookKey) {

		String value = JSONUtilities.getString(facebookMe, facebookKey);

		try {
			unoUserJson.put(unoUserKey, value);
		} catch (JSONException e) {
			// e.printStackTrace();
		}
	}

	private static void updateFacebookValue(JSONObject unoUserJson,
			final JSONObject facebookMe, final String facebookKey) {

		String value = JSONUtilities.getString(facebookMe, facebookKey);

		try {
			unoUserJson.put(facebookKey, value);
		} catch (JSONException e) {
			// e.printStackTrace();
		}
	}

	private static JSONObject updateName(JSONObject unoUserJson) {

		String name = JSONUtilities.getString(unoUserJson, "entityName");

		if (name == null) {

			String first = JSONUtilities.getString(unoUserJson, "first_name");
			String last = JSONUtilities.getString(unoUserJson, "last_name");

			name = first + " " + last;

			try {
				unoUserJson.put("entityName", name);
			} catch (JSONException e) {
				// e.printStackTrace();
			}
		}

		return unoUserJson;
	}

	private static JSONObject updateImage(final JSONObject unoUserJson) {

		String image = JSONUtilities.getString(unoUserJson, "image");

		if (image == null) {

			String facebookLogin = JSONUtilities.getString(unoUserJson,
					"facebookLogin");

			image = "http://graph.facebook.com/" + facebookLogin + "/picture";

			try {
				unoUserJson.put("image", image);
			} catch (JSONException e) {
				// e.printStackTrace();
			}
		}
		
		return unoUserJson;
	}
}
