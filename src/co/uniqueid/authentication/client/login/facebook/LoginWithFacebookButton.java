package co.uniqueid.authentication.client.login.facebook;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;

public class LoginWithFacebookButton extends Image {

	private static final String FB_OAUTH_URL = "https://graph.facebook.com/oauth/authorize";

	public LoginWithFacebookButton(final String appID, final String redirectURL) {

		this.setUrl(GWT.getModuleName()
				+ "/authentication/images/FacebookLogin.png");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				FacebookLoginPanel.hpFacebookLogin.clear();

				redirect(getAuthorizeUrl(appID, redirectURL));
			}
		});
	}

	public static String getAuthorizeUrl(final String appID,
			final String redirectURL) {

		final StringBuilder sb = new StringBuilder(FB_OAUTH_URL);
		sb.append("?client_id=").append(appID);
		sb.append("&display=page&redirect_uri=").append(redirectURL);
		sb.append("&scope=email,user_birthday,user_about_me,user_relationships, "
				+ "friends_about_me, friends_birthday, friends_relationships");
		return sb.toString();
	}

	// redirect the browser to the given url
	public static native void redirect(String url)/*-{
		$wnd.location = url;
	}-*/;
}
