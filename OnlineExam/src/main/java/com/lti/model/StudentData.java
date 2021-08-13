package com.lti.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="student_data")
public class StudentData {
	
	@Id
	@Column(name="studentid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studid_generator")
	@SequenceGenerator(name = "studid_generator", initialValue = 110, allocationSize = 1, sequenceName = "studentid_seq")
	private int studentid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="mobile")
	private long mobile;
	
	@Column(name="dob")
	private Date dateOfBirth;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="qualification")
	private String qualification;
	
	@Column(name="yearofcompletion")
	private Date yearOfCompletion;
	
	public StudentData() {
		super();
	}
	public StudentData(int studentId, String name, String email, String password, long mobile, Date dateOfBirth,
			String city, String state, String qualification, Date yearOfCompletion, int studentid) {
		super();
		this.studentid = studentid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.dateOfBirth = dateOfBirth;
		this.city = city;
		this.state = state;
		this.qualification = qualification;
		this.yearOfCompletion = yearOfCompletion;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public Date getYearOfCompletion() {
		return yearOfCompletion;
	}
	public void setYearOfCompletion(Date yearOfCompletion) {
		this.yearOfCompletion = yearOfCompletion;
	}
	
}
