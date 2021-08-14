package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.Subject;
import com.lti.model.Questions;
import com.lti.repository.QuestionsRepository;
import com.lti.repository.SubjectRepository;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired 
	QuestionsRepository quesrepo;
	
	@Autowired
	SubjectRepository subrepo;

	@Override
	public boolean addQuestions(Questions questions) {
		String subjectName="Java";
				//questions.getSubject().getSubjectName();
		int subjectId=101;
		//questions.getSubject().getSubjectId();
		//int subjectId=QuestionsRepository.getSubjectId(subjectName);
		
		System.out.println(subjectName);
	
		Subject subject=new Subject();
		subject.setSubjectId(subjectId);
		subject.setSubjectName(subjectName);
		questions.setSubject(subject);
		quesrepo.save(questions);
		subrepo.save(subject);
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
