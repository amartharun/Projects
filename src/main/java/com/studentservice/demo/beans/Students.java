package com.studentservice.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Students")
public class Students {
	
	@Id
	@Column(name="id")
	int id;
	
	@Column(name="name")
	String Name;
	
	@Column(name="dept")
	String dept;
	
	public Students() {
		
	}
	public Students(int id, String Name, String dept) {
		this.id=id;
		this.Name=Name;
		this.dept=dept;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String Name) {
		this.Name=Name;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setDept(String dept) {
		this.dept=dept;
	}
	
	public String getDept() {
		return dept;
	}
	

}
