package co.uniqueid.authentication.client.companies;

import co.uniqueid.authentication.client.companies.change.ChangeCompanyPanel;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class CompanyIcon {

	public static HorizontalPanel hpCompanyIcon = new HorizontalPanel();

	public CompanyIcon(final JSONObject companyJson, final String redirect_URL) {

		hpCompanyIcon.clear();

		HTML icon = new HTML();

		String entityName = ConvertJson.getStringValue(companyJson,
				"entityName");

		String imageURL = ConvertJson.getStringValue(companyJson, "image");

		icon.setHTML("<a href='#'><img src='" + imageURL
				+ "' border=0 width='30px' height='30px' title='" + entityName
				+ "'></a>");
		icon.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ChangeCompanyPanel popup = new ChangeCompanyPanel(redirect_URL);

				popup.show();
			}
		});

		hpCompanyIcon.add(icon);
	}
}
