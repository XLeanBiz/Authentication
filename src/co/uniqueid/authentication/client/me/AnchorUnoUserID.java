package co.uniqueid.authentication.client.me;

import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Anchor;

public class AnchorUnoUserID extends Anchor {

	public AnchorUnoUserID(final JSONObject unoUser) {

		String unoUserID = ConvertJson.convertToString(unoUser.get("ID"));

		this.setHTML(unoUserID);

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

			}
		});
	}
}
