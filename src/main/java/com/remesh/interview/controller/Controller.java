package com.remesh.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.remesh.interview.dto.Messages;
import com.remesh.interview.dto.QueryParam;
import com.remesh.interview.service.InterviewService;
import com.remesh.interview.util.Utils;

@RestController
@RequestMapping("/")
public class Controller {

	@Autowired
	InterviewService interviewService;

	@GetMapping("filterUsers")
	public List<Messages> filterUsers(@RequestParam(name = "incomeRange", required = false) String incomeRange,
			@RequestParam(name = "Age", required = false) String age,
			@RequestParam(name = "sex", required = false) String sex,
			@RequestParam(name = "livingEnvironment", required = false) String livingEnvironment) {

		try {
			QueryParam queryParam = Utils.formQueryParamObject(incomeRange, age, sex, livingEnvironment);
			return interviewService.filterMessages(queryParam);
		} catch (Exception e) {
			return null;
		}
	}
}
