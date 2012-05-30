package co.uniqueid.authentication.server.uniqueID;

import co.uniqueid.authentication.server.utilities.URLUtilities;

public class GetUniqueID {

	private static String getUniqueIDUrl = "https://api.unoidme.appspot.com/GetUniqueIDService";

	private static String searchUniqueIDUrl = "https://api.unoidme.appspot.com/SearchUniqueIDService";

	public static String getByID(final String uniqueID) {

		String parameters = "UniqueID=" + uniqueID;

		final String jsonString = URLUtilities.fetchURLPost(getUniqueIDUrl,
				parameters);

		return jsonString;
	}

	public static String getByField( String fieldName,  String fieldValue) {

		//fieldName="facebookLogin";
		//fieldValue="alline.oliveira";
		
		String parameters = "fieldName=" + fieldName + "&fieldValue="
				+ fieldValue;

		final String jsonString = URLUtilities.fetchURLPost(searchUniqueIDUrl,
				parameters);

		return jsonString;
	}

}
