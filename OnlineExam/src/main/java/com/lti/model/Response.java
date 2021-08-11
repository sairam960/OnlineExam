package com.lti.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Response")
public class Response {
	@Id
	@Column(name="responseId")
	private int responseId;
	@Column(name="answers")
	private List<String> answers=new ArrayList<String>();
	@Column(name="correct")
	private List<String> correct=new ArrayList<String>();
	//@ManyToOne(mappedby="")
	private Exam exam;
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getResponseId() {
		return responseId;
	}
	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}
	public List<String> getAnswers() {
		return answers;
	}
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	public List<String> getCorrect() {
		return correct;
	}
	public void setCorrect(List<String> correct) {
		this.correct = correct;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public Response(int responseId, List<String> answers, List<String> correct, Exam exam) {
		super();
		this.responseId = responseId;
		this.answers = answers;
		this.correct = correct;
		this.exam = exam;
	}
	
	
	
}
