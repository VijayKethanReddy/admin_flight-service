package com.hnt;

import java.net.URI;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hnt.entity.Flight;

public class RestClient {

	private static final String URL = "http://localhost:8080/user";

	public static void main(String[] args) {
//		get();
		post();
	}

	private static void post() {
		Flight user = new Flight();
		user.setFlightId(1001);
//		user.setName("Shivani");
		RestTemplate restTemplate =  new RestTemplate();
		 Object response = restTemplate.postForObject(URL, user, Integer.class, new HashMap());
		System.out.println(response);
	}

	private static void get() {
		RestTemplate restTemplate =  new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
		System.out.println(response.getStatusCodeValue());
		System.out.println(response.getBody());
	}
}
