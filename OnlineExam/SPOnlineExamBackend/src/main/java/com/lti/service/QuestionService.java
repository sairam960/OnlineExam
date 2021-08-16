package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Question;
import com.lti.repository.QuestionRepository;

@Service
@Transactional
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;

	public List<Question> fetchQuestions(int id,int level)
	{
		try
		{
			List<Question> list = questionRepository.fetchQuestion(id,level);
			System.out.println(list);
			return  list;
			
		}
		catch(Exception e)
		{	
			e.printStackTrace();
			System.out.println("Question not found");
			return null;
		}
	}
}
