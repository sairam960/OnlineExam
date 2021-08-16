package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Response")
public class Response {
	@Id
	@Column(name="responseId")
	private int responseId;
	@Column(name="answers")
	private String answers;
	@Column(name="correct")
	private String correct;
	
	@OneToOne
	@JoinColumn(name="studentid")
	private StudentData stud;
	@ManyToOne
	@JoinColumn(name="subjectId")
	private Subject sub;
	
	public Response() {
		super();
	}
	
	public int getResponseId() {
		return responseId;
	}
	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}
	public String getAnswers() {
		return answers;
	}
	public void setAnswers(String answers) {
		this.answers = answers;
	}
	public String getCorrect() {
		return correct;
	}
	public void setCorrect(String correct) {
		this.correct = correct;
	}
	
	public Response(int responseId, String answers, String correct) {
		super();
		this.responseId = responseId;
		this.answers = answers;
		this.correct = correct;
	}
	
	
	
}
