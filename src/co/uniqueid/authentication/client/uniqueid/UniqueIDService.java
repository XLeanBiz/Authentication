package co.uniqueid.authentication.client.uniqueid;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("uniqueID")
public interface UniqueIDService extends RemoteService {

	String getUniqueID(final String unoUserID);

	String getUniqueIDByField(final String fieldName, final String fieldValue);

	String saveUniqueID(final String unoUserJsonString);
}
