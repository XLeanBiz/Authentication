package co.uniqueid.authentication.server.facebook;

import com.google.appengine.repackaged.org.json.JSONArray;
import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

public class FacebookFriends {

	public static void getFriends(final String authenticationToken) {

		JSONArray facebookMyFriends = FacebookAPI
				.myFriends(authenticationToken);

		saveFriends(facebookMyFriends);
	}

	private static void saveFriends(JSONArray facebookFriends) {

		for (int i = 0; i < facebookFriends.length(); i++) {

			JSONObject friend = new JSONObject();
			try {

				friend = (JSONObject) facebookFriends.get(i);

				GetUniqueIDFromFacebook.saveUniqueID(friend);

			} catch (JSONException e) {

				e.printStackTrace();
			}

		}
	}

	public static void getUser(final String facebookID,
			final String authenticationToken) {

		JSONObject facebookUser = FacebookAPI.user(facebookID,
				authenticationToken);

		GetUniqueIDFromFacebook.saveUniqueID(facebookUser);
	}
}
