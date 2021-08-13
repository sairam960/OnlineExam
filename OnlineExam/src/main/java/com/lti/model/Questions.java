package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="question_data")
public class Questions {
	
	@Id
	@Column(name="quesid")
	private int quesid;
	
	@Column(name="lvl")
	private int lvl;
	
	@Column(name="question")
	private String question;
		
	@Column(name="op1")
	private String op1;
	
	@Column(name="op2")
	private String op2;
	
	@Column(name="op3")
	private String op3;
	
	@Column(name="op4")
	private String op4;
	
	@Column(name="ans")
	private String ans;
	
	@ManyToOne
	//@JsonIgnore
	@JoinColumn(name="subjectId")
	private Subject subject;

	public int getQuesid() {
		return quesid;
	}

	public void setQuesid(int quesid) {
		this.quesid = quesid;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOp1() {
		return op1;
	}

	public void setOp1(String op1) {
		this.op1 = op1;
	}

	public String getOp2() {
		return op2;
	}

	public void setOp2(String op2) {
		this.op2 = op2;
	}

	public String getOp3() {
		return op3;
	}

	public void setOp3(String op3) {
		this.op3 = op3;
	}

	public String getOp4() {
		return op4;
	}

	public void setOp4(String op4) {
		this.op4 = op4;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	

}
