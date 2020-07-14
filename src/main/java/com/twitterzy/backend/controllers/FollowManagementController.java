package com.twitterzy.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitterzy.backend.constants.TwitterzyController;

@RestController
@RequestMapping("/follower")
public class FollowManagementController extends TwitterzyController {

	@GetMapping("/WhoNotFollowingBack")
	public void getNotFollowBack() {

	}

}
