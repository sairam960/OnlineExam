package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Response;
import com.lti.service.ResponseService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/response/api")
public class ResponseController {
	
	@Autowired
	ResponseService resService;
	
	@GetMapping("/add")
	public List<Response> getAll()
	{
		return resService.getResponse();
	}
	
	@PostMapping("/add")
	public boolean addResponse(@RequestBody Response response)
	{
		return resService.addResponse(response);
	}
	
	

}