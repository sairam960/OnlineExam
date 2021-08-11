package com.lti.service;

import java.util.List;

import com.lti.model.Questions;

public interface QuestionService {
	
	public boolean addQuestions(Questions questions);
	
	public List<Questions> getQuestions();
	
	public boolean deleteQuestion(Questions questions);

}
