/**
 * twitterzy-navin-2018
 * 
 * https://github.com/navinprasath18/twitterzy
 */
package com.twitterzy.backend.services;

import java.util.HashMap;
import java.util.Set;

import org.apache.http.client.methods.HttpGet;
import org.springframework.stereotype.Service;

import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.twitterzy.backend.constants.TwitterzyService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FollowerInfoService extends TwitterzyService {

	public JsonElement getFollowers(String screen_name) {

		HttpGet request = new HttpGet(twitterAPI.getFollowersList + "&screen_name=" + screen_name + "&count" + count);
		JsonElement json = requestService.get(request);
		log.debug("Followers list of" + screen_name);
		log.info(json.toString());
		return json;

	}

	public JsonElement getFollowing(String screen_name) {
		HttpGet request = new HttpGet(twitterAPI.getFollowingList + "&screen_name=" + screen_name + "&count" + count);
		JsonElement json = requestService.get(request);
		log.debug("Following list of" + screen_name);
		log.info(json.toString());
		return json;

	}

	public HashMap<String, String> countNonFollowers(String screen_name) {

		HashMap<String, String> response = new HashMap<>();
		response.put("who", screen_name);
		// get_list_via_api
		JsonElement followersIDs = getFollowers(screen_name);
		JsonElement followingIDs = getFollowing(screen_name);

		// get as array of IDs
		JsonArray followers = (JsonArray) followersIDs.getAsJsonObject().get("ids");
		JsonArray following = (JsonArray) followingIDs.getAsJsonObject().get("ids");

		response.put("followers", String.valueOf(followers.size()));
		response.put("following", String.valueOf(following.size()));
		log.debug(followersIDs.toString());

		// sets
		Set<JsonElement> followersSet = Sets.newHashSet(followers);
		Set<JsonElement> followingSet = Sets.newHashSet(following);

		// intersection
		Set<JsonElement> intersection = Sets.intersection(followersSet, followingSet);
		response.put("Follow_each_other", String.valueOf(intersection.size()));

		// union
		Set<JsonElement> uniquePeopleAssociated = Sets.union(followersSet, followingSet);
		response.put("uniquePeopleAssociated", String.valueOf(uniquePeopleAssociated.size()));

		// notFollowingYouBack
		Set<JsonElement> notFollowingYouBack = followingSet;
		notFollowingYouBack.removeAll(followersSet);
		response.put("notFollowingYouBack", String.valueOf(notFollowingYouBack.size()));

		// youDontFollowBack
		Set<JsonElement> youDontFollowBack = followersSet;
		youDontFollowBack.removeAll(followingSet);
		response.put("youDontFollowBack", String.valueOf(youDontFollowBack.size()));

		return response;
	}
}
