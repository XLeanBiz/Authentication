package co.uniqueid.authentication.client.login;

import co.uniqueid.authentication.client.login.facebook.FacebookAppsProperties;
import co.uniqueid.authentication.client.login.facebook.LoginWithFacebookButton;
import co.uniqueid.authentication.client.login.github.LoginGithubButton;

import com.google.gwt.user.client.ui.VerticalPanel;

public class LoginButtons extends VerticalPanel {

	public LoginButtons() {

		this.setSpacing(20);

		this.add(new LoginWithFacebookButton(
				FacebookAppsProperties.testFacebookID,
				FacebookAppsProperties.test_REDIRECT_URL));

		this.add(new LoginGithubButton());
	}
}
