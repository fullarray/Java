package com.herrj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "USER_TBL")
public class User {

   @Id
   @GeneratedValue
   @Column(name = "UID")
   private Long id;

   @Column(name = "NAME")
   @Size(max = 20, min = 3, message = "{user.name.invalid}")
   private String name;

   @Column(name = "COURSE")
   @Size(max = 20, min = 3, message = "{user.course.invalid}")
   private String course;
   
   @Column(name = "EMAIL", unique = true)
   @Email(message = "{user.email.invalid}")
   private String email;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCourse() {
		return course;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	   //Getter and Setter methods
	   //...
	   
}
