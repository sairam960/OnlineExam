package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Exam;
import com.lti.service.UserReportService;

@RestController
@CrossOrigin
public class UserReportController {
	
	@Autowired
	private UserReportService userReportService;
		
	@GetMapping("/userReport")
    public List<Exam> generateReport(@RequestParam("id") int id ){
		
		List<Exam> exam = userReportService.getUserReport(id);
		return exam;
	}
}
