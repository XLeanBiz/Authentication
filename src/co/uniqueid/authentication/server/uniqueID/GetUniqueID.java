package co.uniqueid.authentication.server.uniqueID;

import co.uniqueid.authentication.server.utilities.URLUtilities;

public class GetUniqueID {

	private static String getUniqueIDUrl = "http://api.unoidme.appspot.com/GetUniqueIDService";

	private static String searchUniqueIDUrl = "http://api.unoidme.appspot.com/SearchUniqueIDService";

	public static String getByID(final String uniqueID) {

		String parameters = "UniqueID=" + uniqueID;

		final String jsonString = URLUtilities.fetchURLPost(getUniqueIDUrl,
				parameters);

		return jsonString;
	}

	public static String getByField(final String fieldName, final String fieldValue) {

		String parameters = "fieldName=" + fieldName + "&fieldValue="
				+ fieldValue;

		final String jsonString = URLUtilities.fetchURLPost(searchUniqueIDUrl,
				parameters);

		return jsonString;
	}

}
