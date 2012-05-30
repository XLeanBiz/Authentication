package co.uniqueid.authentication.client.companies.change;

import co.uniqueid.authentication.client.companies.ListCompanies;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ChangeCompanyPanel extends PopupPanel {

	public ChangeCompanyPanel(final String redirect_URL) {

		// this.center();
		this.setAutoHideEnabled(true);

		VerticalPanel vp = new VerticalPanel();
		vp.setWidth("300px");

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		vp.add(new CloseButton(this));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		vp.add(new Label("Choose your company:"));

		vp.setSpacing(10);
		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		vp.add(showCompanies(this, redirect_URL));

		this.setWidget(vp);

	}

	private VerticalPanel showCompanies(final PopupPanel popup,
			final String redirect_URL) {

		VerticalPanel vp = new VerticalPanel();

		if (ListCompanies.companiesList != null) {

			for (int i = 0; i < ListCompanies.companiesList.size(); i++) {

				JSONObject companyJson = (JSONObject) ListCompanies.companiesList
						.get(i);

				vp.add(new CompanyLogo(companyJson, popup, redirect_URL));
			}
		}

		if (ListCompanies.permissionsList != null) {

			for (int i = 0; i < ListCompanies.permissionsList.size(); i++) {

				JSONObject companyJson = (JSONObject) ListCompanies.permissionsList
						.get(i);

				vp.add(new CompanyLogo(companyJson, popup, redirect_URL));
			}
		}

		return vp;
	}
}
