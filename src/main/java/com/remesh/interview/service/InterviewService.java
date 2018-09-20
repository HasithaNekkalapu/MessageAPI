package com.remesh.interview.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remesh.interview.dto.Messages;
import com.remesh.interview.dto.QueryParam;
import com.remesh.interview.dto.Users;
import com.remesh.interview.dto.Votes;
import com.remesh.interview.util.UsersPredicates;

@Service
public class InterviewService {

	@Autowired
	RestTemplateService restTemplateService;

	public List<Messages> filterMessages(QueryParam queryParam) {

		List<Users> usersList = restTemplateService.getUsers();
		List<Votes> votesList = restTemplateService.getVotes();
		List<Messages> messagesList = restTemplateService.getMessages();
		List<Messages> filteredMessages = new ArrayList<>();

		List<Users> filteredList = usersList.stream().filter(UsersPredicates.createUsersPredicate(queryParam))
				.collect(Collectors.toList());

		List<Votes> filteredVotesList = votesList.stream()
				.filter(x -> filteredList.stream().map(Users::getId).anyMatch(id -> x.getUserId() == id))
				.collect(Collectors.toList());

		for (Votes v : filteredVotesList) {

			filteredMessages.addAll(messagesList.stream()
					.filter(x -> x.getId() == v.getMessageId() && x.getQuestionId() == v.getQuestionId())
					.collect(Collectors.toList()));
		}
		return filteredMessages;
	}
}
