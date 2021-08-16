package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Question;
import com.lti.repository.RemoveQuestionRepository;

@Service
@Transactional
public class RemoveQuestionService {
	
	@Autowired
	private RemoveQuestionRepository removeQuestionRepository;
	
	public List<Question> getQuestions(String subjectName) {
		
		List<Question> list = removeQuestionRepository.fetchQuestionsBySubjectName(subjectName);
		return list;
	}
	
	public String deleteQuestion(int questionId) {
		
		if(removeQuestionRepository.deleteQuestionsFromDb(questionId)) {
			return "Question deleted";
		} else {
			return "Question not deleted";
		}
	}

}
