package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="student_id")
	private int studentid;
	
	@Column(name="student_name")
	private String studentname;
	
	@Column(name="student_email")
	private String studentemail;
	
	public int getUserId() {
		return studentid;
	}
	
	public void setUserId(int studentid) {
		this.studentid = studentid;
	}
	
	public String getUserName() {
		return studentname;
	}
	
	public void setUserName(String studentname) {
		this.studentname = studentname;
	}
	
	public String getEmail() {
		return studentemail;
	}
	
	public void setEmail(String studentemail) {
		this.studentemail = studentemail;
	}	
}