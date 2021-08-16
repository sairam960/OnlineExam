package com.lti.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AddQuestionStatus;
import com.lti.dto.AdminLogin;
import com.lti.dto.AdminLoginStatus;
import com.lti.dto.Status;
import com.lti.entity.Question;
import com.lti.entity.Subject;
import com.lti.exception.AdminServiceException;
import com.lti.exception.UserServiceException;
import com.lti.service.AdminService;

@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/adminLogin")
	public AdminLoginStatus adminlogin(@RequestBody AdminLogin login) {
		try {
			
			String ademail = adminService.adminLogin(login.getEmail(), login.getPassword());
			
			AdminLoginStatus loginStatus = new AdminLoginStatus();
			loginStatus.setStatus(true);
			loginStatus.setMessage("Login successful!");
			loginStatus.setName("Admin");
			loginStatus.setEmail(ademail);
			return loginStatus;
		}
		catch(UserServiceException e) {
			
			AdminLoginStatus loginStatus = new AdminLoginStatus();
			loginStatus.setStatus(false);
			loginStatus.setMessage(e.getMessage());		
			return loginStatus;
		}
	}
	
	@PostMapping("/addQuestion")
	public AddQuestionStatus addquestion(@RequestBody Question question) {
		try {
			int id=adminService.addquestion(question);
			AddQuestionStatus status=new AddQuestionStatus();
			status.setStatus(true);
			status.setMessage("Question Added Successfully");
			status.setQuestionId(id);
			status.setQuestion(question.getQuestion());
			
			return status;
		}
		catch(AdminServiceException e) {
			e.printStackTrace();
			AddQuestionStatus status=new AddQuestionStatus();
			status.setStatus(false);
			status.setMessage("Question Not added successfully");
			
			return status;
		}
	}
	
	/*@PostMapping("/getSubjectId")
	public Status getSubject(@RequestBody Subject subject) {
		try {
			System.out.println(subject.getName());
			int id=adminService.fetchSubjectId(subject.getName());
			Status status=new Status();
			status.setStatus(true);
			status.setMessage("id fetched is "+id);
			return status;
		}
		catch(AdminServiceException e) {
			e.printStackTrace();
			Status status=new Status();
			status.setStatus(false);
			status.setMessage("No subject found in table");
			return status;
		}
	}*/

}
