package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Question;
import com.lti.service.RemoveQuestionService;

@RestController
@CrossOrigin
public class RemoveQuestionController {
	
	@Autowired
	private RemoveQuestionService removeQuestionService;
	
	@GetMapping("/removeQuestions")
	public List<Question> generateQuestionsBySubjectName(@RequestParam("subjectName") String subjectName) {
		
		List<Question> list = removeQuestionService.getQuestions(subjectName);
		return list;
	}
	
	@GetMapping("/deleteQuestions")
	public String deleteQuestionByQuestionId(@RequestParam("questionId") int questionId) {
		return removeQuestionService.deleteQuestion(questionId);
	}

}
