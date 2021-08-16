package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Exam;
import com.lti.entity.User;
//import com.lti.exception.UserServiceException;
import com.lti.repository.AdminReportRepository;

@Service
@Transactional
public class AdminReportService {

	@Autowired
	private AdminReportRepository adminReportRepository;
	
	public List<User> getAdminReport(String subject_name, String city, String state, int level) {
		
		List<User> list = adminReportRepository.fetchAdminReport(subject_name, city, state, level);
		if(list.isEmpty()) {
			//throw new UserServiceException("No Such Records Present");
			return null;
		} else {
		//list.forEach(l -> System.out.println(l));
			return list;
		}
	}
	
	public List<Exam> getExamDetail(String subject_name, String city, String state, int level) {
		
		List<Exam> list = adminReportRepository.getExamDetails(subject_name, city, state, level);
		if(list.isEmpty()) {
			//throw new UserServiceException("No Such Records Present");
			return null;
		} else {
		//list.forEach(l -> System.out.println(l));
			return list;
		}
	}
}
