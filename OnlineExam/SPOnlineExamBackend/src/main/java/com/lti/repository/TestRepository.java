package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import com.lti.entity.Subject;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<Subject> fetchSubject(){
		List<Subject> list= 
				entityManager
				.createQuery("Select subject from Subject subject")
				.getResultList();
		
		return list;
	}
	
	//TODO:Pass user ID
	public boolean userPresent(int id) {
		return (Long)
				entityManager
				.createQuery("select count(e.examId) from Exam e where e.question.questionId =: id ")
				.setParameter("id",id)
				.getSingleResult()==1 ?true:false;
	}
	
	
	public String getSubjectName(int id) {
		String subjectName=(String)
					entityManager
					.createQuery("select s.name from Subject s join s.exams where e.user.userId=:id")
					.setParameter("id", id)
					.getSingleResult();
		return subjectName;
	}
	
	public boolean responsePresent(int questionId,int examId) {
		return (Long)
				entityManager
				.createQuery("select count(response.responseId) from Response response where response.question.questionId=:questionId and response.exam.examId=:examId")
				.setParameter("questionId", questionId)
				.setParameter("examId", examId)
				.getSingleResult()==1?true:false;
	}
	
	public Object save(Object obj) {
		Object updatedObj = entityManager.merge(obj);
		return updatedObj;
	}
	
	public int getTestReport(int examId) {
		int marks=
				(int) entityManager
		.createQuery("select e.marks from Exam e where e.examId=:id")
		.setParameter("id", examId)
		.getSingleResult();
		
		return marks;
	}
}
