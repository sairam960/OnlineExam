package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.User;
import com.lti.exception.UserServiceException;
import com.lti.repository.UserRepository;

@Service
@Transactional 
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public int register(User user){

		if(userRepository.isUserPresent(user.getEmailId()))
			throw new UserServiceException("User already registerted");
		else {
				User updatedUser = (User) 
				userRepository.save(user);
				return updatedUser.getUserId();
			}
		
	}
	
	public User login(String emailId,String password) {
		try {
			
			int id=userRepository.fetchIdByEmailAndPassword(emailId, password);
			User user=userRepository.fetch(User.class,id);
			return user;
		}
		catch(EmptyResultDataAccessException e) {
			throw new UserServiceException("Invalid Email/Password");
		}
	}


}
