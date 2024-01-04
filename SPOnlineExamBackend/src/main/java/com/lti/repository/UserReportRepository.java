package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.lti.entity.Exam;

@Repository
public class UserReportRepository {
	

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Exam> fetchUserReport(int userId) {
		
		@SuppressWarnings("unchecked")
		List<Exam> resultList = (List<Exam>)
				entityManager.
				createQuery("SELECT distinct e FROM Exam e JOIN  e.user u WHERE u.userId = :id")
				.setParameter("id",userId)
				.getResultList();
		return resultList;

       }
}
