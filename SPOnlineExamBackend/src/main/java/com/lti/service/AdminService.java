package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Question;
import com.lti.entity.Subject;
import com.lti.exception.AdminServiceException;
import com.lti.exception.UserServiceException;
import com.lti.repository.QuestionRepository;


@Service
@Transactional
public class AdminService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public int addquestion(Question question) {
		if(questionRepository.isQuestionPresent(question.getQuestion())) {
			throw new AdminServiceException("Question already Exists!!");
		}
			
		else{
			
			String subjectName=question.getSubject().getName();
			//System.out.println(subjectName);
			int subjectId=fetchSubjectId(subjectName);
		
			Subject subject=new Subject();
			subject.setSubjectId(subjectId);
			subject.setName(question.getSubject().getName());
			
			question.setQuestion(question.getQuestion());
			question.setOption1(question.getOption1());
			question.setOption2(question.getOption2());
			question.setOption3(question.getOption3());
			question.setOption4(question.getOption4());
			question.setAnswer(question.getAnswer());
			question.setStatus("Active");
			question.setSubject(subject);
			question.setLevel(question.getLevel());
			
			
			Question newQuestion=(Question) questionRepository.save(question);
			
			return newQuestion.getQuestionId();
		}
	} 
	
	public int fetchSubjectId(String subjectName) {
		
		if(questionRepository.isValidSubject(subjectName)) {
		
			int subjectId=questionRepository.getSubjectId(subjectName);
			
			return subjectId;	
		}
		else {
			
			throw new AdminServiceException("Choose the correct Subject");
				
		}
		
	}

}
