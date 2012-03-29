package co.uniqueid.authentication.server.uniqueID;

import org.json.JSONException;
import org.json.JSONObject;

import co.uniqueid.authentication.client.uniqueid.UniqueIDService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UniqueIDServiceImpl extends RemoteServiceServlet implements
		UniqueIDService {

	private static final long serialVersionUID = -8355612980477933670L;

	public String getUniqueID(final String uniqueID) {

		return GetUniqueID.getByID(uniqueID);
	}

	public String getUniqueIDByField(final String fieldName,
			final String fieldValue) {

		return GetUniqueID.getByField(fieldName, fieldValue);
	}

	public String saveUniqueID(String unoUserJsonString) {

		JSONObject json = new JSONObject();
		try {
			json = new JSONObject(unoUserJsonString);
		} catch (JSONException e) {
			// e.printStackTrace();
		}

		unoUserJsonString = SaveUniqueID.save(json);

		return unoUserJsonString;
	}

}
