package co.uniqueid.authentication.client.companies;

import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;

public class GetFirstCompany {

	public static void get(String companyReferenceID, final String redirect_URL) {

		if (companyReferenceID == null) {

			JSONObject companyJson = null;

			if (ListCompanies.companiesList != null) {

				companyJson = (JSONObject) ListCompanies.companiesList.get(0);

				companyReferenceID = ConvertJson.getStringValue(companyJson,
						"ID");

			} else if (ListCompanies.permissionsList != null) {

				companyJson = (JSONObject) ListCompanies.permissionsList.get(0);

				companyReferenceID = ConvertJson.getStringValue(companyJson,
						"ID");
			}

			if (companyReferenceID != null) {

				GetCompany.get(companyReferenceID, redirect_URL, true);
			}
			
		} else {

			JSONObject json = new JSONObject();
				json.put("ID", new JSONString(companyReferenceID));

				UniqueIDGlobalVariables.companyUniqueID = json;

				GetCompany.get(companyReferenceID, redirect_URL, false);
		}
	}
}
