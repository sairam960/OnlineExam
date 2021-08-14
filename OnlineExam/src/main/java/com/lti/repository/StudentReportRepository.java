package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.lti.model.Exam;

@Repository
public class StudentReportRepository extends GenericRepository {
	

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Exam> fetchStudentReport(int studentId) {
		
		List<Exam> resultList = (List<Exam>)
	entityManager.createQuery("SELECT distinct e FROM Exam e JOIN  e.student s WHERE s.studentId = :id").setParameter("id",studentId).getResultList();
		return resultList;

       }
}