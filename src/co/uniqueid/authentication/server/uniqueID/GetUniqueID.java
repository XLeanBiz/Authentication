package co.uniqueid.authentication.server.uniqueID;

import org.json.JSONObject;

import co.uniqueid.authentication.server.utilities.JSONUtilities;
import co.uniqueid.authentication.server.utilities.URLUtilities;

public class GetUniqueID {

	// http://jsonpfy.unoidme.appspot.com/ListDataService
	// ?kind=Entity
	// &filterField=email&filterValue=alline.oliveira@gmail.com

	private static String getUnoUserEmailUrl = "http://jsonpfy.unoidme.appspot.com/ListDataService";

	public static JSONObject getByEmail(final String email) {

		String parameters = "kind=UniqueID&filterField=email&filterValue="
				+ email;

		final String jsonString = URLUtilities.fetchURLPost(getUnoUserEmailUrl,
				parameters);

		return JSONUtilities.getUserJson(jsonString);
	}

	public static String getByFacebookLogin(final String facebookLogin) {

		String parameters = "kind=UniqueID&filterField=facebookLogin&filterValue="
				+ facebookLogin;

		final String jsonString = URLUtilities.fetchURLPost(getUnoUserEmailUrl,
				parameters);

		return jsonString;

	}

	public static JSONObject getByGithubLogin(final String githubLogin) {

		String parameters = "kind=UniqueID&filterField=githubLogin&filterValue="
				+ githubLogin;

		final String jsonString = URLUtilities.fetchURLPost(getUnoUserEmailUrl,
				parameters);

		return JSONUtilities.getUserJson(jsonString);
	}



}
