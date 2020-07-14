/**
 * twitterzy-navin-2018
 * 
 * https://github.com/navinprasath18/twitterzy
 */
package com.twitterzy.backend.constants;

import org.springframework.beans.factory.annotation.Autowired;

import com.twitterzy.backend.configuration.RequestURL;

public abstract class TwitterzyController {
	
	
	@Autowired
	public RequestURL requestURL;

}
