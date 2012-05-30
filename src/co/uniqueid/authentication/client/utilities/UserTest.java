package co.uniqueid.authentication.client.utilities;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
 
/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class UserTest {

	public static String get() {

		String test = "{\"ID\":\"AllineWatkins_1332886062783\","
				+ "\"image\":\"http://m3.licdn.com/mpr/mpr/shrink_100_100/p/3/000/047/3d0/26e9188.jpg\","
				+ "\"entityName\":\"Alline Watkins\","
				+ "\"first_name\":\"Alline\","
				+ "\"email\":\"alline.oliveira@gmail.com\","
				+ "\"gender\":\"female\"," + "\"facebook_id\":\"537675235\","
				+ "\"githubLogin\":\"allineo\"" + "}";

		JSONObject obj = (JSONObject) JSONParser.parseStrict(test);

		JSONArray foundedsinfo = new JSONArray();

		JSONObject founded = new JSONObject();
		founded.put("ID", new JSONString("CustDevDay_1332642931554"));
		founded.put(
				"image",
				new JSONString(
						"https://fbcdn-sphotos-a.akamaihd.net/hphotos-ak-snc7/396356_341237999249791_341203479253243_1004893_396514349_n.jpg"));
		founded.put("entityName", new JSONString("Customer Development Day"));
		foundedsinfo.set(0, founded);

		founded = new JSONObject();
		founded.put("ID", new JSONString("EXtremeLeanBusiness_1332812176007"));
		founded.put(
				"image",
				new JSONString(
						"http://a7.sphotos.ak.fbcdn.net/hphotos-ak-ash4/422474_331005503607897_330997440275370_884079_1698126433_n.jpg"));
		founded.put("entityName", new JSONString("eXtreme Lean Business"));
		foundedsinfo.set(1, founded);

		obj.put("FoundedInfo", foundedsinfo);

		return obj.toString();

		/*
		 * uniqueIDJsonString={"birthday":"12/23/1974",
		 * "facebook_email":"alline.oliveira@gmail.com",
		 * "MainGroupName":"Companies",
		 * "authToken":["UniqueID(\"c52283e23432375d61bfd26531757ae7\")"],
		 * "image":
		 * "http://media.linkedin.com/mpr/pub/image-ioivm44h01ZaaEhYVyvKGB_zBA9zwCh71GpHI3PNBsCdwUGaioiHI_AhB7Kbw8VDn06c/alline-watkins.jpg"
		 * , "linkedinID":"allineo","relationship_status":"Married",
		 * "Permissions":["UniqueID(\"IoBio_1336784483609\")"],
		 * "twitterID":"allineo"
		 * ,"entityName":"Alline Watkins","first_name":"Alline",
		 * "username":"alline.oliveira","email":"alline.oliveira@gmail.com",
		 * "blogURL":"http://livesrc.blogspot.com",
		 * 
		 * "aboutmeURL":"http://about.me/allineo",
		 * "last_name":"Watkins","ID":"AllineWatkins_1332886062783"
		 * ,"gender":"female",
		 * "Contacts":["UniqueID(\"DanWatkins_1332805297677\")"
		 * ,"UniqueID(\"BryanHall_1332975996140\")",
		 * "UniqueID(\"DanielArroyo_1333054700049\")"
		 * ,"UniqueID(\"WesleyLinQu?ch_1332960872846\")",
		 * "UniqueID(\"PhelanRiessen_1333135212989\")"
		 * ,"UniqueID(\"BrantCooper_1333135249205\")",
		 * "UniqueID(\"JuneClarke_1333135104455\")"
		 * ],"facebookLogin":"alline.oliveira",
		 * "facebook_id":"537675235","githubLogin":"allineo"}
		 * 
		 * + "\"Permissions\":[UniqueID(\"IoBio_1336784483609\")]" +
		 * "\"Founded\":\"[\"UniqueID(\"CustDevDay_1332642931554\")\"," +
		 * "\"UniqueID(\"EXtremeLeanBusiness_1332812176007\")\"," +
		 * "\"UniqueID(\"UniqueID_1332886311914\")\"," +
		 * "\"UniqueID(\"LiveSource_1332803814048\")\"]\""
		 * 
		 * "FoundedInfo":[{"ID":"CustDevDay_1332642931554", "image":
		 * "https://fbcdn-sphotos-a.akamaihd.net/hphotos-ak-snc7/396356_341237999249791_341203479253243_1004893_396514349_n.jpg"
		 * , "entityName":"Customer Development Day"},
		 * {"ID":"EXtremeLeanBusiness_1332812176007", "image":
		 * "http://a7.sphotos.ak.fbcdn.net/hphotos-ak-ash4/422474_331005503607897_330997440275370_884079_1698126433_n.jpg"
		 * , "entityName":"eXtreme Lean Business"},
		 * {"ID":"UniqueID_1332886311914",
		 * "image":"http://www.uniqueid.co/images/UniqueIDLogo_small.jpg",
		 * "entityName":"Unique ID"}, {"ID":"LiveSource_1332803814048", "image":
		 * "https://twimg0-a.akamaihd.net/profile_images/1397794952/logo2.jpg",
		 * "entityName":"Live Source"}]}]
		 */
	}
}
