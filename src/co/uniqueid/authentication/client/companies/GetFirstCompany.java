package co.uniqueid.authentication.client.companies;

import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;

public class GetFirstCompany {

	public static void get(String companyReferenceID) {

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
		}

		if (companyReferenceID != null) {

			GetCompany.get(companyReferenceID, null);
		}
	}
}
