package com.lti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.model.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer>{

}
