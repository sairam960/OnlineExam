package com.lti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.model.Response;


@Repository
public interface ResponseRepository extends JpaRepository<Response, Integer>{

}
