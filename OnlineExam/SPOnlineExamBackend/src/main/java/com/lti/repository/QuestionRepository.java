package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.Question;
import com.lti.entity.Subject;

@Repository
public class QuestionRepository  {
	
	@PersistenceContext
	private EntityManager entityManager;

	public boolean isQuestionPresent(String question) {
		return (Long)
				entityManager
				.createQuery("select count(q.question) from Question q where q.question=:question")
				.setParameter("question", question)
				.getSingleResult()==1 ? true:false;
	}
	public int getSubjectId(String subjectName) {
		
		subjectName=subjectName.toLowerCase();
		int id=(int) entityManager
				.createQuery("select subject.subjectId from Subject subject where lower(subject.name)=: subjectName ")
				.setParameter("subjectName", subjectName)
				.getSingleResult();
	
		return id;
	}
	public boolean isValidSubject(String subject){ 
		subject=subject.toLowerCase();
		return (Long) 
				entityManager
				.createQuery("select count(subject.subjectId) from Subject subject where lower(subject.name) =: subject")
				.setParameter("subject", subject)
				.getSingleResult()==1 ? true :false;
	}
	
	public Object save(Object obj) {
		Object updatedObj = entityManager.merge(obj);
		return updatedObj;
	}
	
	public List<Question> fetchQuestion(int id,int level){
		@SuppressWarnings("unchecked")
		List<Question> list=
				 (List<Question>) entityManager
						.createQuery("select q from Question q where q.subject.subjectId =: id and q.level =: l and lower(q.status) =: status")
						.setParameter("id",id)
						.setParameter("l",level)
						.setParameter("status","active")
						.getResultList();
		return list;
	}
}
