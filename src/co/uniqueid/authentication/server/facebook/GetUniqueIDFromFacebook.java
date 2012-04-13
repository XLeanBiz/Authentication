package co.uniqueid.authentication.server.facebook;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import co.uniqueid.authentication.server.uniqueID.GetUniqueID;
import co.uniqueid.authentication.server.utilities.JSONUtilities;
import co.uniqueid.authentication.server.utilities.URLUtilities;

public class GetUniqueIDFromFacebook {

	public static String get(final String authenticationToken) {

		JSONObject facebookMe = FacebookAPI.me(authenticationToken);

		JSONObject unoUser = saveUniqueID(facebookMe);
		
		try {
			unoUser.put("authenticationToken", authenticationToken);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return unoUser.toString();
	}

	public static JSONObject saveUniqueID(JSONObject facebookMe) {

		String facebookLogin = JSONUtilities.getString(facebookMe, "id");

		JSONObject unoUserJson = JSONUtilities.getUserJson(GetUniqueID
				.getByField("facebookLogin", facebookLogin));

		if (unoUserJson == null) {

			unoUserJson = JSONUtilities.getUserJson(GetFacebookInfo.getByField(
					"facebook_id", facebookLogin));

			if (unoUserJson == null) {

				String email = JSONUtilities.getString(facebookMe, "email");

				unoUserJson = JSONUtilities.getUserJson(GetUniqueID.getByField(
						"email", email));
				if (unoUserJson != null
						&& JSONUtilities
								.getString(unoUserJson, "facebookLogin") == null) {
					try {
						unoUserJson.put("facebookLogin", facebookLogin);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			}
		}

		if (unoUserJson == null) {

			String name = JSONUtilities.getString(facebookMe, "first_name");

			if (name == null) {

				name = JSONUtilities.getString(facebookMe, "name");
			} else {

				name += JSONUtilities.getString(facebookMe, "last_name");
			}

			String unoUserID = URLUtilities.compactName(name) + "_"
					+ (new Date()).getTime();

			unoUserJson = createUniqueID(unoUserID, facebookLogin);
		}

		SaveUniqueIDFromFacebook.save(unoUserJson, facebookMe);

		return unoUserJson;
	}

	private static JSONObject createUniqueID(final String unoUserID,
			final String facebookLogin) {

		JSONObject jsonObject = new JSONObject();

		try {

			jsonObject.put("ID", unoUserID);
			jsonObject.put("facebookLogin", facebookLogin);
			// jsonObject.put("email", email);

		} catch (JSONException e) {
			// e.printStackTrace();
		}

		return jsonObject;
	}

}
