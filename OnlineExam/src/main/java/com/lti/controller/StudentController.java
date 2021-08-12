package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	public boolean addStudent(@RequestBody StudentData student) {
		return studser.addStudent(student);
		
	}
	

}






