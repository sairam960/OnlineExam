package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Exam;
import com.lti.service.StudentReportService;

@RestController
@CrossOrigin
public class StudentReportController {
	
	@Autowired
	private StudentReportService studentReportService;
		
	@GetMapping("/studentReport")
    public List<Exam> generateReport(@RequestParam("id") int id ){
		
		List<Exam> exam = studentReportService.getStudentReport(id);
		return exam;
	}
}