package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.Questions;
import com.lti.repository.QuestionsRepository;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired 
	QuestionsRepository quesrepo;

	@Override
	public boolean addQuestions(Questions questions) {
		quesrepo.save(questions);
		return true;
	}

	@Override
	public List<Questions> getQuestions() {
		return quesrepo.findAll();
	}
	
	//delete not working
	@Override
	public boolean deleteQuestion(Questions questions) {
		quesrepo.delete(questions);
		return true;
	}

}
