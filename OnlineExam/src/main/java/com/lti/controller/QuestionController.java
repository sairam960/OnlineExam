package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Questions;
import com.lti.service.QuestionService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/questiondata/api")
public class QuestionController {
	
	@Autowired
	QuestionService quesService;
	
	@GetMapping("/add")
	public List<Questions> getAll()
	{
		return quesService.getQuestions();
	}
	
	@PostMapping("/add")
	public boolean addQues(@RequestBody Questions questions)
	{
		return quesService.addQuestions(questions);
	}
	
	@DeleteMapping("/add")
	public boolean delete(Questions questions)
	{
		return quesService.deleteQuestion(questions);
	}

}
