package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lti.entity.Exam;
import com.lti.repository.UserReportRepository;

@Service
@Transactional
public class UserReportService {
	
		@Autowired
		private UserReportRepository userReportRepository;
		
				
		public List<Exam> getUserReport(int userId) {
			
			List<Exam> exam =  userReportRepository.fetchUserReport(userId);
			return exam;
      }
 }



