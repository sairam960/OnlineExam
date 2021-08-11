package com.lti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.model.Questions;


@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Integer>{

}
