package com.example.Day6.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="College")
public class CollegeModel {
	@Id
	private int rollno;
	private String studentname;
    private int collegecode;
    private String department;
    private String city;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public int getCollegecode() {
		return collegecode;
	}
	public void setCollegecode(int collegecode) {
		this.collegecode = collegecode;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	} 
    
}

