package com.lti.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.StudentData;
import com.lti.service.StudentService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/studentdata/api")
public class StudentController {
	
	@Autowired
	StudentService studser;
	
	@GetMapping("/students")
	public List<StudentData> getAll(){
		return studser.getStudents();
		
	}
	
	@PostMapping("/students")
	public boolean addStudent(@RequestBody StudentData student,@PathVariable("date") String dateb) throws Exception {      		//Add date of birth as path variable
		
		String tempEmail = student.getEmail();
		if(tempEmail != null && !"".equals(tempEmail)) {
			StudentData studobj1 = studser.fetchStudentByEmail(tempEmail);
			if (studobj1 != null) {
				throw new Exception("Student with "+tempEmail+" already exists try Logging in!");
			}
		}
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		//LocalDateTime newdate=LocalDateTime.
		System.out.println("Dob in controller is student "+ student.getDateOfBirth());
		return studser.addStudent(student);
	}
	
	@PostMapping("/studentlogin")
	public StudentData loginStudent(@RequestBody StudentData student) throws Exception {
		
		String tempEmail = student.getEmail();
		String tempPass = student.getPassword();
		StudentData studobj2 = null;
		if(tempEmail != null && tempPass != null) {
			studobj2 = studser.fetchStudentByEmailAndPassword(tempEmail, tempPass);
		}
		if (studobj2 == null) {
			throw new Exception("Student does not Exist, Please Register first!");
		}
		return studobj2;
		
	}
	
}







