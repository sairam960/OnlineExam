package com.lti.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="exam_data")
public class Exam {
	@Id
	@Column(name="examId")
	private int examId;
	
	
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
	
	@OneToOne
	@JoinColumn(name="studentId")
	private StudentData stud;
	
	@ManyToOne
	@JoinColumn(name="subjectId")
	private Subject sub;
	
	@OneToOne
	@JoinColumn(name="responseId")
	private Response res;

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
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
	
	public StudentData getStud() {
		return stud;
	}

	public void setStud(StudentData stud) {
		this.stud = stud;
	}

	public Subject getSub() {
		return sub;
	}

	public void setSub(Subject sub) {
		this.sub = sub;
	}

	public Response getRes() {
		return res;
	}

	public void setRes(Response res) {
		this.res = res;
	}

	public Exam(int examId, int score, int lvl, LocalDate starttime, LocalDate endtime, boolean status,
			StudentData stud, Subject sub, Response res) {
		super();
		this.examId = examId;
		this.score = score;
		this.lvl = lvl;
		this.starttime = starttime;
		this.endtime = endtime;
		this.status = status;
		this.stud = stud;
		this.sub = sub;
		this.res = res;
	}

	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
