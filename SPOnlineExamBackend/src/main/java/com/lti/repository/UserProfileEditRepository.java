package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class UserProfileEditRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public boolean updateName(int id, String name) {
		
		return entityManager
				.createQuery("UPDATE User u SET u.name = :na WHERE u.userId = :id")
				.setParameter("na", name)
				.setParameter("id", id)
				.executeUpdate() == 1 ? true:false;
	}
	
	public boolean updateEmail(int id, String email) {
		
		return entityManager
				.createQuery("UPDATE User u SET u.emailId = :mail WHERE u.userId = :id")
				.setParameter("mail", email)
				.setParameter("id", id)
				.executeUpdate() == 1 ? true:false;
	}
	
	public boolean updateQualification(int id, String qualification) {
		
		return entityManager
				.createQuery("UPDATE User u SET u.qualification = :qual WHERE u.userId = :id")
				.setParameter("qual", qualification)
				.setParameter("id", id)
				.executeUpdate() == 1 ? true:false;
	}

}
