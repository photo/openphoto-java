Open Photo API / Java Library
=======================
#### OpenPhoto, a photo service for the masses

----------------------------------------

### How to use the library

To use the library you need to first include openphoto.jar in your project, then instantiate the class OpenPhotoClient and start making calls.
    
    OpenPhotoClient client = new OpenPhotoClient(host, consumerKey, consumerSecret, token, tokenSecret);
 
 	// it will get a list of objects 
    String result = client.rawGet("/photos/list.json", null);
    
## System PROPERTIES

	# env.sh
	export host=your_host
	export consumerKey=your_consumer_key
	export consumerSecret=your_consumer_secret
	export token=your_access_token
	export tokenSecret=your_access_token_secret    

----------------------------------------
### JUnit Test

You can test the client with JUnit.
First, set the details on ConfigurationProperties.java.
You can start the client also like that:
	
	// first checks if the parameters are defined as system properties
	// otherwise look inside ConfigurationProperties
	OpenPhotoClient client = new OpenPhotoClient();	

     host = your_host
     consumerKey=your_consumer_key
     consumerSecret=your_consumer_secret
     token=your_access_token
     tokenSecret=your_access_token_secret

#### Getting your credentials

You can get your credentals by clicking on the arrow next to your email address once you're logged into your site and then clicking on settings.
If you don't have any credentials then you can create one for yourself by going to `/v1/oauth/flow`.
Once completed go back to the settings page and you should see the credential you just created