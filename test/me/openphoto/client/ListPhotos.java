package me.openphoto.client;

import junit.framework.TestCase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ListPhotos extends TestCase {

	public void testGetAll() {
		OpenPhotoClient client = new OpenPhotoClient();
		// Map<String, String> map = new HashMap<String, String>();
		// map.put("returnSizes", "20x20");

		String result = client.rawGet("/photos/list.json", null);
		System.out.println(result);

		// testing
		assertNotNull("Answer should not be null", result);

	}

	public void testGetAlbums() throws JSONException {
		OpenPhotoClient client = new OpenPhotoClient();
		String result = client.rawGet("/albums/list.json", null);
		System.out.println(result);

		JSONObject json = new JSONObject(result);
		JSONArray data = json.getJSONArray("result");

		// testing
		assertNotNull("Answer should not be null", result);
		assertTrue("Code is not 200", json.getInt("code") == 200);
		assertTrue("Array should be empty or >1 ", data.length() >= 0);
	}
}
