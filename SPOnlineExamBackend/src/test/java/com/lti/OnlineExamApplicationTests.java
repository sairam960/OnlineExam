package com.lti;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.entity.User;
import com.lti.service.UserService;


@SpringBootTest
class OnlineExamApplicationTests {

	@Test
	public void testCase1() {
		
	}
	
	@Autowired
	UserService uservice;
	
	void testAddUser() {
		 
		User user = new User();
		user.setUserId(201);
		user.setName("Akshay Mishra");
		user.setEmailId("akshay@gmail.com");
		user.setPassword("Akshay@123");
		
	}
	
	
}
