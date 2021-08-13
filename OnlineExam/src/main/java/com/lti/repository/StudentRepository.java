package com.lti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.model.StudentData;


@Repository
public interface StudentRepository extends JpaRepository<StudentData, Integer> {

	public StudentData findByEmail(String email);
	
	public StudentData findByEmailAndPassword(String email, String password);
	
	
}