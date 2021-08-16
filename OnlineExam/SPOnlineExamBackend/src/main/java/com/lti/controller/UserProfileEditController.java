package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.service.UserProfileEditService;

@RestController
@CrossOrigin
public class UserProfileEditController {
	
	@Autowired
	private UserProfileEditService userProfileEditService;
	
	@GetMapping("/editName")
	public String nameUpdate(@RequestParam("id") int id, @RequestParam("name") String name) {
		return userProfileEditService.updateNameOfUser(id, name);
	}
	
	@GetMapping("/editEmail")
	public String emailUpdate(@RequestParam("id") int id, @RequestParam("email") String email) {
		return userProfileEditService.updateEmailOfUser(id, email);
	}
	
	@GetMapping("/editQualification")
	public String qualificationUpdate(@RequestParam("id") int id, @RequestParam("qualification") String qualification) {
		return userProfileEditService.updateQualificationOfUser(id, qualification);
	}

}
