package co.uniqueid.authentication.client.me;

import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class MyPhoto extends HorizontalPanel {

	public MyPhoto(final JSONObject unoUserJson) {

		this.setSpacing(5);
		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		String imageURL = ConvertJson.getStringValue(unoUserJson, "image");
		if (imageURL != null) {

			HTML image = new HTML(
					"<a href='http://unoidme.appspot.com?search="
							+ ConvertJson.getStringValue(unoUserJson,
									"facebookLogin")
							+ "' target='_blank'><img src='" + imageURL
							+ "' border=0 width='35px' height='35px'></a>");
			this.add(image);
		}

		HTML name = new HTML(
				"<font size=2 color=blue><a href='http://unoidme.appspot.com?search="
						+ ConvertJson.getStringValue(unoUserJson, "facebookLogin")
						+ "' target='_blank'>" + ConvertJson.getStringValue(unoUserJson, "entityName")
						+ "</a></font>");
		this.add(name);
	}
}
