package com.lti.service;

import java.util.List;

import com.lti.model.StudentData;

public interface StudentService {
	
	public List<StudentData> getStudents();
	
	public boolean addStudent(StudentData student);
	
	public StudentData fetchStudentByEmail(String email);
	
	public StudentData fetchStudentByEmailAndPassword(String email, String password);
	
}
