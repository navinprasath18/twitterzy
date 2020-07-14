/**
 * twitterzy-navin-2018
 * 
 * https://github.com/navinprasath18/twitterzy
 */
package com.twitterzy.backend.authorizationProvider;

public class OauthService {

	private OauthService() {

	}

	private static OauthService instance = null;

	public static OauthService getInstance() {
		if (instance == null)
			instance = new OauthService();
		return instance;
	}

	public String getToken() {
		return "AAAAAAAAAAAAAAAAAAAAADwCGAEAAAAAYQ3wr1OMMU7r03E929M0RgRl%2BrU%3DRvwsLIJNwtxmTuMS6qH9mKB8Wwzt4Vij5AMv5wZNrz9TWHq3RY";

	}
}
