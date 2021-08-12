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
	
	@Column(name="lvl")
	private int lvl;
	
	@Column(name="starttime")
	private LocalDate starttime;
	
	@Column(name="endtime")
	private LocalDate endtime;
	
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

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public LocalDate getStarttime() {
		return starttime;
	}

	public void setStarttime(LocalDate starttime) {
		this.starttime = starttime;
	}

	public LocalDate getEndtime() {
		return endtime;
	}

	public void setEndtime(LocalDate endtime) {
		this.endtime = endtime;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Exam(int examId, int studentId, int subjectId, int score, int lvl, LocalDate starttime, LocalDate endtime,
			boolean status) {
		super();
		this.examId = examId;
		this.studentId = studentId;
		this.subjectId = subjectId;
		this.score = score;
		this.lvl = lvl;
		this.starttime = starttime;
		this.endtime = endtime;
		this.status = status;
	}

	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
