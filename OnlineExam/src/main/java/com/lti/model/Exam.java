package com.lti.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exam_data")
public class Exam {
	@Id
	@Column(name="examId")
	private int examId;
	
	@Column(name="studentId")
	private int studentId;
	
	@Column(name="subjectId")
	private int subjectId;
	
	@Column(name="score")
	private int score;
	
	@Column(name="level")
	private int level;
	
	@Column(name="start")
	private LocalDate start;
	
	@Column(name="end")
	private LocalDate end;
	
	@Column(name="status")
	private boolean status;
	
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public LocalDate getStart() {
		return start;
	}
	public void setStart(LocalDate start) {
		this.start = start;
	}
	public LocalDate getEnd() {
		return end;
	}
	public void setEnd(LocalDate end) {
		this.end = end;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Exam(int examId, int studentId, int subjectId, int score, int level, LocalDate start, LocalDate end,
			boolean status) {
		super();
		this.examId = examId;
		this.studentId = studentId;
		this.subjectId = subjectId;
		this.score = score;
		this.level = level;
		this.start = start;
		this.end = end;
		this.status = status;
	}
	public Exam() {
		super();
	}
	

}
