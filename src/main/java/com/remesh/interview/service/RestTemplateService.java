package com.remesh.interview.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.remesh.interview.dto.Messages;
import com.remesh.interview.dto.Users;
import com.remesh.interview.dto.Votes;

@Service
public class RestTemplateService {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Autowired
	RestTemplate restTemplate;

	@Value("${baseUrl}")
	private String baseUrl;

	public List<Users> getUsers() {

		String usersUrl = baseUrl + "users";
		ResponseEntity<List<Users>> response = restTemplate.exchange(usersUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Users>>() {
				});

		return response.getBody();
	}

	public List<Votes> getVotes() {

		String votesUrl = baseUrl + "votes";
		ResponseEntity<List<Votes>> response = restTemplate.exchange(votesUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Votes>>() {
				});

		return response.getBody();
	}

	public List<Messages> getMessages() {

		String messagesUrl = baseUrl + "messages";
		ResponseEntity<List<Messages>> response = restTemplate.exchange(messagesUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Messages>>() {
				});

		return response.getBody();
	}
}
