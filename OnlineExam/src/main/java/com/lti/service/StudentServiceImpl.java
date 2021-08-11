package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.StudentData;
import com.lti.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studRepo;
	
	@Override
	public List<StudentData> getStudents() {
		return studRepo.findAll();
	}

	@Override
	public boolean addStudent(StudentData student) {
		studRepo.save(student);
		return true;
	}

}
