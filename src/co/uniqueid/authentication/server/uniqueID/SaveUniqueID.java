package co.uniqueid.authentication.server.uniqueID;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import co.uniqueid.authentication.server.utilities.JSONUtilities;
import co.uniqueid.authentication.server.utilities.URLUtilities;

public class SaveUniqueID {

	private static String saveUniqueIDUrl = "http://api.unoidme.appspot.com/SaveUniqueIDService";

	public static String save(JSONObject unoUserJson) {

		String parameters = "UniqueID=" + getID(unoUserJson);

		parameters += "override=false";

		parameters += addSaveParameter(unoUserJson, "entityName");

		parameters += addSaveParameter(unoUserJson, "image");

		parameters += addSaveParameter(unoUserJson, "email");

		// parameters += addSaveParameter(unoUserJson, "facebookLogin");

		parameters += addSaveParameter(unoUserJson, "twitterID");

		parameters += addSaveParameter(unoUserJson, "linkedinID");

		parameters += addSaveParameter(unoUserJson, "aboutmeURL");

		parameters += addSaveParameter(unoUserJson, "blogURL");

		parameters += addSaveParameter(unoUserJson, "githubLogin");

		parameters += addSaveParameter(unoUserJson, "googleAccount");

		URLUtilities.fetchURLPost(saveUniqueIDUrl, parameters);

		return unoUserJson.toString();
	}

	private static String getID(JSONObject unoUserJson) {

		String uniqueID = JSONUtilities.getString(unoUserJson, "ID");

		if (uniqueID == null) {

			uniqueID = URLUtilities.compactName(JSONUtilities.getString(
					unoUserJson, "entityName")) + "_" + (new Date().getTime());

			try {
				unoUserJson.put("ID", uniqueID);

			} catch (JSONException e) {

				e.printStackTrace();
			}
		}

		return uniqueID;
	}

	private static String addSaveParameter(JSONObject json, String parameter) {

		String parameterValue = JSONUtilities.getString(json, parameter);
		if (parameterValue != null) {
			return "&" + parameter + "=" + URLUtilities.encode(parameterValue);
		} else {

			return "";
		}
	}
}
