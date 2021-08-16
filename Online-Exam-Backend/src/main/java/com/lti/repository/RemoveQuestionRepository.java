package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.Question;

@Repository
public class RemoveQuestionRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Question> fetchQuestionsBySubjectName(String subjectName) {
		
		@SuppressWarnings("unchecked")
		List<Question> list = (List<Question>)
								entityManager
								.createQuery("SELECT q FROM Question q JOIN q.subject s WHERE s.name = :subname")
								.setParameter("subname", subjectName)
								.getResultList();
		return list;
	}
	
	public boolean deleteQuestionsFromDb(int questionId) {
		
		return entityManager
				.createQuery("UPDATE Question q SET q.status = :stat WHERE q.questionId = :id")
				.setParameter("stat", "Inactive")
				.setParameter("id", questionId)
				.executeUpdate() == 1 ? true:false;
	}

}
