
package com.lti.service;

import java.util.List;

import com.lti.model.Subject;

public interface SubjectService
{

    public boolean addSubject(Subject subject);
	
	public List<Subject> getSubject();
	
	public boolean deleteSubject(Subject subject);

}
