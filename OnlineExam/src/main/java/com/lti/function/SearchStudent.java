package com.lti.function;

public class SearchStudent {
	private String technology;
	private String state;
	private String city;
	private int level;
	private int marks;
	public SearchStudent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchStudent(String technology, String state, String city, int level, int marks) {
		super();
		this.technology = technology;
		this.state = state;
		this.city = city;
		this.level = level;
		this.marks = marks;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	

}
