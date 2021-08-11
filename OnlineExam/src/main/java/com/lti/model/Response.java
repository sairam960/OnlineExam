package com.lti.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Response")
public class Response {
	@Id
	@Column(name="responseId")
	private int responseId;
	@Column(name="examId")
	private int examId;
	@Column(name="studentId")
	private String studentId;
	@Column(name="status")
	private String status;
	@Column(name="answers")
	private List<String> answers=new ArrayList<>();
	@Column(name="correct")
	private List<String> correct=new ArrayList<>();
	private int score;
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Response(int responseId, int examId, String studentId, String status, List<String> answers,
			List<String> correct, int score) {
		super();
		this.responseId = responseId;
		this.examId = examId;
		this.studentId = studentId;
		this.status = status;
		this.answers = answers;
		this.correct = correct;
		this.score = score;
	}
	public int getResponseId() {
		return responseId;
	}
	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	
	
}
