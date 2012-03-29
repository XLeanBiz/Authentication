package co.uniqueid.authentication.server.facebook;

import co.uniqueid.authentication.server.utilities.URLUtilities;

public class FacebookLogin {

	private static final String Facebook_OAUTH_URL = "https://graph.facebook.com/oauth/access_token";

	public static String login(final String AppID, final String AppSecret,
			final String authCode, final String redirect_URL) {

		String unoUser = null;

		final String parameters = getAccessTokenUrl(AppID, AppSecret, authCode,
				redirect_URL);

		String authenticationToken = URLUtilities.fetchURLPost(
				Facebook_OAUTH_URL, parameters);

		if (authenticationToken != null
				&& authenticationToken.contains("access_token=")) {

			unoUser = GetUniqueIDFromFacebook.get(authenticationToken);
		}

		return unoUser;
	}

	private static String getAccessTokenUrl(final String AppID,
			final String AppSecret, final String authCode,
			final String redirect_URL) {

		final StringBuilder sb = new StringBuilder();

		sb.append("client_id=").append(AppID);
		sb.append("&client_secret=").append(AppSecret);
		sb.append("&code=").append(authCode);
		sb.append("&redirect_uri=").append(redirect_URL);

		return sb.toString();
	}

}
