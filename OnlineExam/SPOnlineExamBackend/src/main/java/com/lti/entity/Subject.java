package com.lti.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="subject_tbl")
public class Subject {
	
	@Id
	@Column(name="subject_id")
	private int subjectId;
	
	@Column(name="subject_name")
    private String name;
	
	@OneToMany(mappedBy = "subject")
	@JsonIgnore
	private List<Exam> exams;
	
	@OneToMany(mappedBy = "subject")
	@JsonIgnore
	private List<Question>questions;
	
	

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
	
	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	
}
