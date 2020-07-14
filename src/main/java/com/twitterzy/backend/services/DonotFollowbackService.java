package com.twitterzy.backend.services;

import org.apache.http.client.methods.HttpGet;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.twitterzy.backend.constants.TwitterzyService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DonotFollowbackService extends TwitterzyService {

	private void getFollowers(String screen_name) {
		HttpGet request = new HttpGet(twitterAPI.getFollowersList + "cursor=-1&screen_name=" + screen_name);
		JSONObject json = requestService.get(request);
		log.info(json.toString());
	}

	private void getFollowing(String screen_name) {
		HttpGet request = new HttpGet(twitterAPI.getFollowersList + "cursor=-1&screen_name=" + screen_name);
		JSONObject json = requestService.get(request);
		log.info(json.toString());
	}
}
