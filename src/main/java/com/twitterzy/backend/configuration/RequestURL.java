/**
 * twitterzy-navin-2018
 * 
 * https://github.com/navinprasath18/twitterzy
 */
package com.twitterzy.backend.configuration;

import org.springframework.stereotype.Component;

@Component
public class RequestURL {

	public final String follower = "/follower";
	public final String WhoNotFollowingBack = "/WhoNotFollowingBack";
	public final String IdoNotFollowBack = "/IdoNotFollowBack";

}
