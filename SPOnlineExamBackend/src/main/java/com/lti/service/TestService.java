package com.lti.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.controller.QuestionController;
import com.lti.entity.Exam;
import com.lti.entity.Question;
import com.lti.entity.Response;
import com.lti.entity.Subject;
import com.lti.exception.UserServiceException;
import com.lti.repository.TestRepository;

@Service
@Transactional
public class TestService {
	
	@Autowired 
	private TestRepository testRepository;
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private QuestionController questionController;
	
	//Fetch Subjects
	public List<Subject> get() {
		return  testRepository.fetchSubject();
	}
	
	
	//save user result in exam table
	public boolean checkStatus(Exam exam) {
		LocalDateTime endTime=LocalDateTime.now();
		LocalDateTime startTime=questionController.getStartTime();
		exam.setStartTime(startTime);
		exam.setEndTime(endTime);
		System.out.println(startTime);
		System.out.println(endTime);
		if(exam.getMarks()>=(0.5*20)) {
			exam.setStatus(true);
			return true;
		}
		else {
		
			return false;
		}
	}
	
	public Exam insertUserResponse(Exam exam) {
		Exam updatedExam=(Exam) testRepository.save(exam);
		return updatedExam;
	}
	
	public String getSubjectName(int id) {
		String subjectName=testRepository.getSubjectName(id);
		return subjectName;
	}
	
	//Save User response
	 public boolean saveUserResponse(Response response) {
	
		 if(testRepository.responsePresent(response.getQuestion().getQuestionId(),response.getExam().getExamId())) {
					throw new UserServiceException("Response Already submitted ");
			}
			else {
					testRepository.save(response);
					return true;
			}
		
	}
	 
	public int getTestRepot(Exam e) {

		int marks=testRepository.getTestReport(e.getExamId());
		
		return marks;
	}
}
