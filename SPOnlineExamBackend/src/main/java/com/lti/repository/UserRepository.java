package com.lti.repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public boolean isUserPresent(String email){
    	return (Long)					
				entityManager
				.createQuery("select count(u.userId) from User u where u.emailId =:em")
				.setParameter("em",email)
				.getSingleResult() == 1 ? true:false;
	}
	
	public Object save(Object obj) {
		Object updatedObj = entityManager.merge(obj);
		return updatedObj;
	}
	
	public int fetchIdByEmailAndPassword(String email,String password) {
		
		return (Integer)
				entityManager
				.createQuery("select user.userId from User user where user.emailId=: em and user.password =: pw")
				.setParameter("em",email)
				.setParameter("pw", password)
				.getSingleResult();
	}
	
	public <E> E fetch(Class<E> cl, Object pk) {
		E e = entityManager.find(cl, pk);
		return e;
	}
	
//	public String fetchByEmail(String email) {
//		return (String)
//				entityManager
//				.createQuery("select user.password from User user where user.emailId=: em")
//				.setParameter("em",email)
//				.getSingleResult();
//	}	


}
