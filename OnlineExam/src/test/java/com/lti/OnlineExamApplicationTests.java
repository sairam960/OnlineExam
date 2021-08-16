package com.lti;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.model.StudentData;
import com.lti.service.StudentServiceImpl;

@SpringBootTest
class OnlineExamApplicationTests {
	
	@Autowired
	StudentServiceImpl studentService;
	
	@Test
	void testAddProdeuc() {
		StudentData st = new StudentData();
		st.setStudentid(201);
		st.setName("Aman");
		st.setEmail("ak@gmail.com");
		st.setPassword("Aman@123");
		
		boolean res = studentService.addStudent(st);
		assertEquals(true, res);
		
	}
	
	@Test
	void contextLoads() {
	}
	
	
	
	
}
