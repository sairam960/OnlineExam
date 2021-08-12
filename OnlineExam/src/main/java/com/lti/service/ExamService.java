package com.lti.service;

import java.util.List;

import com.lti.model.Exam;

public interface ExamService {
	
	public boolean addQuestions(Exam exam);
	
	public List<Exam> getExam();
	
	public boolean deleteExam(Exam exam);
	
}
