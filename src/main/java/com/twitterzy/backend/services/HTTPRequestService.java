package com.twitterzy.backend.services;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HTTPRequestService {
	private final CloseableHttpClient httpClient = HttpClients.createDefault();

	public JSONObject get(HttpGet request) {

		try (CloseableHttpResponse response = httpClient.execute(request)) {

			// Get HttpResponse Status
			log.debug(response.getStatusLine().toString());

			HttpEntity entity = response.getEntity();
			Header headers = entity.getContentType();
			System.out.println(headers);

			if (entity != null) {
				// return it as a String
				String result = EntityUtils.toString(entity);
				log.debug(result);
			}
		JSONObject json = new JSONObject(response);
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
