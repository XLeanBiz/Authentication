package co.uniqueid.authentication.server.uniqueID;

import org.json.JSONObject;

import co.uniqueid.authentication.server.utilities.JSONUtilities;
import co.uniqueid.authentication.server.utilities.URLUtilities;

public class SaveUniqueID {

	private static String saveUnoUserUrl = "http://jsonpfy.unoidme.appspot.com/SaveDataService";

	public static void save(JSONObject unoUserJson) {

		String unoUserID = JSONUtilities.getString(unoUserJson, "ID");
		String parameters = "kind=UniqueID&ID=" + unoUserID;
		
		parameters += URLUtilities.addSaveParameter(unoUserJson, "name");
		
		parameters += URLUtilities.addSaveParameter(unoUserJson, "image");

		parameters += URLUtilities.addSaveParameter(unoUserJson, "email");

		parameters += URLUtilities.addSaveParameter(unoUserJson, "facebookLogin");

		parameters += URLUtilities.addSaveParameter(unoUserJson, "twitterID");

		parameters += URLUtilities.addSaveParameter(unoUserJson, "linkedinID");

		parameters += URLUtilities.addSaveParameter(unoUserJson, "aboutmeURL");

		parameters += URLUtilities.addSaveParameter(unoUserJson, "blogURL");

		parameters += URLUtilities.addSaveParameter(unoUserJson, "githubLogin");
		
		parameters += URLUtilities.addSaveParameter(unoUserJson, "googleAccount");

		URLUtilities.fetchURLPost(saveUnoUserUrl, parameters);
	}
}
