package com.lti.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Subjects_data")
public class Subject {
	@Id
	@Column(name="subjectId")
	private int subjectId;
	@Column(name="subjectName")
	private String subjectName;
	
	@OneToMany(mappedBy = "subject")
	@JsonIgnore
	private List<Questions>questions;
	
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subject(int subjectId, String subjectName) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	

}
