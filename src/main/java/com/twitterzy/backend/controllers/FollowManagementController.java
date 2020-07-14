
/**
 * twitterzy-navin-2018
 * 
 * https://github.com/navinprasath18/twitterzy
 */
package com.twitterzy.backend.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.twitterzy.backend.constants.TwitterzyController;
import com.twitterzy.backend.services.FollowerInfoService;

@RestController
@RequestMapping("/follower")
@JsonPropertyOrder({ "who" })
public class FollowManagementController extends TwitterzyController {
	@Autowired
	private FollowerInfoService FollowerInfoService;

	@GetMapping("/countNonFollowers")
	public HashMap<String, String> getNotFollowBack(@RequestParam("username") String username) {
		return FollowerInfoService.countNonFollowers(username);
	}

}
