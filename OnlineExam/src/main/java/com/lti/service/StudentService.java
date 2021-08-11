package com.lti.service;

import java.util.List;

import com.lti.model.StudentData;

public interface StudentService {
	
	public List<StudentData> getStudents();
	
	public boolean addStudent(StudentData student);
	
//	public boolean updateStudent(StudentData student);
//	
//	public boolean deleteStudent(int studentid);
	 
}
