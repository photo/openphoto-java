package me.openphoto.client;

import java.util.Map;
import java.util.Map.Entry;

import me.openphoto.client.util.ConfigurationProperties;
import me.openphoto.client.util.OpenPhotoAPI;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class OpenPhotoClient {
	private String host;
	private String consumerKey;
	private String consumerSecret;
	private String token;
	private String tokenSecret;

	public OpenPhotoClient(String host, String consumerKey, String consumerSecret, String token, String tokenSecret) {
		this.host = host;
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
		this.token = token;
		this.tokenSecret = tokenSecret;
	}

	public OpenPhotoClient() {
		// first try to get the details from the system properties
		this.host = System.getProperty("host");
		this.consumerKey = System.getProperty("consumerKey");
		this.consumerSecret = System.getProperty("consumerSecret");
		this.token = System.getProperty("token");
		this.tokenSecret = System.getProperty("tokenSecret");

		if (host == null && consumerKey == null && consumerSecret == null && token == null && tokenSecret == null)
			// otherwise from ConfigurationProperties.java
			if (!checkConfigurationProperties()) {
				// throw exception
				throw new IllegalAccessError("No OAuth Credentials found");
			} else {
				// set the details on this class
				this.host = ConfigurationProperties.HOST;
				this.consumerKey = ConfigurationProperties.CONSUMER_KEY;
				this.consumerSecret = ConfigurationProperties.CONSUMER_SECRET;
				this.token = ConfigurationProperties.TOKEN;
				this.tokenSecret = ConfigurationProperties.TOKEN_SECRET;
			}
	}

	public String rawGet(String endpoint, Map<String, String> parameters) {
		OAuthService service = new ServiceBuilder().provider(OpenPhotoAPI.class).apiKey(consumerKey)
				.apiSecret(consumerSecret).build();
		Token accessToken = new Token(token, tokenSecret);
		OAuthRequest request = new OAuthRequest(Verb.GET, host + endpoint);
		service.signRequest(accessToken, request);

		if (parameters != null) {
			for (Entry<String, String> parameter : parameters.entrySet()) {
				request.addBodyParameter(parameter.getKey(), parameter.getValue());
			}
		}

		Response response = request.send();
		return response.getBody();
	}

	private boolean checkConfigurationProperties() {
		if ((ConfigurationProperties.CONSUMER_KEY != null && ConfigurationProperties.CONSUMER_KEY.length() > 0)
				&& (ConfigurationProperties.CONSUMER_SECRET != null && ConfigurationProperties.CONSUMER_KEY.length() > 0)
				&& (ConfigurationProperties.TOKEN != null && ConfigurationProperties.CONSUMER_KEY.length() > 0)
				&& (ConfigurationProperties.TOKEN_SECRET != null && ConfigurationProperties.CONSUMER_KEY.length() > 0))
			return true;

		return false;
	}
}
