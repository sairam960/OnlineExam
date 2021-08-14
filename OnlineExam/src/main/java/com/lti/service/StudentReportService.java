package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lti.model.Exam;
import com.lti.repository.StudentReportRepository;

@Service
@Transactional
public class StudentReportService {
	
		@Autowired
		private StudentReportRepository studentReportRepository;
		
				
		public List<Exam> getStudentReport(int studentId) {
			
			List<Exam> exam =  studentReportRepository.fetchStudentReport(studentId);
			return exam;
		}
}