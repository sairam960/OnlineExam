package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.repository.UserProfileEditRepository;

@Service
@Transactional
public class UserProfileEditService {
	
	@Autowired
	private UserProfileEditRepository userProfileEditRepository;
	
	public String updateNameOfUser(int id, String name) {
		
		if(userProfileEditRepository.updateName(id, name)) {
			return "Name Updated";
		} else {
			return "Name not Updated";
		}
	}
	
	public String updateEmailOfUser(int id, String email) {
		
		if(userProfileEditRepository.updateEmail(id, email)) {
			return "Email Updated";
		} else {
			return "Email not Updated";
		}
	}

	public String updateQualificationOfUser(int id, String qualification) {
	
	if(userProfileEditRepository.updateQualification(id, qualification)) {
		return "Qualification Updated";
	} else {
		return "Qualificatio not Updated";
	}
}

}
