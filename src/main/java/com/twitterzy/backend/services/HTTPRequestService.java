/**
 * twitterzy-navin-2018
 * 
 * https://github.com/navinprasath18/twitterzy
 */
package com.twitterzy.backend.services;

import java.io.IOException;

import org.apache.http.HttpHeaders;
import org.apache.http.ParseException;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.twitterzy.backend.authorizationProvider.OauthService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HTTPRequestService {
	OauthService oauthService = OauthService.getInstance();
	private final CloseableHttpClient httpClient = HttpClients.custom()
			.setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build()).build();
	JsonParser parser = new JsonParser();

	public JsonElement get(HttpGet request) {

		request.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + oauthService.getToken());
		try (CloseableHttpResponse response = httpClient.execute(request)) {
			String json_string = EntityUtils.toString(response.getEntity());
			JsonElement json = parser.parse(json_string);
			return json;
		} catch (ParseException | IOException e) {
			log.debug("GET request failed with" + e.getMessage());

		}
		return null;

	}

	public void post(HttpPost request) {

		// s HttpPost post = new HttpPost(URL);

		// add request parameter, form parameters
		// List<NameValuePair> urlParameters = new ArrayList<>();
		// urlParameters.add(new BasicNameValuePair("username", "abc"));
		// urlParameters.add(new BasicNameValuePair("password", "123"));
		// urlParameters.add(new BasicNameValuePair("custom", "secret"));

		// post.setEntity(new UrlEncodedFormEntity(urlParameters));

		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(request)) {

			log.debug(EntityUtils.toString(response.getEntity()));
		} catch (ParseException | IOException e) {
			log.debug("POST request failed with" + e.getMessage());
		}

	}

}
