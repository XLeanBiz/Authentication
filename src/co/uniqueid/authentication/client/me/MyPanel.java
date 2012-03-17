package co.uniqueid.authentication.client.me;

import co.uniqueid.authentication.client.login.AnchorLogout;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MyPanel extends VerticalPanel {

	public MyPanel(final JSONObject unoUserJson) {

		this.setSpacing(20);

		this.add(new AnchorLogout());

		this.add(new AnchorUnoUserID(unoUserJson));

		MyPhoto myPhoto = new MyPhoto(unoUserJson);
		myPhoto.addDomHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {


			}
		}, ClickEvent.getType());

		this.add(myPhoto);

		this.add(new Label(unoUserJson.toString()));
	}
}
