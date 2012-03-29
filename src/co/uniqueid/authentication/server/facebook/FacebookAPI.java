package co.uniqueid.authentication.server.facebook;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import co.uniqueid.authentication.server.utilities.URLUtilities;

public class FacebookAPI {

	private static Logger logger = Logger.getLogger("facebook");

	private static final String meURL = "https://graph.facebook.com/me";

	private static final String userURL = "https://graph.facebook.com/";

	private static final String facebookFriendsURL = "https://graph.facebook.com/me/friends";

	public static JSONObject me(final String authToken) {

		JSONObject json = new JSONObject();

		final String jsonString = URLUtilities.fetchURLGet(meURL, authToken);

		// logger.log(Level.INFO, "faceboookMejsonString=" + jsonString);

		try {
			json = new JSONObject(jsonString);

		} catch (JSONException e) {
			// e.printStackTrace();
		}

		return json;
	}

	public static JSONObject user(final String facebookID,
			final String authToken) {

		JSONObject json = new JSONObject();

		final String jsonString = URLUtilities.fetchURLGet(
				userURL + facebookID, authToken);

		// logger.log(Level.INFO, "faceboookMejsonString=" + jsonString);

		try {
			json = new JSONObject(jsonString);

		} catch (JSONException e) {
			// e.printStackTrace();
		}

		return json;
	}

	public static JSONArray myFriends(final String authToken) {

		final String jsonString = URLUtilities.fetchURLGet(facebookFriendsURL,
				authToken);

		logger.log(Level.INFO, "faceboookFriendsjsonString=" + jsonString);

		JSONObject json = new JSONObject();
		try {
			json = new JSONObject(jsonString);

		} catch (JSONException e) {
			// e.printStackTrace();
		}

		JSONArray friendsJsonArray = new JSONArray();
		try {
			friendsJsonArray = (JSONArray) json.get("data");

		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return friendsJsonArray;
	}
}
