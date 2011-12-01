package me.openphoto.client.util;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class OpenPhotoAPI extends DefaultApi10a {

	@Override
	public String getAccessTokenEndpoint() {
		throw new NotImplementedException();
	}

	@Override
	public String getAuthorizationUrl(Token arg0) {
		throw new NotImplementedException();
	}

	@Override
	public String getRequestTokenEndpoint() {
		throw new NotImplementedException();
	}
}
