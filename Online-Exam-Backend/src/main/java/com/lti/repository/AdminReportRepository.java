package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.Exam;
import com.lti.entity.User;

@Repository
public class AdminReportRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<User> fetchAdminReport(String subject_name, String city, String state, int level) {
		
		@SuppressWarnings("unchecked")
		List<User> resultList = ((List<User>)
				entityManager.
				createQuery("SELECT u FROM Exam e JOIN e.user u JOIN e.subject s WHERE s.name = :subjectName AND u.city = :city AND u.state = :state AND e.level = :lev")
				.setParameter("subjectName", subject_name)
				.setParameter("city", city)
				.setParameter("state", state)
				.setParameter("lev", level)
				.getResultList());
		return resultList;

	}
	

	
	public List<Exam> getExamDetails(String subject_name, String city, String state, int level) {
		
		@SuppressWarnings("unchecked")
		List<Exam> resultList = ((List<Exam>)
				entityManager.
				createQuery("SELECT e FROM Exam e JOIN e.user u JOIN e.subject s WHERE s.name = :subname AND u.city = :ci AND u.state = :st AND e.level = :le")
				.setParameter("subname", subject_name)
				.setParameter("ci", city)
				.setParameter("st", state)
				.setParameter("le", level)
				.getResultList());
		return resultList;
	}
	
	
	

}
