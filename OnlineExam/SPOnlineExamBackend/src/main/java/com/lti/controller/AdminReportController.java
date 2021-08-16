package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Exam;
import com.lti.entity.User;
import com.lti.service.AdminReportService;

@RestController
@CrossOrigin
public class AdminReportController {

	@Autowired
	private AdminReportService adminReportService;
	
	@GetMapping("/adminReport")
	public List<User> generateReport(@RequestParam("subject_name") String subject_name, @RequestParam("city") String city, @RequestParam("state") String state, @RequestParam("level") int level ){
		
		List<User> list = adminReportService.getAdminReport(subject_name, city, state, level);
		return list;
	}
	
	@GetMapping("/examDetailsReport")
	public List<Exam> generateExamDetails(@RequestParam("subject_name") String subject_name, @RequestParam("city") String city, @RequestParam("state") String state, @RequestParam("level") int level ){
		
		List<Exam> list = adminReportService.getExamDetail(subject_name, city, state, level);
		return list;
	}
}
