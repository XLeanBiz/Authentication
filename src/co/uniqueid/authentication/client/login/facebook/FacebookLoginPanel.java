package co.uniqueid.authentication.client.login.facebook;

import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.login.AnchorLogout;
import co.uniqueid.authentication.client.me.MyPhoto;

import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class FacebookLoginPanel {

	public static HorizontalPanel hpFacebookLogin = new HorizontalPanel();

	public static void setPanel(final String appID, final String redirectURL) {

		hpFacebookLogin.setWidth("300px");
		hpFacebookLogin.setSpacing(5);
		hpFacebookLogin.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		hpFacebookLogin
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		if (UniqueIDGlobalVariables.uniqueID == null) {

			Cookies.setCookie("UniqueID", null);

			hpFacebookLogin.clear();

			hpFacebookLogin
					.add(new LoginWithFacebookButton(appID, redirectURL));

		} else {

			setLoggedUser();
		}
	}

	public static void setLoggedUser() {

		hpFacebookLogin.clear();

		hpFacebookLogin.add(new MyPhoto(UniqueIDGlobalVariables.uniqueID));

		Label space3 = new Label(" | ");
		hpFacebookLogin.add(space3);

		hpFacebookLogin.add(new AnchorLogout());
	}
}
