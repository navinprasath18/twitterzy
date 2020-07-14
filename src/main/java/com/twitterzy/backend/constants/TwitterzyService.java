package com.twitterzy.backend.constants;

import org.springframework.beans.factory.annotation.Autowired;

import com.twitterzy.backend.configuration.TwitterAPIs;
import com.twitterzy.backend.services.HTTPRequestService;

public abstract class TwitterzyService {

	@Autowired
	public HTTPRequestService requestService;

	@Autowired
	public TwitterAPIs twitterAPI;

}
