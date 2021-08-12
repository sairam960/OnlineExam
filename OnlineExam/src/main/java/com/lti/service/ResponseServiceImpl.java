package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.Response;
import com.lti.repository.ResponseRepository;

@Service
@Transactional
public class ResponseServiceImpl implements ResponseService {
	
	@Autowired 
	ResponseRepository resrepo;

	@Override
	public boolean addResponse(Response response) {
		resrepo.save(response);
		return true;
	}

	@Override
	public List<Response> getResponse() {
		return resrepo.findAll();
	}
	
	
	

}