package com.lti.service;

import java.util.List;

import com.lti.model.Response;

public interface ResponseService {
	
	public boolean addResponse(Response response);
	
	public List<Response> getResponse();
	
	

}
