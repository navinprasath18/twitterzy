package com.twitterzy.backend.configuration;

import org.springframework.stereotype.Component;

@Component
public class TwitterAPIs {

	public final String protocol = "https://";
	public final String domain = "/api.twitter.com";
	public final String apiVersion = "/1.1";

	public final String getFollowersList = protocol + domain + apiVersion + "/followers/ids.json";

}
