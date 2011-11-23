package me.openphoto.client;

import java.util.Map;

public class OpenPhotoClient {
	private String host;
	private String consumerKey;
	private String token;
	private String tokenSecret;

	public OpenPhotoClient(String host, String consumerKey, String token, String tokenSecret) {
		this.host = host;
		this.consumerKey = consumerKey;
		this.token = token;
		this.tokenSecret = tokenSecret;
	}

	public OpenPhotoClient() {
		// first try to get the details from the system properties

		// otherwise from ConfigurationProperties.java

		// throw exception
		throw new IllegalAccessError("No OAuth Credentials found");
	}

	public Map<String, String> rawGet(String getRequest) {
		return null;
	}

	public Map<String, String> rawPost(String postRequest, String[] parameters) {
		return null;
	}
}
