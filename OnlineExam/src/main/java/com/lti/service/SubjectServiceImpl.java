package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.Subject;
import com.lti.repository.SubjectRepository;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired 
	SubjectRepository subrepo;

	@Override
	public boolean addSubject(Subject subject) {
		subrepo.save(subject);
		return true;
	}

	@Override
	public List<Subject> getSubject() {
		return subrepo.findAll();
	}
	
	//delete not working
	@Override
	public boolean deleteSubject(Subject subject) {
		subrepo.delete(subject);
		return true;
	}

	

}

