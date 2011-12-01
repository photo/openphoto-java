package me.openphoto.client;

import junit.framework.TestCase;

public class ListPhotos extends TestCase {

	public void testGetAll() {
		OpenPhotoClient client = new OpenPhotoClient();
		// Map<String, String> map = new HashMap<String, String>();
		// map.put("returnSizes", "20x20");

		String result = client.rawGet("/photos/list.json", null);
		assertNotNull("Answer should not be null", result);
		System.out.println(result);
	}
}
