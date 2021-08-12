package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Subject;
import com.lti.service.SubjectService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/subject/api")
public class SubjectController {
	
	@Autowired
	SubjectService subService;
	
	@GetMapping("/add")
	public List<Subject> getAll()
	{
		return subService.getSubject();
	}
	
	@PostMapping("/add")
	public boolean addSubject(@RequestBody Subject subject)
	{
		return subService.addSubject(subject);
	}
	
	@DeleteMapping("/add")
	public boolean delete(Subject subject)
	{
		return subService.deleteSubject(subject);
	}

}

