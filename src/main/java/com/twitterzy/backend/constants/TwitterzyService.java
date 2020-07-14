/**
 * twitterzy-navin-2018
 * 
 * https://github.com/navinprasath18/twitterzy
 */
package com.twitterzy.backend.constants;

import org.springframework.beans.factory.annotation.Autowired;

import com.twitterzy.backend.configuration.TwitterAPIs;
import com.twitterzy.backend.services.HTTPRequestService;

public abstract class TwitterzyService {

	@Autowired
	protected HTTPRequestService requestService;

	@Autowired
	protected TwitterAPIs twitterAPI;
	
	protected int count = 5000;

}
