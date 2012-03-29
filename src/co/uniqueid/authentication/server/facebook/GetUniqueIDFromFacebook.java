package co.uniqueid.authentication.server.facebook;

import java.util.Date;
import java.util.logging.Logger;

import org.json.JSONException;
import org.json.JSONObject;

import co.uniqueid.authentication.server.uniqueID.GetUniqueID;
import co.uniqueid.authentication.server.utilities.JSONUtilities;
import co.uniqueid.authentication.server.utilities.URLUtilities;

public class GetUniqueIDFromFacebook {

	private static Logger logger = Logger.getLogger("UnoIDMe");

	public static String get(final String authenticationToken) {

		JSONObject facebookMe = FacebookAPI.me(authenticationToken);

		String unoUser = saveUniqueID(facebookMe);

		return unoUser;
	}

	public static String saveUniqueID(JSONObject facebookMe) {

		String facebookLogin = JSONUtilities.getString(facebookMe, "username");
		if (facebookLogin == null) {
			facebookLogin = JSONUtilities.getString(facebookMe, "id");
		}

		JSONObject unoUserJson = JSONUtilities.getUserJson(GetUniqueID
				.getByField("facebookLogin", facebookLogin));

		String email = JSONUtilities.getString(facebookMe, "email");

		if (unoUserJson == null) {

			unoUserJson = JSONUtilities.getUserJson(GetUniqueID.getByField(
					"email", email));
			if (unoUserJson != null
					&& JSONUtilities.getString(unoUserJson, "facebookLogin") == null) {
				try {
					unoUserJson.put("facebookLogin", facebookLogin);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}

		if (unoUserJson == null) {

			String unoUserID = JSONUtilities
					.getString(facebookMe, "first_name")
					+ JSONUtilities.getString(facebookMe, "last_name")
					+ "_"
					+ (new Date()).getTime();
			
			/*String unoUserID = URLUtilities.compactName(JSONUtilities
					.getString(facebookMe, "name"))
					+ "_"
					+ (new Date()).getTime();*/

			unoUserJson = createUniqueID(unoUserID, facebookLogin, email);
		}

		// logger.log(Level.INFO, "unoUserJson=" + unoUserJson);

		SaveUniqueIDFromFacebook.save(unoUserJson, facebookMe);

		return unoUserJson.toString();
	}

	private static JSONObject createUniqueID(final String unoUserID,
			final String facebookLogin, final String email) {

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
