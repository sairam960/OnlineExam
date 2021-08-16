package com.lti.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user_tbl")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="my_seq")
	@SequenceGenerator(sequenceName="user_seq",allocationSize=1,name="my_seq")
	@Column(name="user_id")
	int userId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String emailId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="mobile_number")
	private long mobileNo;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="dob")
	private LocalDate dateOfBirth;
	
	@Column(name="qualification")
	private String qualification;
	
	@Column(name="year_of_completion")
	private LocalDate yearOfQualification;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Exam> exams;
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public LocalDate getYearOfQualification() {
		return yearOfQualification;
	}

	public void setYearOfQualification(LocalDate yearOfQualification) {
		this.yearOfQualification = yearOfQualification;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
