package co.uniqueid.authentication.client.uniqueid;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface UniqueIDServiceAsync {

	void getUnoUser(String unoUserID, AsyncCallback<String> callback);

	void saveUnoUser(String unoUserJsonString, AsyncCallback<String> callback);

	void getUniqueIDByField(String fieldName, String fieldValue,
			AsyncCallback<String> callback);
}
