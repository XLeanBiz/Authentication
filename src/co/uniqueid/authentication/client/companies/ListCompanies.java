package co.uniqueid.authentication.client.companies;

import co.uniqueid.authentication.client.UniqueIDGlobalVariables;

import com.google.gwt.json.client.JSONArray;

public class ListCompanies {

	public static JSONArray companiesList = null;

	public static JSONArray permissionsList = null;

	public static void list() {

		if (UniqueIDGlobalVariables.uniqueID.get("FoundedInfo") != null) {

			companiesList = UniqueIDGlobalVariables.uniqueID.get("FoundedInfo")
					.isArray();
		}

		if (UniqueIDGlobalVariables.uniqueID.get("PermissionsInfo") != null) {

			permissionsList = UniqueIDGlobalVariables.uniqueID.get(
					"PermissionsInfo").isArray();
		}
	}
}
