package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import com.lti.entity.Question;
import com.lti.entity.Subject;
import com.lti.service.AdminService;
import com.lti.service.QuestionService;

@RestController
@CrossOrigin
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	//@Autowired
	//private AdminService adminService;
	private LocalDateTime startTime;
	
	@PostMapping("/questions")
	public List<Question> questions(@RequestBody Subject subject) {
		
		startTime = LocalDateTime.now();
		try {
			//int id= adminService.fetchSubjectId(subject.getName());
			//System.out.println(id+subject.getName());
			List<Question> list = questionService.fetchQuestions(subject.getSubjectId(),1);
			System.out.println(list);
			return list;
		}
		catch(Exception e)
		{
			return null;
		}	
		
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	
	
}
