package com.lti.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.dto.UserReportStatus;
import com.lti.entity.Exam;
import com.lti.entity.Question;
import com.lti.entity.Response;
import com.lti.entity.Subject;
import com.lti.exception.UserServiceException;
import com.lti.service.TestService;

@RestController
@CrossOrigin
public class TestController {

	@Autowired 
	 private TestService testService;
	
	@GetMapping("/getSubject")
	public List<Subject> getSubjects() {
		
		List<Subject> list=testService.get();	
		return list;
	}
	
	@PostMapping("/insert")
	public UserReportStatus insertUserReport(@RequestBody Exam exam) {
		try {
			 
			 if(testService.checkStatus(exam)) {
				int marks=exam.getMarks();
				Exam updatedExam=(Exam)testService.insertUserResponse(exam);
				int examId=updatedExam.getExamId();
				int level=updatedExam.getLevel();
				UserReportStatus status=new UserReportStatus();
				
				status.setMarks(marks);
				status.setExamId(examId);
				status.setLevel(level);
				status.setStatus(true);
				status.setMessage("You have Successfully completed and the Test and Your Score Is: "+ marks + " Hurray you have clared the test");
				
				return status;
			}
			else {
				int marks=exam.getMarks();
				Exam updatedExam=(Exam)testService.insertUserResponse(exam);
				int examId=updatedExam.getExamId();
				int level=updatedExam.getLevel();
				
				UserReportStatus status=new UserReportStatus();
				
				status.setMarks(marks);
				status.setExamId(examId);
				status.setLevel(level);
				status.setStatus(false);
				status.setMessage("You have completed the Test and Your Score Is: "+ marks +" U just missed!! You can give Retest after 24 hours");
				
				return status;
			}
			
		}
		catch(UserServiceException e) {
			
			UserReportStatus status=new UserReportStatus();
			status.setMarks(exam.getMarks());
			status.setExamId(exam.getExamId());
			status.setLevel(exam.getLevel());
			status.setStatus(false);
			status.setMessage("Test Did not submit Successfully!! Please Contact The admin");
			return status;
		}
		
		
	}
	
	
	@PostMapping("/save")
	public Status saveResponse(@RequestBody Response response) {
		try {
			
				if(testService.saveUserResponse(response)) {
					Status status=new Status();
					status.setStatus(true);
					status.setMessage("Response Submitted Succcessfully!!!!");
					return status;
				}
				else {
					Status status=new Status();
					status.setStatus(false);
					status.setMessage("Response not saved");
					return status;
				}
		}
		catch(UserServiceException e) {
			e.printStackTrace();
			Status status=new Status();
			status.setStatus(false);
			status.setMessage("Response not saved Please Contact the Authority");
			return status;
		}
	}
	
	@PostMapping("/getTestReport")
	public UserReportStatus getTestReport(@RequestBody Exam e) {
		System.out.println(e.getUser().getUserId());
		try {
			int marks=testService.getTestRepot(e);
			if(marks>=(0.5*20)){
				UserReportStatus status=new UserReportStatus();
				status.setExamId(e.getExamId());
				status.setLevel(e.getLevel());
				status.setMarks(marks);
				status.setStatus(true);
				status.setMessage("Hurray You Have Cleared the test!! Here is Your Score");
				
				return status;
			}
			else {
				UserReportStatus status=new UserReportStatus();
				status.setExamId(e.getExamId());
				status.setLevel(e.getLevel());
				status.setMarks(marks);
				status.setStatus(false);
				status.setMessage("OOps You have Just Missed it !! Here is Score!! Better Luck Next Time");
				
				return status;
			}
		}
		catch(UserServiceException e1){
			e1.printStackTrace();
			UserReportStatus status=new UserReportStatus();
			status.setStatus(false);
			status.setMessage("There Was Some Error Processing Your Result!!Please Contact:+91 8369011203");
			
			return status;
		}
	}
	
}
